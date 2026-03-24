package org.example;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import java.net.URI;

public class Application {
    // URL de base du serveur REST [cite: 55]
    public static final String BASE_URI = "http://localhost:9090/api/";

    public static HttpServer startServer() {
        // Configuration de Jersey
        final ResourceConfig config = new ResourceConfig()
                // Scanner tes ressources ET Swagger [cite: 118]
                .packages("org.example.resource", "io.swagger.jaxrs.listing")
                .register(ApiListingResource.class)
                .register(SwaggerSerializers.class)
                .property(ServerProperties.WADL_FEATURE_DISABLE, false);

        // Créer et démarrer le serveur Grizzly
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
    }

    public static void main(String[] args) {
        try {
            final HttpServer server = startServer();

            System.out.println("=".repeat(60));
            System.out.println(" Serveur REST démarré avec succès!");
            System.out.println(" URL de base: " + BASE_URI);
            System.out.println(" WADL: " + BASE_URI + "application.wadl");
            System.out.println("=".repeat(60));

            // Ajoute les nouveaux endpoints pour ton CR
            System.out.println("\n Endpoints ElectroShop dispos:");
            System.out.println("  GET    " + BASE_URI + "sales             - Lister les ventes");
            System.out.println("  POST   " + BASE_URI + "sales             - Ajouter une vente");
            System.out.println("  GET    " + BASE_URI + "sales/count       - Nombre de ventes");
            System.out.println("\n" + "=".repeat(60));
            System.out.println("Appuyez sur Entrée pour arrêter le serveur...");

            System.in.read();
            server.shutdownNow();
            System.out.println("\n Serveur arrêté.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}