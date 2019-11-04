package cn.sxt.game;

/**��װ��plane�йصĲ���*/

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	boolean left,right,up,down; 
	//��дdrawSelf����
	int speed=3;
	public void drawSelf(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		if (left) {
			x-=speed;
		}
		if (right) {
			x+=speed;
		}
		if (up) {
			y-=speed;
		}
		if (down) {
			y+=speed;
		}
	}
	//�޲ι�����
	public Plane(Image img,double x,double y){
		this.img=img;
		this.x=x;
		this.y=y;
		
	}
	//����ĳ����������Ӧ�ķ���
	public void addDriction(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;
			
		default:
			break;
		}
	}
		
		//����ĳ����ȡ����Ӧ�ķ���
		public void minusDriction(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				left=false;
				break;
			case KeyEvent.VK_UP:
				up=false;
				break;
			case 39:
				right=false;
				break;
			case 40:
				down=false;
				break;
				
			default:
				break;
			}
	}
}
