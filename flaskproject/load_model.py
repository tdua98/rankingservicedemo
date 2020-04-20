import pickle
from os import abort

rfModel = pickle.load(open('./Models/randomForestmodel.sav', 'rb'))
LgbmModel = pickle.load(open('./Models/LGBMModel.pkl','rb'))
LgbmModel_better = pickle.load(open('./Models/LGBMModel_better.pkl', 'rb'))


models = {'rfModel': 8, 'LGBMModel': 21, 'LGBMModel_better': 21}


def model(modelname: object) -> object:
    if modelname == "rfModel":
        return rfModel,models[modelname]
    elif modelname == "LGBMModel":
        return LgbmModel,models[modelname]
    elif modelname == "LGBMModel_better":
        return LgbmModel_better,models[modelname]
    else:
        abort(400, "invalid model")
