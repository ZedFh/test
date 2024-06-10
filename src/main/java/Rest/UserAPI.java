package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import DAO.User;
import Manager.ManageDAO;

@Path("/user")
public class UserAPI {



    @GET
    @Path("/get/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserById(@PathParam("id") Integer id) {
    	ManageDAO<User> uM = new ManageDAO<User>(User.class);
    	User u = (User) uM.getObjectById(id);
        return u.toString();
    }
}
