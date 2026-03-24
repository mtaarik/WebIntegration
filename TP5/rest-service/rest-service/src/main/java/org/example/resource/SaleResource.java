package org.example.resource;

import io.swagger.annotations.Api;
import org.example.model.Sale;
import org.example.service.SaleService;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/sales")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Api(value = "sales")
public class SaleResource {
    private SaleService saleService = new SaleService();

    @GET
    public List<Sale> getSales() {
        return saleService.getAllSales();
    }

    @GET
    @Path("/{id}")
    public Response getSale(@PathParam("id") Long id) {
        Sale s = saleService.getSaleById(id);
        if (s == null) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(s).build();
    }

    @POST
    public Response createSale(Sale sale) {
        Sale created = saleService.addSale(sale);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSale(@PathParam("id") Long id) {
        if (saleService.deleteSale(id)) return Response.noContent().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/count")
    public int getCount() {
        return saleService.countSales();
    }
}