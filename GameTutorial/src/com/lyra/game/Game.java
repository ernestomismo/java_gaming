package com.lyra.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lyra.game.entity.mob.Player;
import com.lyra.game.graphics.Screen;
import com.lyra.game.input.Keyboard;
import com.lyra.game.level.Level;
import com.lyra.game.level.RandomLevel;
import com.lyra.game.level.SpawnLevel;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = (width / 16) * 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels;
	
	private Screen screen;
	private Keyboard keyboard;
	
	//private int x = 0, y = 0;
	
	private Player player;
	
	private Level level;
	
	public Game() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		keyboard = new Keyboard();
		level = new SpawnLevel("/level.png");
		player = new Player(16*6, 16*4, keyboard);
		pixels = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
	
		addKeyListener(keyboard);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		final double ns = 1000000000.0/60.0;
		double delta = 0;
		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			render();
		}
		stop();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
	public void update() {
		keyboard.update();
		player.update();
	}

	public void clear() {
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		//screen.render(x, y);
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height /2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);
		
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		// !!! sólo para ver la coordenadas x , y
		//g.setColor(Color.WHITE);
		//g.setFont(new Font("Verdana", 0, 50));
		//g.drawString("X: " + player.x + " Y: " + player.y, 350, 300);
		g.dispose();
		bs.show();
	}
}
