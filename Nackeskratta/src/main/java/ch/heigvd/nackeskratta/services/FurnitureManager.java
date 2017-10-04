package ch.heigvd.nackeskratta.services;

import ch.heigvd.nackeskratta.model.Category;
import ch.heigvd.nackeskratta.model.Furniture;
import ch.heigvd.nackeskratta.model.Material;
import java.awt.Color;

/**
 *
 * @author Remi
 */
public class FurnitureManager {
    
    public Furniture getRandomFurniture(){
	return new Furniture("hasskendra", Category.MEATBALL, Material.HORSE, Color.BLUE, 500);
    }
    
}
