import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import pickle

df = pd.read_csv('cs-training.csv', sep=',')

columns_to_keep = ['SeriousDlqin2yrs', 'age', 'MonthlyIncome', 'DebtRatio', 'NumberOfOpenCreditLinesAndLoans']
df = df[columns_to_keep]

df = df.fillna(df.median())

X = df.drop('SeriousDlqin2yrs', axis=1)
y = df['SeriousDlqin2yrs']

model = RandomForestClassifier(max_depth=5, random_state=42)
model.fit(X, y)

with open('bank_model.pkl', 'wb') as f:
    pickle.dump(model, f)

print("Model trained and saved as bank_model.pkl")
