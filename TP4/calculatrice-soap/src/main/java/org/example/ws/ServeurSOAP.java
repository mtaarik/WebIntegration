package org.example.ws;

import javax.xml.ws.Endpoint;

public class ServeurSOAP {
    public static void main(String[] args) {
        String url="http://localhost:9000/calculatrice";
        System.out.println("demarrage du serveur...");
        Endpoint.publish(url, new CalculatriceImp());
        System.out.println("service soap démarré sur "+url);
        System.out.println("wsdl disponible sur "+url+"?wsdl");
    }
}