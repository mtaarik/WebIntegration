package org.example.resource;
import org.example.model.Product;
import org.example.service.ProductService;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private ProductService productService = ProductService.getInstance();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") Long id) {
        Product p = productService.getProductById(id);
        if (p != null) {
            return Response.ok(p).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response createProduct(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Le nom du produit est obligatoire\"}")
                    .build();
        }

        Product created = productService.addProduct(product);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        Product updated = productService.updateProduct(id, product);

        if (updated == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Produit non trouvé\"}")
                    .build();
        }

        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        boolean deleted = productService.deleteProduct(id);

        if (!deleted) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Produit non trouvé\"}")
                    .build();
        }

        return Response.ok("{\"message\": \"Produit supprimé avec succès\"}")
                .build();
    }

    /**
     * GET /products/search?q=keyword
     * Rechercher des produits
     */
    @GET
    @Path("/search") //GET /products/search?q=keyword
    public Response searchProducts(@QueryParam("q") String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"Le paramètre 'q' est obligatoire\"}")
                    .build();
        }


        List<Product> results = productService.searchProducts(keyword);
        return Response.ok(results).build();
    }

    @POST
    @Path("/form")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createProductFromForm(
            @FormParam("name") String name,
            @FormParam("price") double price) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        Product created = productService.addProduct(product);
        return Response.status(Response.Status.CREATED)
                .entity(created)
                .build();
    }
    @GET
    @Path("/uri-info")
    public Response getInformationURIInfo(@Context UriInfo uriInfo) {

        String baseUri = uriInfo.getBaseUri().toString();          // URI de base
        String absolutePath = uriInfo.getAbsolutePath().toString();// Chemin complet
        String path = uriInfo.getPath();                           // Chemin relatif
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters(); // Paramètres ?q=
        String result = "{"
                + "\"baseUri\":\"" + baseUri + "\","
                + "\"absolutePath\":\"" + absolutePath + "\","
                + "\"path\":\"" + path + "\","
                + "\"queryParams\":\"" + queryParams.toString() + "\""
                + "}";

        return Response.ok(result).build();
    }
    /**
     * GET /products/count
     * Compter le nombre de produits
     */
    @GET
    @Path("/count")
    public Response countProducts() {
        int count = productService.countProducts();
        return Response.ok("{\"count\": " + count + "}").build();
    }
}
