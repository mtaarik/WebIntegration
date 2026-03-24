package org.example.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IBanque {
    
    @WebMethod
    double consulterSolde(@WebParam(name = "id") int id);

    @WebMethod
    boolean retirer(@WebParam(name = "id") int id, @WebParam(name = "montant") double montant);

    @WebMethod
    boolean deposer(@WebParam(name = "id") int id, @WebParam(name = "montant") double montant);

    @WebMethod
    Compte getCompte(@WebParam(name = "id") int id);
}