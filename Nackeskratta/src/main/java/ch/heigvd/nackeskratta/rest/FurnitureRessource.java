package ch.heigvd.nackeskratta.rest;

import ch.heigvd.nackeskratta.rest.dto.FurnitureDTO;
import ch.heigvd.nackeskratta.services.dao.FurnituresManagerLocal;
import java.net.URI;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("/furniture")
public class FurnitureRessource {
	
	@EJB
	private FurnituresManagerLocal furnituresManagerLocal;
	
	@Context
	UriInfo uriInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFurniture(FurnitureDTO furnitureDTO){
		
		long furnitureId = 20;
		
		URI href = uriInfo.getBaseUriBuilder()
				.path(FurnitureRessource.class)
				//.path(FurnitureRessource.class, "getFurniture")
				.build(furnitureId);
		
		return Response.created(href).build();
	}
	
}
