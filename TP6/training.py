from sklearn.tree import DecisionTreeClassifier 
import pickle 

data = [
    {"price": 50, "in_stock": 1, "sales": 200, "views": 1000, "label": "High"}, 
    {"price": 1200, "in_stock": 1, "sales": 20, "views": 200, "label": "Low"}, 
    {"price": 300, "in_stock": 1, "sales": 80, "views": 500, "label": "Medium"}, 
    {"price": 20, "in_stock": 1, "sales": 300, "views": 1500, "label": "High"} 
]

# Préparation X, y 
X = [[d["price"], d["sales"], d["views"]] for d in data]
y = [d["label"] for d in data] 

# Entraînement et sauvegarde
model = DecisionTreeClassifier()
model.fit(X, y) 

with open("model.pkl", "wb") as f: 
    pickle.dump(model, f) 