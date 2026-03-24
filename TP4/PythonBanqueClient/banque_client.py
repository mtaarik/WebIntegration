from zeep import Client

wsdl_url = 'http://localhost:9091/banque?wsdl'

print("Lancement du client Python Bancaire...")

try:
    client = Client(wsdl=wsdl_url)
    
    solde = client.service.consulterSolde(1)
    print(f"Solde du compte 1 : {solde}")
    
    compte = client.service.getCompte(1)
    print("Objet Compte recu :")
    print(compte)

except Exception as e:
    print(f"Erreur : {e}")