package br.com.fiap.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//caminho da URL
@Path("/empresa")
public class EmpresaResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String buscar() {
		return "Hello World!";
	}
	
}
