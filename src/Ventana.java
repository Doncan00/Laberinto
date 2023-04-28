import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{
	JFrame zumaya = new JFrame();
	int x=100, y=100, lastPress=0,lastPosX,lastPosY;
	int col = 0;
	
	public Ventana() {
		
		this.setVisible(true);
		this.setTitle("Hola Zumaya");
		this.setSize(700, 500);
		this.setResizable(true);
//		this.setLayout();
		this.setLocationRelativeTo(null);
		
		this.getContentPane().setBackground(Color.decode("#318CE7"));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new BorderLayout());
		this.add(panel);
		
		JLabel reinicio = new JLabel("HOLA");
		reinicio.setLayout(new BorderLayout());
		reinicio.setBackground(Color.red);
		panel.add(reinicio , BorderLayout.SOUTH);
		
		JLabel reinicioFondo = new JLabel("HOLA");
		reinicioFondo.setLayout(new BorderLayout());
		reinicioFondo.setBackground(Color.red);
		reinicio.add(reinicioFondo , BorderLayout.CENTER);
		
		JButton jbReinicio = new  JButton("reinicio");
		jbReinicio.setVisible(true);
		reinicio.add(jbReinicio , BorderLayout.CENTER);
		
		panel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				lastPress = e.getKeyCode();
				
				//while (true) {
				lastPosX = x;
				lastPosY = y;
				System.out.println(col);
				switch (e.getKeyCode()) {
				//a
				case 65:
				case 37:
					if (x >10 && col != 2)
					x-=5;
					lastPosX +=5;
					break;
				//s
				case 83:
				case 40:
					if (y <455 && col!=4)
					y+=5;
					break;
				//d
				case 68:
				case 39:
					if (x < 670  && col != 1)
					x+=5;
					lastPosX -=5;
					break;
				//w
				case 87:
				case 38:
					if (y >30 && col != 3)
					y-=5;
					break;
				}
				switch (col) {
				case 1:
					
					break;
				}
				
				repaint();
				
				//}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
		});
		//pintar(null,panel);
		panel.setFocusable(true);
		panel.requestFocus();
		
		this.repaint();
		this.revalidate();
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
		Rect r = new Rect (x,y,20,20,Color.blue);
		g.setColor(r.c);
		g.fillRect(r.x, r.y, r.w, r.h);
		
		Rect p = new Rect (200,100,60,300,Color.red);
		g.setColor(p.c);
		g.fillRect(p.x, p.y, p.w, p.h);
		
		col = r.colision(p);
		
	}
	public class Rect {
		int x=0;
		int y=0;
		int w=0;
		int h=0;
		Color c;
		Rect (int x, int y, int w, int h, Color c){
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.c = c;
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////// FALTA RESOLVER UN BUG CON LAS ESQUINAS (FACIL) ///////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////
		public int colision (Rect target) {
		
		if (this.x < target.x + target.w +1&&
			this.x + this.w > target.x -1&&
			this.y < target.y + target.h +1&&
			this.y + this.h > target.y -1) {
			System.out.println("adentro");
			//Colisión horizontal izquierda
			if (this.x + this.w == target.x) {
				System.out.println("Colision horizontal izquierda");
				return 1;				
			}else if (this.x == target.x + target.w) {
			//Colisión horizontal derecha
				System.out.println("Colision horizontal derecha");
				return 2;				
			}else if (this.y == target.y + target.h) {
			//Colisión vertical abajo
				System.out.println("Colision horizontal izquierda");
				return 3;				
			}else if (this.y + this.h == target.y) {
			//Colisión vertical arriba
				System.out.println("Colision horizontal izquierda");
				return 4;				
			}
		}
		return 0;
		}
	}
}

