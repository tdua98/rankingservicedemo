from flask import Flask, request, jsonify
import time
from flask import g
import json
from results import finalScores

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    
    inputVals = request.get_json(force=True)  ## reading the json file

    output = finalScores(inputVals)

    print("Succesfully returned")
    return output


if __name__ == '__main__':
    app.run(debug=True)
