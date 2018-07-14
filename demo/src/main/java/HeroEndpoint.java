import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hero")
@ApplicationScoped
public class HeroEndpoint {
    private Hero hero = new Hero();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response doGet() {
		return Response.ok(hero).build();
	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/direct")
    public Hero doGetHero() {
        return hero;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/set")
    public Hero setHero(@QueryParam("name") String pName) {
        hero.setName(pName);
        return hero;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/formset")
    public Hero setFornHero(@FormParam("name") String pName) {
        hero.setName(pName);
        return hero;
    }
}
