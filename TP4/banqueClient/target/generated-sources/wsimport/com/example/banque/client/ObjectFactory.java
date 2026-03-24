
package com.example.banque.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.banque.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Compte_QNAME = new QName("http://ws.example.org/", "compte");
    private final static QName _ConsulterSolde_QNAME = new QName("http://ws.example.org/", "consulterSolde");
    private final static QName _ConsulterSoldeResponse_QNAME = new QName("http://ws.example.org/", "consulterSoldeResponse");
    private final static QName _Deposer_QNAME = new QName("http://ws.example.org/", "deposer");
    private final static QName _DeposerResponse_QNAME = new QName("http://ws.example.org/", "deposerResponse");
    private final static QName _GetCompte_QNAME = new QName("http://ws.example.org/", "getCompte");
    private final static QName _GetCompteResponse_QNAME = new QName("http://ws.example.org/", "getCompteResponse");
    private final static QName _Retirer_QNAME = new QName("http://ws.example.org/", "retirer");
    private final static QName _RetirerResponse_QNAME = new QName("http://ws.example.org/", "retirerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.banque.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Compte }
     * 
     */
    public Compte createCompte() {
        return new Compte();
    }

    /**
     * Create an instance of {@link ConsulterSolde }
     * 
     */
    public ConsulterSolde createConsulterSolde() {
        return new ConsulterSolde();
    }

    /**
     * Create an instance of {@link ConsulterSoldeResponse }
     * 
     */
    public ConsulterSoldeResponse createConsulterSoldeResponse() {
        return new ConsulterSoldeResponse();
    }

    /**
     * Create an instance of {@link Deposer }
     * 
     */
    public Deposer createDeposer() {
        return new Deposer();
    }

    /**
     * Create an instance of {@link DeposerResponse }
     * 
     */
    public DeposerResponse createDeposerResponse() {
        return new DeposerResponse();
    }

    /**
     * Create an instance of {@link GetCompte }
     * 
     */
    public GetCompte createGetCompte() {
        return new GetCompte();
    }

    /**
     * Create an instance of {@link GetCompteResponse }
     * 
     */
    public GetCompteResponse createGetCompteResponse() {
        return new GetCompteResponse();
    }

    /**
     * Create an instance of {@link Retirer }
     * 
     */
    public Retirer createRetirer() {
        return new Retirer();
    }

    /**
     * Create an instance of {@link RetirerResponse }
     * 
     */
    public RetirerResponse createRetirerResponse() {
        return new RetirerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Compte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Compte }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "compte")
    public JAXBElement<Compte> createCompte(Compte value) {
        return new JAXBElement<Compte>(_Compte_QNAME, Compte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsulterSolde }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsulterSolde }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "consulterSolde")
    public JAXBElement<ConsulterSolde> createConsulterSolde(ConsulterSolde value) {
        return new JAXBElement<ConsulterSolde>(_ConsulterSolde_QNAME, ConsulterSolde.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsulterSoldeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsulterSoldeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "consulterSoldeResponse")
    public JAXBElement<ConsulterSoldeResponse> createConsulterSoldeResponse(ConsulterSoldeResponse value) {
        return new JAXBElement<ConsulterSoldeResponse>(_ConsulterSoldeResponse_QNAME, ConsulterSoldeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Deposer }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "deposer")
    public JAXBElement<Deposer> createDeposer(Deposer value) {
        return new JAXBElement<Deposer>(_Deposer_QNAME, Deposer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeposerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeposerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "deposerResponse")
    public JAXBElement<DeposerResponse> createDeposerResponse(DeposerResponse value) {
        return new JAXBElement<DeposerResponse>(_DeposerResponse_QNAME, DeposerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCompte }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "getCompte")
    public JAXBElement<GetCompte> createGetCompte(GetCompte value) {
        return new JAXBElement<GetCompte>(_GetCompte_QNAME, GetCompte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCompteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "getCompteResponse")
    public JAXBElement<GetCompteResponse> createGetCompteResponse(GetCompteResponse value) {
        return new JAXBElement<GetCompteResponse>(_GetCompteResponse_QNAME, GetCompteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Retirer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Retirer }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "retirer")
    public JAXBElement<Retirer> createRetirer(Retirer value) {
        return new JAXBElement<Retirer>(_Retirer_QNAME, Retirer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetirerResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RetirerResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.example.org/", name = "retirerResponse")
    public JAXBElement<RetirerResponse> createRetirerResponse(RetirerResponse value) {
        return new JAXBElement<RetirerResponse>(_RetirerResponse_QNAME, RetirerResponse.class, null, value);
    }

}
