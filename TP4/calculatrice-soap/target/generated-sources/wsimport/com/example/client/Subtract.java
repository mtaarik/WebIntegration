
package com.example.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subtract complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subtract"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nbr1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="nbr2" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "subtract", propOrder = {
    "nbr1",
    "nbr2"
})
public class Subtract {

    protected double nbr1;
    protected double nbr2;

    /**
     * Gets the value of the nbr1 property.
     * 
     */
    public double getNbr1() {
        return nbr1;
    }

    /**
     * Sets the value of the nbr1 property.
     * 
     */
    public void setNbr1(double value) {
        this.nbr1 = value;
    }

    /**
     * Gets the value of the nbr2 property.
     * 
     */
    public double getNbr2() {
        return nbr2;
    }

    /**
     * Sets the value of the nbr2 property.
     * 
     */
    public void setNbr2(double value) {
        this.nbr2 = value;
    }

}
