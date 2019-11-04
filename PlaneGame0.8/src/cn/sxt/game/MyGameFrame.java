package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**游戏主窗口*/
public class MyGameFrame extends JFrame{
	
	Image planeimg=GameUtil.getImage("images/plane.png");
	Image bg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeimg,250,250);
	shell=new Shell();
	
	//一堆炮弹
	Shell[] shells=new Shell[50];
	
			
    //画飞机
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
	
		//画出所有的炮弹
	    for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);
		}
	}
	
	//帮助我们反复重画窗口
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();//画画
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	//增加监听键盘内部类
	class KeyMonitor extends KeyAdapter{

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					plane.addDriction(e);
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					plane.minusDriction(e);
				}
			}
	
	//设置窗口
	public void launchFrame() {
		this.setTitle("尚学堂学员——魏江朋");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDH, Constant.GAME_HEIGH);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();//启动画窗口的线程
		addKeyListener(new KeyMonitor());//增加键盘的监听
		
		//初始化50个炮弹
		for (int i = 0; i < shells.length; i++) {
			shells[i]=new Shell();
		}
	}
	
	//主程序
	public static void main(String[]args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
