package org.example.ws;

import javax.jws.WebService;
import java.util.Date;

@WebService(endpointInterface = "org.example.ws.IBanque")
public class BanqueImp implements IBanque {

    @Override
    public double consulterSolde(int id) {
        return 5000.0;
    }

    @Override
    public boolean retirer(int id, double montant) {
        return true;
    }

    @Override
    public boolean deposer(int id, double montant) {
        return true;
    }

    @Override
    public Compte getCompte(int id) {
        return new Compte(id, 5000.0, new Date());
    }
}