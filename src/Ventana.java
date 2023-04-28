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
		
		PingPong p1 = new PingPong("Hola",20);
//		p1.start();
		
//		try{ 
//			sleep(5000);
//		}catch (InterruptedException e){};

		
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
					x-=5;
					}
					break;
				//s
				case 83:
				case 40:
					if (y <460 && (col!=4 && (col != 6 && col != 5))) {	
//						System.out.println(col);
					y+=5;
					}
					break;
				//d
				case 68:
				case 39:
					if (x < 675  && (col != 1 && (col != 8 && col != 5))) {						
					x+=5;
					}
					break;
				//w
				case 87:
				case 38:
					if (y >30 && (col != 7&& (col != 8 && col != 9))) {						
					y-=5;
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
		Rect[] p = new Rect[100];
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
		j++;
		
		p[j] = new Rect (0,470,695,10,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (5,55,10,420,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (5,55,10,420,Color.decode("#D264DB"));
		j++;
		
		//Las otras paredes
		p[j] = new Rect (65,30,5,50,Color.decode("#D264DB"));
		j++;

		p[j] = new Rect (15,55,35,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (35,75,30,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (15,95,70,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (85,70,5,30,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (70,50,35,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (105,50,5,70,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (85,120,25,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (80,120,5,30,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (60,100,5,65,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (35,165,75,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (105,145,5,20,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (110,145,20,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (130,120,5,110,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (110,100,45,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (155,100,5,150,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (115,250,45,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (30,250,85,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (105,190,5,40,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (40,190,65,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (40,190,5,25,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (15,230,50,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (60,195,5,40,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (15,140,35,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (30,115,5,25,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (80,210,5,40,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (50,255,5,70,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (15,290,15,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (30,270,5,25,Color.decode("#D264FDB"));
		j++;
		
		p[j] = new Rect (35,320,15,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (35,320,5,40,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (35,380,50,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (35,385,5,25,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (15,430,60,5,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (55,340,5,40,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (60,340,60,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (80,300,5,40,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (85,300,70,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (85,370,5,15,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (105,270,5,30,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (85,255,5,20,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (70,275,20,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (125,255,5,30,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (155,270,5,120,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (160,250,20,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (180,250,5,25,Color.decode("#D264DB"));
		j++;

		p[j] = new Rect (160,290,30,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (185,270,20,5,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (205,270,5,60,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (185,295,5,20,Color.decode("#D264DB"));
		j++;
		
		p[j] = new Rect (185,330,25,5,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (185,330,5,60,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (185,390,30,5,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (135,320,5,90,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (95,320,40,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (70,355,65,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (70,360,5,10,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (100,390,35,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (90,370,20,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (85,385,5,70,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (30,450,300,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (90,410,35,5,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (155,405,5,30,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (140,405,20,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (100,430,200,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (300,380,5,55,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (175,410,100,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (200,370,30,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (230,370,5,40,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (200,350,30,5,Color.decode("#FFFFFF"));
		j++;
		
		p[j] = new Rect (225,250,5,100,Color.decode("#FFFFF"));
		j++;
		
		p[j] = new Rect (200,250,30,5,Color.decode("#FFFFFF"));
		j++;
		
		
		
		
		for (int i = 0; i < p.length; i++) {
			g.setColor(p[1].c);
			g.fillRect(p[i].x, p[i].y, p[i].w, p[i].h);
		}
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
	
	
	public class PingPong extends Thread{
		private String word; // Lo que va a escribir.
		private int delay; // Tiempo entre escrituras
		public PingPong(String queDecir,int cadaCuantosMs){
		word = queDecir; delay = cadaCuantosMs; };
		public void run(){ //Se sobrescribe run() de Thread
		while(true){
		System.out.print(word + "");
		zumaya.repaint();
		try{
		sleep(delay);
		} catch(InterruptedException e){ return; }
		}
		}
		}
}

