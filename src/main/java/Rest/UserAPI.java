package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserAPI {

    public UserAPI() {
        // Constructor
    }

    @GET
    @Path("/get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserById() {
    	System.out.println("333");
        return "test";
    }
}
