package ch.heigvd.nackeskratta.services.dao;

import ch.heigvd.nackeskratta.model.Furniture;
import javax.ejb.Local;

@Local
public interface FurnituresManagerLocal {
	public Furniture getRandomFurniture();
}
