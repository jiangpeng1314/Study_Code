package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

/**炮弹类
 * 
 * 
 * @author 魏江朋
 *
 */

public class Shell extends GameObject{
	double degree;
	
	public Shell() {
		x=200;
		y=200;
		width=10;
		height=10;
		speed=4;
		
		degree=Math.random()*Math.PI*2;
		
	}
	public void draw(Graphics g) {
		Color c=g.getColor();
		g.setColor(Color.YELLOW);
		
		
		g.fillOval((int)x, (int)y, width, height);
		g.setColor(c);
		//炮弹沿任意角度飞去
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if (x<0||x>Constant.GAME_WIDH-width) {
			degree=Math.PI-degree;
			
			
		}
		if (y<30||y>Constant.GAME_HEIGH-height) {
			degree=-degree;
			
		}
		}
}
