import streamlit as st
import requests

API_URL = "http://127.0.0.1:8000"

st.set_page_config(page_title="Banque Web Service", layout="wide")

tab1, tab2 = st.tabs(["Tableau de bord", "Prédiction"])

with tab1:
    st.title("Tableau de bord")
    
    try:
        total_clients_resp = requests.get(f"{API_URL}/kpi/total_clients")
        avg_income_resp = requests.get(f"{API_URL}/kpi/avg_income")
        default_rate_resp = requests.get(f"{API_URL}/kpi/default_rate")
        at_risk_resp = requests.get(f"{API_URL}/kpi/at_risk")
        
        total = total_clients_resp.json().get("total_clients", 0)
        avg_inc = avg_income_resp.json().get("avg_income", 0)
        def_rate = default_rate_resp.json().get("default_rate", 0)
        at_risk_count = at_risk_resp.json().get("at_risk", 0)
        
        col1, col2, col3, col4 = st.columns(4)
        
        with col1:
            st.metric("Total Clients", total)
        
        with col2:
            st.metric("Revenu Moyen", f"${avg_inc:,.2f}")
        
        with col3:
            st.metric("Taux Défaut", f"{def_rate:.2%}")
        
        with col4:
            st.metric("Clients à Risque", at_risk_count)
    except:
        st.error("Impossible de se connecter à l'API. Assurez-vous que l'API FastAPI est en cours d'exécution sur http://127.0.0.1:8000")

with tab2:
    st.title("Prédiction de Risque")
    
    age = st.number_input("Âge", min_value=18, max_value=100, value=35)
    monthly_income = st.number_input("Revenu Mensuel", min_value=0.0, value=5000.0)
    debt_ratio = st.number_input("Ratio d'Endettement", min_value=0.0, max_value=1.0, value=0.3)
    open_credit_lines = st.number_input("Lignes de Crédit Ouvertes", min_value=0, value=5)
    
    if st.button("Soumettre"):
        try:
            payload = {
                "id": 1,
                "age": int(age),
                "monthly_income": monthly_income,
                "debt_ratio": debt_ratio,
                "open_credit_lines": int(open_credit_lines),
                "is_default": 0
            }
            
            response = requests.post(f"{API_URL}/predict", json=payload)
            prediction = response.json()
            
            result = prediction.get("result")
            probability = prediction.get("probability", 0)
            
            if result == "Accepté":
                st.success(f"✓ {result} (Probabilité de défaut: {probability:.2%})")
            elif result == "Risque":
                st.warning(f"⚠ {result} (Probabilité de défaut: {probability:.2%})")
            else:
                st.error(f"✗ {result} (Probabilité de défaut: {probability:.2%})")
        except:
            st.error("Erreur lors de la prédiction. Vérifiez que l'API est disponible.")
