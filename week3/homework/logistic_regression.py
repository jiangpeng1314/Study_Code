import numpy as np
import random
import time
import matplotlib.pyplot as plt
from numpy.linalg import cholesky


## inference y
def sigmoid(w1, w2, b, x):
    pred_y = 1 / (1 + np.exp(-(w1 * x[:, 0] + w2 * x[:, 1] + b)))
    return pred_y


## cost function
def eval_loss(w1, w2, b, x, y):  # gt_y_list 为 y 的真实值
    avg_loss = - np.mean(y * np.log(sigmoid(w1, w2, b, x)) + \
                         (1 - y) * np.log(1 - sigmoid(w1, w2, b, x)))
    return avg_loss


## gradient of a single sample
def gradient(pred_y, y, x):
    diff = pred_y - y
    dw1 = diff * x[:, 0]
    dw2 = diff * x[:, 1]
    db = diff
    return dw1, dw2, db


## update of batchsize for w, b
def cal_step_gradient(batch_x, batch_y, w1, w2, b, lr):
    pred_y = sigmoid(w1, w2, b, batch_x)
    dw1, dw2, db = gradient(pred_y, batch_y, batch_x)
    w1 -= lr * np.mean(dw1)
    w2 -= lr * np.mean(dw2)
    b -= lr * np.mean(db)
    return w1, w2, b


def gen_sample_data():
    # 二维正态分布
    sampleNo = 1000
    mu = np.array([[1, 5]])
    Sigma = np.array([[2, 0], [0, 3]])
    R = cholesky(Sigma)
    s = np.dot(np.random.randn(sampleNo, 2), R) + mu
    x1 = np.hstack((s, np.ones((sampleNo, 1))))
    # plt.plot(s[:, 0], s[:, 1], '+')

    mu = np.array([[6, 0]])
    Sigma = np.array([[2, 1], [3, 6]])
    R = cholesky(Sigma)
    s = np.dot(np.random.randn(sampleNo, 2), R) + mu
    x2 = np.hstack((s, np.zeros((sampleNo, 1))))
    # plt.plot(s[:, 0], s[:, 1], '+')

    # plt.show()
    X = np.vstack((x1, x2))
    return X


def train(x, batch_size, lr, max_iter):
    print(x)
    w1 = w2 = b = 0
    x_axe = np.linspace(np.min(x[:, 0]), np.max(x[:, 0]), 100)
    plt.ion()
    fig, ax = plt.subplots()
    for i in range(max_iter):
        batch_idxs = np.random.choice(len(x), batch_size, False)
        batch_x = np.array([x[j][:2] for j in batch_idxs])
        batch_y = np.array([x[j][2] for j in batch_idxs])
        w1, w2, b = cal_step_gradient(batch_x, batch_y, w1, w2, b, lr)
        print('w1:{0}, w2:{1}, b:{2}'.format(w1, w2, b))
        print('loss is {}'.format( \
            eval_loss(w1, w2, b, x[:, :2], x[:, 2])))
        y_axe = (-b - w1 * x_axe) / w2
        plt.xlim(np.min(x[:, 0]) * 1.05, np.max(x[:, 0]) * 1.05)
        plt.ylim(np.min(x[:, 1]) * 1.05, np.max(x[:, 1]) * 1.05)
        plt.title('Logistic Regression\nliterations: ' + str(i + 1), \
                  fontsize=13)
        plt.scatter(x[:, 0], x[:, 1], c=x[:, 2])
        plt.plot(x_axe, y_axe, linewidth=2)
        plt.pause(0.5)
        if i != max_iter - 1:
            ax.cla()
    plt.ioff()
    plt.show()
    return w1, w2, b


X = gen_sample_data()
train(X, 100, 0.5, 50)
