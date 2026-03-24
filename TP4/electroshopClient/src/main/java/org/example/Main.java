package org.example;

import com.example.electro.client.ElectroShopImpService;
import com.example.electro.client.IElectroShop;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Demarrage du client ElectroShop...");

            ElectroShopImpService service = new ElectroShopImpService();
            IElectroShop proxy = service.getElectroShopImpPort();

            GregorianCalendar c = new GregorianCalendar();
            c.setTime(new Date());
            XMLGregorianCalendar dateActuelle = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

            boolean ajout = proxy.ajouterVente("Magasin Casa", "Casque Bluetooth", 2, 450.0, dateActuelle);
            System.out.println("Vente ajoutee ? " + ajout);

            double ca = proxy.consulterCA("Magasin Casa", dateActuelle, dateActuelle);
            System.out.println("Chiffre d'affaires : " + ca + " MAD");

            List<String> top = proxy.topProduits("Magasin Casa", dateActuelle, dateActuelle, 3);
            System.out.println("Top produits :");
            for (String produit : top) {
                System.out.println("- " + produit);
            }

            double prediction = proxy.predireVentes("Magasin Casa", dateActuelle);
            System.out.println("Prediction des ventes (Reg. Lineaire) : " + prediction);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}