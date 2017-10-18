package ch.heigvd.nackeskratta.services.dao;

import ch.heigvd.nackeskratta.model.Category;
import ch.heigvd.nackeskratta.model.Furniture;
import ch.heigvd.nackeskratta.model.Material;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class FurnituresManager implements FurnituresManagerLocal {

	@Resource(lookup = "java:/jdbc/ikea")
	private DataSource dataSource;

	@Override
	public Furniture getRandomFurniture() {
		Furniture furniture = null;

		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM furnitures "
					+ "INNER JOIN color ON colorID = color.id "
					+ "INNER JOIN material ON materialID = material.id "
					+ "INNER JOIN category ON categoryID = category.id "
					+ "ORDER BY RAND() "
					+ "LIMIT 10");

			ResultSet results = statement.executeQuery();

			while (results.next()) { //Pour chaque enregistrement
				long id = results.getLong("id");
				String name = results.getString("name");
				Color color = Color.getColor(results.getString("color.name"));
				Material material = Material.valueOf(results.getString("material.name").toUpperCase());
				Category category = Category.valueOf(results.getString("category.name").toUpperCase());
				double price = results.getDouble("price");

				furniture = new Furniture(id, name, category, material, color, price);
				break;
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
		return furniture;
	}

}
