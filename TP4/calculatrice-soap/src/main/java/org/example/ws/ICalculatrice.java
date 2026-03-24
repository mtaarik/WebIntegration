package org.example.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface ICalculatrice {

    @WebMethod
    double add(@WebParam(name = "nbr1") double x, @WebParam(name = "nbr2") double y);

    @WebMethod
    double multiply(@WebParam(name = "nbr1") double x, @WebParam(name = "nbr2") double y);

    @WebMethod
    double subtract(@WebParam(name = "nbr1") double x, @WebParam(name = "nbr2") double y);

    @WebMethod
    double divide(@WebParam(name = "nbr1") double x, @WebParam(name = "nbr2") double y) throws ArithmeticException;
}