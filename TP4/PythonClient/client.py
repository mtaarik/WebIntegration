from zeep import Client

# L'URL de votre WSDL publié par le serveur Java
wsdl_url = 'http://localhost:9000/calculatrice?wsdl'

print("Lancement du client Python...")
print(f"Connexion au WSDL : {wsdl_url}")

try:
    # Création du client SOAP
    client = Client(wsdl=wsdl_url)
    
    # Appel de la méthode add
    somme = client.service.add(50, 40)
    print(f"Résultat de l'addition (50 + 40) : {somme}")
    
    # Appel de la méthode multiply
    multiplication = client.service.multiply(10, 5)
    print(f"Résultat de la multiplication (10 * 5) : {multiplication}")
    
    # Appel de la méthode subtract
    soustraction = client.service.subtract(100, 30)
    print(f"Résultat de la soustraction (100 - 30) : {soustraction}")
    
    # Appel de la méthode divide
    division = client.service.divide(20, 4)
    print(f"Résultat de la division (20 / 4) : {division}")

except Exception as e:
    print(f"Une erreur s'est produite : {e}")