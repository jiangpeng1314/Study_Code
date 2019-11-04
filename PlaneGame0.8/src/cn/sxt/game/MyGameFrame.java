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


/**��Ϸ������*/
public class MyGameFrame extends JFrame{
	
	Image planeimg=GameUtil.getImage("images/plane.png");
	Image bg=GameUtil.getImage("images/bg.jpg");
	
	Plane plane=new Plane(planeimg,250,250);
	shell=new Shell();
	
	//һ���ڵ�
	Shell[] shells=new Shell[50];
	
			
    //���ɻ�
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);
	
		//�������е��ڵ�
	    for (int i = 0; i < shells.length; i++) {
			shells[i].draw(g);
		}
	}
	
	//�������Ƿ����ػ�����
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();//����
				
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
	}
	
	//���Ӽ��������ڲ���
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
	
	//���ô���
	public void launchFrame() {
		this.setTitle("��ѧ��ѧԱ����κ����");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDH, Constant.GAME_HEIGH);
		this.setLocation(300, 300);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		new PaintThread().start();//���������ڵ��߳�
		addKeyListener(new KeyMonitor());//���Ӽ��̵ļ���
		
		//��ʼ��50���ڵ�
		for (int i = 0; i < shells.length; i++) {
			shells[i]=new Shell();
		}
	}
	
	//������
	public static void main(String[]args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}
}
