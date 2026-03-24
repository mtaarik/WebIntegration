package org.example;

import com.example.client.ICalculatrice;
import com.example.client.CalculatriceImpService; 

public class Main {
    public static void main(String[] args) {
        System.out.println("Lancement du client...");
        
        CalculatriceImpService service = new CalculatriceImpService();
        ICalculatrice port = service.getCalculatriceImpPort(); 
        
        double sum = port.add(50, 40);
        System.out.println("La somme est : " + sum);
        
        double mult = port.multiply(10, 5);
        System.out.println("La multiplication est : " + mult);
    }
}