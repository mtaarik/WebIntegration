package org.example.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "org.example.ws.ICalculatrice")
public class CalculatriceImp implements ICalculatrice {

    @Override
    public double add(double x, double y) {
        System.out.println("addition de "+x+" et "+y);
        return x+y;
    }

    @Override
    public double multiply(double x, double y) {
        System.out.println("multiplication de " +x+ " et "+y);
        return x*y;
    }

    @Override
    public double subtract(double x, double y) {
        System.out.println("soustraction de "+x+" et "+y);
        return x-y;
    }

    @Override
    public double divide(double x, double y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Division par zéro impossible");
        }
        System.out.println("division de "+x+" par "+y);
        return x/y;
    }
}