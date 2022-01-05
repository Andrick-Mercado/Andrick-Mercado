import matplotlib.pyplot as plt
import pandas as pd
from sklearn import neighbors
from sklearn.model_selection import train_test_split
import sklearn.neighbors
from mlxtend.plotting import plot_decision_regions
import numpy as np
from sklearn.metrics import confusion_matrix, classification_report

def split_input_data(data):
    x1 = pd.read_csv("A1-inputData.csv")['paramA'].array
    x2 = pd.read_csv("A1-inputData.csv")['paramB'].array
    x = [[x, y] for x, y in zip(x1, x2)]
    y = pd.read_csv("A1-inputData.csv")['Class'].array

    X_train, X_test, y_train, y_test = train_test_split(x, y)
    return X_train, X_test, y_train, y_test


def display_contours(classifier, number_of_neighbors, x, y):
    plot_decision_regions(np.asarray(x), np.asarray(y), clf=classifier, legend=2)
    plt.xlabel('X')
    plt.ylabel('Y')
    plt.title('KNN with K = x')
    plt.show()


def knn(nneighbors, X_train, y_train, X_test):
    clf = neighbors.KNeighborsRegressor(nneighbors)
    clf.fit(X_train, y_train)
    predicted_y = clf.predict(X_test)
    display_contours(clf, nneighbors, X_train, y_train)
    return predicted_y


def evaluateknn(y_predicted, y_test):
    df = pd.DataFrame(y_predicted)
    products_list = df.values.reshape(-1,).tolist()
    products_list = [int(x) for x in products_list]

    df = pd.DataFrame(y_test)
    products_list2 = df.values.reshape(-1,).tolist()
    products_list2 = [int(x) for x in products_list2]

    print("Classification report: ")
    print(classification_report(products_list2, products_list))
    print("Confusion matrix: ")
    print(confusion_matrix(products_list2, products_list))
    #y_test, y_predicted))


if __name__ == "__main__":
    input_data = pd.read_csv("A1-inputData.csv")
    X_train, X_test, y_train, y_test = split_input_data(input_data)

    predicted_y = knn(3, X_train, y_train, X_test)
    evaluateknn(predicted_y, y_test)
