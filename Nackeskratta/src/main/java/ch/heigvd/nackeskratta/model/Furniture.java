package ch.heigvd.nackeskratta.model;

import java.awt.Color;

public class Furniture {

	private String name;
	private Category category;
	private Material material;
	private Color color;
	private double price;

	private String imageUrl;

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Furniture(String name, Category cat, Material mat, Color col, double price) {
		this.name = name;
		this.category = cat;
		this.material = mat;
		this.color = col;
		this.price = price;

		this.imageUrl = "img/" + category.toString().toLowerCase() + ".jpg";
	}

	public String getName() {
		return name;
	}

	public Category getCategory() {
		return category;
	}

	public Material getMaterial() {
		return material;
	}

	public Color getColor() {
		return color;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}
}
