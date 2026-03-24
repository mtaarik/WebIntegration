package org.example.ws;

import javax.xml.ws.Endpoint;

public class ServeurElectroShop {
    public static void main(String[] args) {
        String url = "http://localhost:9092/electroshop";
        System.out.println("Demarrage du serveur ElectroShop...");
        Endpoint.publish(url, new ElectroShopImp());
        System.out.println("Service deploye sur " + url);
        System.out.println("WSDL : " + url + "?wsdl");
    }
}