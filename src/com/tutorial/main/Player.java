package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp(x, 0, Game.WIDTH - 48);
		y = Game.clamp(y, 0, Game.HEIGHT - 68);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
	} 

}
