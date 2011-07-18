package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Compilador extends Figura{

	//uniones
	private Figura maquina = null;
	private Figura izquierda = null;
	private Figura derecha = null;
	
	public Compilador(Point posicion,String Lenga,String Lengb,String Lengc){
		this.posicion=posicion;
		this.seleccionada=false;
		this.tipo = 0;
		
		this.setlengA(Lenga);
		this.setlengB(Lengb);
		this.setlengC(Lengc);
		//Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		if (p.getX() > this.getX()-60 && p.getX() < this.getX()+60 )
		{	if(p.getY() > this.getY()-40 && p.getY() < this.getY()){	
			return true;
			}
		}if (p.getX() > this.getX()-20 && p.getX() < this.getX()+20 )
		{	if(p.getY() > this.getY()-40 && p.getY() < this.getY()+40){	
			return true;
			}
		}
		
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(this.getX()-60,this.getY()-40, this.getX()+60, this.getY()-40);
		g.drawLine(this.getX()-60,this.getY()-40, this.getX()-60,this.getY());
		g.drawLine(this.getX()+60,this.getY()-40, this.getX()+60,this.getY());
		g.drawLine(this.getX()-60, this.getY(), this.getX()-20, this.getY());
		g.drawLine(this.getX()+20, this.getY(), this.getX()+60, this.getY());
		g.drawLine(this.getX()-20, this.getY(), this.getX()-20, this.getY()+40);
		g.drawLine(this.getX()+20, this.getY(), this.getX()+20, this.getY()+40);
		g.drawLine(this.getX()-20, this.getY()+40, this.getX()+20, this.getY()+40);
		g.drawString(this.getlengA(), this.getX()-56, this.getY()-15);
		g.drawString(this.getlengB(),this.getX()+20,this.getY()-15);
		g.drawString(this.getlengC(),this.getX()-18,this.getY()+35);
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawLine(this.getX()-60,this.getY()-40, this.getX()+60, this.getY()-40);
			g.drawLine(this.getX()-60,this.getY()-40, this.getX()-60,this.getY());
			g.drawLine(this.getX()+60,this.getY()-40, this.getX()+60,this.getY());
			g.drawLine(this.getX()-60, this.getY(), this.getX()-20, this.getY());
			g.drawLine(this.getX()+20, this.getY(), this.getX()+60, this.getY());
			g.drawLine(this.getX()-20, this.getY(), this.getX()-20, this.getY()+40);
			g.drawLine(this.getX()+20, this.getY(), this.getX()+20, this.getY()+40);
			g.drawLine(this.getX()-20, this.getY()+40, this.getX()+20, this.getY()+40);
			g.drawString(this.getlengA(), this.getX()-56, this.getY()-15);
			g.drawString(this.getlengB(),this.getX()+20,this.getY()-15);
			g.drawString(this.getlengC(),this.getX()-18,this.getY()+35);
		}
	}

	@Override
	public boolean Union(Figura f,Point p,Point q) {
	
		if(f.getTipo()==0)// es un compilador
		{	
					if(q.getX()<this.getX()){
					//quiere poner el compilador en la parte izquierda
					f.setPosicion(this.getX()-80,this.getY()+40);}
			
					if(q.getX()>this.getX()){
					//quiere poner el compilador en la parte derecha
					f.setPosicion(this.getX()+80,this.getY()+40);}
					
		}
		if(f.getTipo()==1) // es un interprete
		{
			if(q.getX()<this.getX() && q.getY()<this.getY()){
			//quiere poner el interprete en la parte izquierda
			f.setPosicion(this.getX()-80,this.getY()-20);}
			
			if(q.getY()>this.getY()){
				//quiere poner el interprete abajo
				f.setPosicion(this.getX(),this.getY()+60);}
			if(q.getX()>this.getX()&&q.getY()<this.getY()){
				//quiere poner el interprete en la parte derecha
				f.setPosicion(this.getX()+80,this.getY()-20);}
		}
		if(f.getTipo() == 2) // es una maquina
		{	
			if(q.getX()<this.getX() && q.getY()<this.getY()){
			//quiere poner la maquina en la parte izquierda
			f.setPosicion(p);}
			
			if(q.getY()>this.getY()){
				//quiere poner la maquina abajo
				f.setPosicion(this.getX(),this.getY()+60);}
			
			if(q.getX()>this.getX()&&q.getY()<this.getY()){
				//quiere poner la maquina en la parte derecha
				f.setPosicion(p);}
		}
		if(f.getTipo()==3) // es un programa
		{
			if(q.getX()<this.getX() && q.getY()<this.getY()){
			//quiere poner el programa en la parte izquierda
			f.setPosicion(this.getX()-80,this.getY()-20);}
			
			if(q.getY()>this.getY()){
				//quiere poner el programa abajo
				f.setPosicion(p);}
			if(q.getX()>this.getX()&&q.getY()<this.getY()){
				//quiere poner el programa en la parte derecha
				f.setPosicion(this.getX()+80,this.getY()-20);}
		}
		return false;
	}


	

}
