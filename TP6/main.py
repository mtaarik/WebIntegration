from fastapi import FastAPI
from pydantic import BaseModel 
import pickle 
# 1. Initialisation de l'API
app = FastAPI(title="Plateforme E-commerce BI & AI") 

# 2. Modèle de données
class Item(BaseModel):
    name: str
    price: float
    in_stock: bool = True
    sales: int
    views: int

# 3. Base de données en mémoire
db = []

# 4. Chargement du modèle AI 
try:
    with open("model.pkl", "rb") as f:
        model = pickle.load(f)
except FileNotFoundError:
    model = None


@app.get("/")
def read_root():
    return {"message": "Bienvenue sur l'API E-commerce"} 

# Route pour ajouter un produit 
@app.post("/items/")
def create_item(item: Item):
    db.append(item)
    return {"message": "Item créé", "item": item}

# Récupérer un produit par son index
@app.get("/items/{item_id}")
def read_item(item_id: int): 
    return {
        "name": db[item_id].name if item_id < len(db) else "Unknown", 
        "price": db[item_id].price if item_id < len(db) else 0, 
        "in_stock": db[item_id].in_stock if item_id < len(db) else 0, 
        "sales": db[item_id].sales if item_id < len(db) else 0, 
        "views": db[item_id].views if item_id < len(db) else 0
    }

# Lister tous les produits
@app.get("/items/")
def list_items(): 
    return {"items": db, "count": len(db)} 

@app.get("/kpi/total_products")
def total_products():
    return {"total": len(db)} 

@app.get("/kpi/total_value")
def total_value(): 
    total = sum(item.price for item in db) 
    return {"total_value": total} 

@app.get("/kpi/in_stock")
def in_stock_products(): 
    count = sum(1 for item in db if item.in_stock)
    return {"in_stock": count} 

@app.post("/predict")
def predict(item: Item): 
    features = [[item.price, item.sales, item.views]]
    prediction = model.predict(features)[0] 
    return {"prediction": prediction} 
