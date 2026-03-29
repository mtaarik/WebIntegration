from fastapi import FastAPI
from pydantic import BaseModel
from typing import List
import pickle

app = FastAPI()

class ClientBank(BaseModel):
    id: int
    age: int
    monthly_income: float
    debt_ratio: float
    open_credit_lines: int
    is_default: int = 0

clients_db: List[ClientBank] = []

with open('bank_model.pkl', 'rb') as f:
    model = pickle.load(f)

@app.post("/clients/")
def add_client(client: ClientBank):
    clients_db.append(client)
    return {"message": "Client added", "client": client}

@app.get("/clients/")
def list_clients():
    return clients_db

@app.get("/kpi/total_clients")
def total_clients():
    return {"total_clients": len(clients_db)}

@app.get("/kpi/avg_income")
def avg_income():
    if len(clients_db) == 0:
        return {"avg_income": 0}
    avg = sum(client.monthly_income for client in clients_db) / len(clients_db)
    return {"avg_income": avg}

@app.get("/kpi/default_rate")
def default_rate():
    if len(clients_db) == 0:
        return {"default_rate": 0}
    defaulters = sum(1 for client in clients_db if client.is_default == 1)
    rate = defaulters / len(clients_db)
    return {"default_rate": rate}

@app.get("/kpi/at_risk")
def at_risk():
    at_risk_count = sum(1 for client in clients_db if client.is_default == 1)
    return {"at_risk": at_risk_count}

@app.post("/predict")
def predict(client: ClientBank):
    features = [[client.age, client.monthly_income, client.debt_ratio, client.open_credit_lines]]
    proba = model.predict_proba(features)[0][1]
    
    if proba < 0.3:
        result = "Accepté"
    elif proba <= 0.6:
        result = "Risque"
    else:
        result = "Refusé"
    
    return {"probability": proba, "result": result}
