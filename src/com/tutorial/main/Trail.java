package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	
	private float alpha = 1;
	private int width, height;
	float life;
	private Color color;
	private Handler handler;

	public Trail(int x, int y, ID id, int width, int height, float life, Color color, Handler handler) {
		super(x, y, id);
		this.color = color;
		this.handler = handler;
		this.width = width;
		this.height = height;
		this.life = life;
		
	}

	@Override
	public void tick() {
		if(alpha > life) {
			alpha -= life - 0.001f;
		} else handler.removeObject(this);
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
		g2d.setComposite(makeTransparent(1));
		
	}
	
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return AlphaComposite.getInstance(type, alpha);
	}

	@Override
	public Rectangle getBounds() {
		return null;
	}

}
