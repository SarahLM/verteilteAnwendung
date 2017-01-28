package org.htw.fiw.vs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/hello")
public class Hello {

	@GET
	public String hello() {
		return "world!";
	}

	@GET
	@Path("/{user}")
	public String hello(@PathParam("user") String user) {
		return "hello " + user;
	}

}
