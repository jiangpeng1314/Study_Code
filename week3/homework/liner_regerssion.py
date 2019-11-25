import numpy as np
import random
import matplotlib.pyplot as plt
import time


def predictValue(w,b,x):
    pre_y=w*x+b
    return pre_y

#get loss
def costFunction(w,b,x_list,gt_y_list):
    m=len(x_list)
    sum=0
    for i in range(m):
        sum+=(w*x_list[i]+b-gt_y_list[i])**2
    loss=sum/m
    return loss

#get next iter w and b
def grandit(x_list,gt_y_list,w,b,lr):
    m=len(x_list)
    sum_db=0
    sum_dw=0
    for i in range(m):
        pre_y=predictValue(w,b,x_list[i])
        diff=pre_y-gt_y_list[i]
        sum_dw+=diff*x_list[i]
        sum_db+=diff
    w=w-lr*(sum_dw)/m
    b=b-lr*(sum_db)/m
    return w,b

#
def descGradient(x_list,gt_y_list,w,b,lr,iter_max):
    m=len(x_list)
    x_axe = np.linspace(np.min(x_list), np.max(x_list), 100)
    plt.ion()
    fig, ax = plt.subplots()
    for i in range(iter_max):
        batch_idxs = np.random.choice(len(x_list), 100)  # 随机抽取100个样本的索引值
        batch_x = [x_list[j] for j in batch_idxs]
        batch_y = [gt_y_list[j] for j in batch_idxs]
        w,b=grandit(batch_x,batch_y,w,b,lr)
        loss = costFunction(w, b, x_list, gt_y_list)

        plt.xlim(np.min(x_list) * 1.05, np.max(x_list) * 1.05)
        plt.ylim(np.min(gt_y_list) * 1.05, np.max(gt_y_list) * 1.05)
        plt.scatter(x_list, gt_y_list)
        y_axe = predictValue(w,b,x_axe)
        plt.plot(x_axe,y_axe,color='red', linewidth=2)
        plt.pause(0.1)
        if i != iter_max - 1:
            ax.cla()
        print('w:{0},b:{1}'.format(w, b))
        print('loss is {}'.format(loss))
    plt.ioff()
    plt.show()


def gen_sample_data():
    w = random.randint(0, 10) + random.random()
    b = random.randint(0, 5) + random.random()

    num_sample = 100
    x_list = []
    y_list = []

    for i in range(num_sample):
        x = random.randint(0, 100) * random.random()
        y = w * x + b + random.random() * random.randint(-1, 200)

        x_list.append(x)
        y_list.append(y)

    return x_list, y_list

def train():
    x_list,gt_y_list=gen_sample_data()
    descGradient(x_list,gt_y_list,0,0,0.001,10000)



if __name__ == '__main__':
    train()



