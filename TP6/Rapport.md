# TP 6 : Systemes Distribues & Web Integration - Web Service FastAPI

Ce projet porte sur la conception et le déploiement de services web utilisant le framework FastAPI, avec une application directe aux domaines de la Business Intelligence (BI) et de l'Intelligence Artificielle (IA).

## Configuration de l'environnement

L'environnement a été configuré de manière isolée pour éviter les conflits de versions:

- Création de l'environnement virtuel : `python -m venv venv`
- Activation : `source venv/bin/activate`
- Installation des dépendances : `pip install -r requirements.txt`

Note : Le dossier venv est exclu du dépôt via le fichier .gitignore.

## Description des fichiers du projet

### 1. main.py (Plateforme E-commerce)

Ce fichier constitue le cœur de la première application web service.

- Définition du modèle de données Item via Pydantic pour structurer les produits (nom, prix, stock, ventes, vues)
- Implémentation d'une base de données simulée en mémoire
- Routes CRUD : Création (POST /items/), récupération individuelle (GET /items/{item_id}) et liste complète (GET /items/)
- Routes KPI : Calcul en temps réel du nombre total de produits, de la valeur totale du stock et du nombre d'articles disponibles
- Route de prédiction : Endpoint utilisant un modèle entraîné pour prédire le niveau de demande d'un produit

### 2. training.py

Script dédié à la partie IA de l'étude de cas e-commerce.

- Préparation d'un dataset historique simulant les performances de vente
- Entraînement d'un modèle de classification (Decision Tree Classifier)
- Exportation du modèle sous format binaire model.pkl avec la bibliothèque pickle

### 3. train_bank.py

Script d'analyse pour la deuxième étude de cas (Banque à distance).

- Chargement et nettoyage du dataset réel "Give Me Some Credit"
- Entraînement d'un modèle de Machine Learning pour évaluer la capacité de remboursement des clients
- Génération du fichier de modèle bank_model.pkl

### 4. bank_api.py

Web service spécifique au secteur bancaire.

- Gestion CRUD des profils clients
- Endpoints KPI : Revenu moyen, taux de défaut et identification des clients à risque
- Intégration du modèle prédictif pour classer les demandes de crédit (Accepté / Risque / Refusé)

### 5. app.py (Interface Streamlit)

Interface utilisateur interactive pour la banque à distance.

- Dashboard : Visualisation des indicateurs clés de performance via des appels API
- Module de prédiction : Formulaire permettant de tester l'éligibilité d'un nouveau client en temps réel

## Gestion des modèles et données

Conformément aux bonnes pratiques de développement, les fichiers suivants sont exclus du dépôt via le fichier .gitignore :

- Environnements virtuels (venv/)
- Fichiers de cache Python (pycache/)
- Datasets lourds (fichiers .csv)
- Modèles entraînés (fichiers .pkl)

Pour tester les fonctionnalités de prédiction, il est nécessaire d'exécuter les scripts training.py et train_bank.py localement afin de régénérer les fichiers de modèles nécessaires aux APIs.

## Instructions d'exécution

- Entraîner le modèle bancaire : `python train_bank.py`
- Lancer l'API bancaire : `uvicorn bank_api:app --reload`
- Lancer l'interface graphique : `streamlit run app.py`
- Accéder à la documentation interactive : http://127.0.0.1:8000/docs