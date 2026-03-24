package org.example;

import com.example.banque.client.BanqueImpService;
import com.example.banque.client.IBanque;
import com.example.banque.client.Compte;

public class Main {
    public static void main(String[] args) {
        System.out.println("Demarrage du client bancaire...");

        BanqueImpService service = new BanqueImpService();
        IBanque proxy = service.getBanqueImpPort();

        double solde = proxy.consulterSolde(1);
        System.out.println("Le solde du compte 1 est : " + solde);

        boolean retraitReussi = proxy.retirer(1, 500);
        System.out.println("Retrait de 500 reussi ? " + retraitReussi);

        Compte monCompte = proxy.getCompte(1);
        System.out.println("Details du compte recu :");
        System.out.println(" - ID : " + monCompte.getId());
        System.out.println(" - Solde : " + monCompte.getSolde());
    }
}