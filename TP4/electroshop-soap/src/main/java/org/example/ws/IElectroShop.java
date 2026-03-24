package org.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService
public interface IElectroShop {

    @WebMethod
    boolean ajouterVente(@WebParam(name = "magasin") String magasin, @WebParam(name = "produit") String produit, @WebParam(name = "quantite") int quantite, @WebParam(name = "prixUnitaire") double prixUnitaire, @WebParam(name = "dateVente") Date dateVente);

    @WebMethod
    double consulterCA(@WebParam(name = "magasin") String magasin, @WebParam(name = "dateDebut") Date dateDebut, @WebParam(name = "dateFin") Date dateFin);

    @WebMethod
    List<String> topProduits(@WebParam(name = "magasin") String magasin, @WebParam(name = "dateDebut") Date dateDebut, @WebParam(name = "dateFin") Date dateFin, @WebParam(name = "n") int n);

    @WebMethod
    double predireVentes(@WebParam(name = "magasin") String magasin, @WebParam(name = "jour") Date jour);
}