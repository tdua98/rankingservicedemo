from load_model import model
import json
from flask import abort
import numpy as np

impressionFactor = 0.1
detailFactor = 0.2
bookingFactor = 0.7


def finalScores(inputVals):
    mymodel, features = model(inputVals['model'])
    print(inputVals['model'])
    data = inputVals['data']

    arr = list(data.values())
    inputfeatures = len(arr[0])

    if features != inputfeatures:
        abort(400, "Invalid Data. The number of features do not match")

    hotelids = list(data.keys())
    # print(type(data.keys))

    try:
        if "" in hotelids:
            raise ValueError(400, "Invalid data")
        values = np.array(arr)

        prob = mymodel.predict(values)
    except ValueError:
        abort(400, "Invalid data")
    except KeyError:
        abort(400, "400 Bad request")

    scores = list(prob)
    # probab = np.array(prob)
    # factor = np.array([impressionFactor, detailFactor, bookingFactor])
    # scores = probab.dot(factor.transpose())
    # result = {}
    # result["hotelids"] = hotelids;
    # result["score"] = scores;
    #
    result = dict(zip(hotelids,scores));
    output = json.dumps(result)

    # print(type(scores),type(result['scores']), type(result['hotelids']))

    return result;
