package org.example.ws;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "org.example.ws.IElectroShop")
public class ElectroShopImp implements IElectroShop {

    @Override
    public boolean ajouterVente(String magasin, String produit, int quantite, double prixUnitaire, Date dateVente) {
        System.out.println("Vente ajoutee au magasin " + magasin + " : " + quantite + "x " + produit);
        return true;
    }

    @Override
    public double consulterCA(String magasin, Date dateDebut, Date dateFin) {
        return 24500.75;
    }

    @Override
    public List<String> topProduits(String magasin, Date dateDebut, Date dateFin, int n) {
        List<String> top = new ArrayList<>();
        top.add("PC Portable HP");
        top.add("Samsung Galaxy S24");
        top.add("TV Sony 4K");
        return top.subList(0, Math.min(n, top.size()));
    }

    @Override
    public double predireVentes(String magasin, Date jour) {
        double[] ventesDerniersJours = {1200, 1300, 1250, 1400, 1350};
        
        double sommeX = 0, sommeY = 0, sommeXY = 0, sommeX2 = 0;
        int n = ventesDerniersJours.length;
        
        for (int i = 0; i < n; i++) {
            sommeX += i;
            sommeY += ventesDerniersJours[i];
            sommeXY += i * ventesDerniersJours[i];
            sommeX2 += i * i;
        }
        
        double pente = (n * sommeXY - sommeX * sommeY) / (n * sommeX2 - sommeX * sommeX);
        double ordonnee = (sommeY - pente * sommeX) / n;
        
        return pente * n + ordonnee;
    }
}