package ch.heigvd.nackeskratta.services.dao;

import ch.heigvd.nackeskratta.model.Category;
import ch.heigvd.nackeskratta.model.Furniture;
import ch.heigvd.nackeskratta.model.Material;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class FurnituresManager implements FurnituresManagerLocal {

	@Resource(lookup = "java:/jdbc/ikea")
	private DataSource dataSource;

	private final String[] words;
	private final Random random = new Random();

	public FurnituresManager() throws IOException {
		// On lit la liste de mot suédois
		String fileName = "/swedishWords.txt";

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream(fileName)));

		String line;
		LinkedList<String> lines = new LinkedList<String>();
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		words = lines.toArray(new String[0]);
	}

	/**
	 *
	 * @param page Le numéro de la page, commencant par 0
	 * @return 20 meubles
	 */
	@Override
	public LinkedList<Furniture> getFurnitures(int page, int numberPerPage) {
		LinkedList<Furniture> furnitures = new LinkedList<Furniture>();

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM furnitures "
					+ "INNER JOIN color ON colorID = color.id "
					+ "INNER JOIN material ON materialID = material.id "
					+ "INNER JOIN category ON categoryID = category.id "
					+ "LIMIT " + numberPerPage * page + ", " + numberPerPage);

			ResultSet results = statement.executeQuery();

			while (results.next()) { //Pour chaque enregistrement
				String name = results.getString("name");
				Color color = Color.getColor(results.getString("color.name"));
				Material material = Material.valueOf(results.getString("material.name").toUpperCase());
				Category category = Category.valueOf(results.getString("category.name").toUpperCase());
				double price = results.getDouble("price");

				furnitures.add(new Furniture(name, category, material, color, price));
			}

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return furnitures;
	}

	@Override
	public int getNumberOfFurniture() {
		Connection connection = null;
		int numberOfFurnitures = 0;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) FROM furnitures ");

			ResultSet results = statement.executeQuery();

			results.next();
			numberOfFurnitures = results.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return numberOfFurnitures;
	}

	@Override
	public void generate(int nbToGenerate) {
		while (nbToGenerate > 0) {
			insertRandomFurniture();

			nbToGenerate--;
		}
	}

	@Override
	public void insertRandomFurniture() {
		// On prends 2 mots aléatoire qu'on accole les uns aux autres
		String word1 = words[random.nextInt(words.length)];
		String word2 = words[random.nextInt(words.length)];
		String word = word1 + word2;

		// Couleur et matériaux random
		int colorId = random.nextInt(3) + 1;
		int materialId = random.nextInt(4) + 1;
		int categoryId = random.nextInt(5) + 1;
		double price = random.nextInt(1500) + 1;

		//Ajout à la bdd
		this.insertFurniture(word, materialId, categoryId, price, colorId);

	}

	@Override
	public void insertFurniture(String name, int materialId, int categoryId, double price, int colorId) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("INSERT INTO furnitures (name, materialID, categoryID, price, colorID) VALUES ("
							+ "'" + name + "',"
							+ materialId + ","
							+ categoryId + ","
							+ price + ","
							+ colorId + ")");

			boolean ok = statement.execute();

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	@Override
	public Furniture getFurnitureById(long id) {
		Furniture furniture = null;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM furnitures "
					+ "INNER JOIN color ON colorID = color.id "
					+ "INNER JOIN material ON materialID = material.id "
					+ "INNER JOIN category ON categoryID = category.id "
					+ "WHERE furnitures.id=" + id);

			ResultSet results = statement.executeQuery();

			results.next();  //On récupère l'enregistrement
			String name = results.getString("name");
			Color color = Color.getColor(results.getString("color.name"));
			Material material = Material.valueOf(results.getString("material.name").toUpperCase());
			Category category = Category.valueOf(results.getString("category.name").toUpperCase());
			double price = results.getDouble("price");

			furniture = new Furniture(name, category, material, color, price);

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return furniture;
	}

    @Override
    public void updateFurniture(long id, String name, int materialId, int categoryId, double price, int colorId) {
        Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("UPDATE furnitures SET "
							+ "name = '" + name + "',"
							+ "materialID = " + materialId + ","
							+ "categoryID = " + categoryId + ","
							+ "price = " + price + ","
							+ "colorID = " + colorId + " "
                                                        + "WHERE id = " + id + ";");

			statement.execute();

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
    }

    @Override
    public void deleteFurniture(long id) {
        Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("DELETE FROM furnitures "
							+ "WHERE id = " + id + ";");

			statement.execute();

		} catch (SQLException ex) {
			Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				Logger.getLogger(FurnituresManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
    }
}
