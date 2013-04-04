package net.davepkennedy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class HelloService {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Greeting getGreeting (
            @QueryParam("who")
            @DefaultValue("World")
            String who) {
        return new Greeting("Hello", who);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText (
            @QueryParam("who")
            @DefaultValue("World")
            String who
    ) {
        return getGreeting(who).toString();
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml (
            @QueryParam("who")
            @DefaultValue("World")
            String who
    ) {
        return String.format("<!DOCTYPE html><html><head><title>Hello" +
                "</title></head><body>%s</body></html>", getText(who));
    }
}
