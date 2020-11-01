package business;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Album;

@RequestScoped
@Path("/albums")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class AlbumsRestService {
	
	@Inject
	BusinessServiceInterface bs;
	
	
	// get all records and display them in json format
	@GET
	@Path("/getjson")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Album> getAllAlbumsAsJson() {
		return bs.readAll();
	}
	
	// get one record by id and display it in json format
	@GET
	@Path("/getjsonbyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Album getOneAlbumsAsJson(@PathParam("id")int id) {
	return bs.readOne(id);
	
	}
	
	// get a list of records by a search term and display them in json format
	@GET
	@Path("/getjsonbyname/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Album> getOneAlbumsAsJson(@PathParam("name")String name) {
	return bs.searchFor(name);
	
	}
	
	
		
		
	
	
	
	// get all records and display them in xml format
		@GET
		@Path("/getxml")
		@Produces(MediaType.APPLICATION_XML)
		public Album[] getAllAlbumsAsXML() {
			
			List<Album> albums = bs.readAll();
			return albums.toArray(new Album[albums.size()]);
		}
		
		
		

}
