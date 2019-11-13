import cv2
import numpy as np
import matplotlib.pyplot as plt
import os



def picture_stiching(img_left,img_right):
    img_right_gray=cv2.cvtColor(img_right,cv2.COLOR_BGR2GRAY)
    img_left_gray=cv2.cvtColor(img_left,cv2.COLOR_BGR2GRAY)

    sift = cv2.xfeatures2d.SIFT_create()
    kp_right,des_right=sift.detectAndCompute(img_right,None)
    kp_left,des_left=sift.detectAndCompute(img_left,None)

    bf=cv2.BFMatcher()
    matches=bf.knnMatch(des_right,des_left,k=2)

    good=[]
    for m in matches:
        if m[0].distance<0.5*m[1].distance:
            good.append(m)
    matches=np.asarray(good)

    if len(matches[:,0]) >= 4:
        src = np.float32([ kp_right[m.queryIdx].pt for m in matches[:,0] ]).reshape(-1,1,2)
        dst = np.float32([ kp_left[m.trainIdx].pt for m in matches[:,0] ]).reshape(-1,1,2)
        H, masked = cv2.findHomography(src, dst, cv2.RANSAC, 5.0)
    else:
        raise AssertionError("Can’t find enough keypoints.")
    #dst为经过单应性矩阵变换后的img_left
    dst = cv2.warpPerspective(img_right,H,(img_left.shape[1] + img_right.shape[1], img_left.shape[0]))
    #plt.subplot(122),plt.imshow(dst),plt.title('Warped Image'),plt.show()

    #将img_right与img_left拼接成一个图片
    dst[0:img_left.shape[0], 0:img_left.shape[1]] = img_left
    return dst



def main():
    path = os.path.abspath('.')
    print("path:" + path)
    img_left = cv2.imread(path + '/picture/img_left.jpg')
    img_right = cv2.imread(path + '/picture/img_right.jpg')
    dst=picture_stiching(img_left,img_right)
    #输出在picture目录下
    cv2.imwrite(path+'/picture/output.jpg', dst)
    plt.figure()
    plt.imshow(dst)
    plt.show()



if __name__ == '__main__':
    main()


