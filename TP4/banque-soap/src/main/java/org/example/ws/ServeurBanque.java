package org.example.ws;

import javax.xml.ws.Endpoint;

public class ServeurBanque {
    public static void main(String[] args) {
        String url = "http://localhost:9091/banque";
        System.out.println("Demarrage du serveur bancaire...");
        Endpoint.publish(url, new BanqueImp());
        System.out.println("Service soap demarre sur " + url);
        System.out.println("WSDL disponible sur " + url + "?wsdl");
    }
}