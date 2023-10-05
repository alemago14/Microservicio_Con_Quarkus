package org.micros;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.micros.entidades.Producto;
import org.micros.repositorios.ProductoRepositorio;

@Path("/producto")
public class ProductoApi {
    
    @Inject
    ProductoRepositorio productoRepositorio;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producto> list() {
        return productoRepositorio.listProduct();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response add(Producto p) {
        productoRepositorio.createdProduct(p);
        return Response.ok().build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public Response delete(Producto p) {
       productoRepositorio.deleteProduct(p);
        return Response.ok().build();
    }
}
