package cn.sxt.game;

/**封装与plane有关的参数*/

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	boolean left,right,up,down; 
	//重写drawSelf方法
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
	//无参构造器
	public Plane(Image img,double x,double y){
		this.img=img;
		this.x=x;
		this.y=y;
		
	}
	//按下某个键增加相应的方向
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
		
		//按下某个键取消相应的方向
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
