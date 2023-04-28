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
	int x=10, y=40, lastPress=0,lastPosX,lastPosY;
	int col = 0;
	
	public Ventana() {
		
		this.setVisible(true);
		this.setTitle("Hola Zumaya");
		this.setSize(700, 500);
		this.setResizable(false);
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
				
				//while (true) 
//				System.out.println(col);
				switch (e.getKeyCode()) {
				//a
				case 65:
				case 37:
					if (x >10 && (col != 2 && (col != 6 && col != 9))) {						
					x-=1;
					}
					break;
				//s
				case 83:
				case 40:
					if (y <460 && (col!=4 && (col != 6 && col != 5))) {	
//						System.out.println(col);
					y+=1;
					}
					break;
				//d
				case 68:
				case 39:
					if (x < 675  && (col != 1 && (col != 8 && col != 5))) {						
					x+=1;
					}
					break;
				//w
				case 87:
				case 38:
					if (y >30 && (col != 7&& (col != 8 && col != 9))) {						
					y-=1;
					}
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
		int j=0;
		Rect[] p = new Rect[16];
		for (int i = 0; i < p.length; i++) {
		    p[i] = new Rect(0, 0, 0, 0, Color.black);
		}
		
		Rect r = new Rect (x,y,10,10,Color.blue);
		g.setColor(r.c);
		g.fillRect(r.x, r.y, r.w, r.h);
		
		//4 bordes
		p[j] = new Rect (0,30,690,5,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;
		
		p[j] = new Rect (685,30,10,445,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;
		
		p[j] = new Rect (0,470,695,10,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;
		
		p[j] = new Rect (5,55,10,420,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;
		
		
		//Las otras paredes
		p[j] = new Rect (80,30,5,50,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;

		p[j] = new Rect (16,55,40,5,Color.decode("#D264DB"));
		g.setColor(p[j].c);
		g.fillRect(p[j].x, p[j].y, p[j].w, p[j].h);
		j++;
		
		col=0;
		int cont = 0,num=0;
//		System.out.println();
		for (int i = 0; i < p.length; i++) {
//			System.out.println(col);
			col += r.colision(p[i]);
			if (r.colision(p[i]) != 0) {
				if (r.colision(p[i]) == num && cont != 0) {
//					System.out.println("Dos "+r.colision(p[i]));
					col -= r.colision(p[i]);
					cont--;
				}
				num = r.colision(p[i]);
				cont++;
			}
//			System.out.println(col);
		}
		
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
		public int colision (Rect target) {
		
		if (this.x < target.x + target.w +1&&
			this.x + this.w > target.x -1&&
			this.y < target.y + target.h +1&&
			this.y + this.h > target.y -1) {
//			System.out.println("adentro");
			//Colisión horizontal izquierda
			if (this.x + this.w == target.x) {
				if (this.y == target.y + target.h) {
//					System.out.println("Colision esquina");
					return 0;
				}else if (this.y + this.h == target.y) {
//					System.out.println("Colision esquina");
					return 0;
				}
				else {
//				System.out.println("Colision horizontal izquierda");
				return 1;				
				}
			}else if (this.x == target.x + target.w) {
			//Colisión horizontal derecha
				if (this.y == target.y + target.h) {
//					System.out.println("Colision esquina");
					return 0;
				}else if (this.y + this.h == target.y) {
//					System.out.println("Colision esquina");
					return 0;
				}else {					
//				System.out.println("Colision horizontal derecha");
				return 2;				
				}
			}else if (this.y == target.y + target.h) {
			//Colisión vertical abajo
				if (this.x + this.w == target.x) {
//					System.out.println("Colision esquina");
					return 0;
				}else if (this.x == target.x + target.w) {
//					System.out.println("Colision esquina");
					return 0;
				} else {					
//				System.out.println("Colisión vertical abajo");
				return 7;				
				}
			}else if (this.y + this.h == target.y) {
			//Colisión vertical arriba
				if (this.x + this.w == target.x) {
//					System.out.println("Colision esquina");
					return 0;
				}else if (this.x == target.x + target.w) {
//					System.out.println("Colision esquina");
					return 0;
				} else {					
//				System.out.println("Colisión vertical arriba");
				return 4;				
				}
			}
		}
		return 0;
		}
	}
}

