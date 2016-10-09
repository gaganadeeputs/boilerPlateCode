package org.gagan.sap.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.service.UserService;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class UserResource {

	final static Logger logger = Logger.getLogger(UserResource.class);
	UserService service = new UserService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDTO> getAllUsers() {
		return service.getAllUsers();
	}

	@GET
	@Path("{userId}")
	public UserDTO  getAllUser(@PathParam("userId") int userId) {
		return service.getUser(userId);

	}

	@POST
	public Response addUser(UserDTO user) {
		service.addUser(user);
		return Response. 
				status(Status.CREATED).build();

	}

	@DELETE
	@Path("{userId}")
	public void deleteMessage(@PathParam("userId") int userId) {
		service.deleteUser(userId);
	}

}
