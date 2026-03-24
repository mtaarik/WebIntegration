
package com.example.banque.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deposer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deposer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="montant" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deposer", propOrder = {
    "id",
    "montant"
})
public class Deposer {

    protected int id;
    protected double montant;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the montant property.
     * 
     */
    public double getMontant() {
        return montant;
    }

    /**
     * Sets the value of the montant property.
     * 
     */
    public void setMontant(double value) {
        this.montant = value;
    }

}
