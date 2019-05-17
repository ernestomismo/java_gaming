package com.lyra.game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.lyra.game.entity.mob.Player;
import com.lyra.game.graphics.Screen;
import com.lyra.game.input.Keyboard;

public class SpaceGame extends Canvas implements Runnable{
	
	private static final long serialVersionUID = -5820174470866284822L;
	public static int width = 300;
	public static int height = (width / 16) * 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	// detecta pulsación de teclas del teclado
	private Keyboard keyboard;
	private Player player;
	private Screen screen;
	
	// gráficos
	private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels;
	
	public SpaceGame() {
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		keyboard = new Keyboard();
		player = new Player(keyboard);
		pixels = ((DataBufferInt)bufferedImage.getRaster().getDataBuffer()).getData();
		
		addKeyListener(keyboard);
	}

	public static void main(String[] args) {
		
		SpaceGame game = new SpaceGame();
		game.frame.setResizable(false);
		game.frame.setTitle("Space game");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
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
		// 60 se refiere a frames... no segundos
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
	
	public void update() {
		keyboard.update();
		player.update();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		int x = 0, y = 0;
		
		screen.clear();
		player.render(screen);
		//screen.render(x, y);
		for (int i = 0; i < screen.pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
	
}