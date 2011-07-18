package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Programa extends Figura{

	private Figura izquierda = null;
	private Figura derecha = null;
	private Figura interprete = null;
	
	public Programa(Point posicion,String lenga, String lengb){
		this.posicion=posicion;
		this.seleccionada=false;
		this.tipo = 3;
		this.setlengA(lenga);
		this.setlengB(lengb);
		this.setlengC(null);
		//Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		if (p.getX() > this.getX()-20 && p.getX() < this.getX()+20 )
		{	if(p.getY() > this.getY()-60 && p.getY() < this.getY()+20){	
			return true;
			}
		}
		
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(this.getX()-20,this.getY()+20,this.getX()+20,this.getY()+20);
		g.drawLine(this.getX()-20, this.getY()+20, this.getX()-20, this.getY()-20);
		g.drawLine(this.getX()+20, this.getY()+20, this.getX()+20, this.getY()-20);
		g.drawOval(this.getX()-25, this.getY()-60, 50, 50);
		//TODO cambiar los Strings a variables
		g.drawString(this.getlengA(), this.getX()-15, this.getY()+7);
		g.drawString(this.getlengB(), this.getX()-23, this.getY()-32);
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawLine(this.getX()-20,this.getY()+20,this.getX()+20,this.getY()+20);
			g.drawLine(this.getX()-20, this.getY()+20, this.getX()-20, this.getY()-20);
			g.drawLine(this.getX()+20, this.getY()+20, this.getX()+20, this.getY()-20);
			g.drawOval(this.getX()-25, this.getY()-60, 50, 50);
			//TODO cambiar los Strings a variables
			g.drawString(this.getlengA(), this.getX()-15, this.getY()+7);
			g.drawString(this.getlengB(), this.getX()-23, this.getY()-32);
		}
	}

	@Override
	public boolean Union(Figura f,Point p,Point q) {
		
		if(f.getTipo()==0)// es un compilador
		{	
			if(q.getX()<=this.getX()){
				//quiere poner el interprete en la parte izquierda
				f.setPosicion(this.getX()-80,this.getY()+20);}
				
				if(q.getX()>this.getX()){
					//quiere poner el interprete en la parte derecha
					f.setPosicion(this.getX()+80,this.getY()+20);}
		}
		if(f.getTipo()==1) // es un interprete
		{
			f.setPosicion(this.getX(),this.getY()+40);
		}
		if(f.getTipo() == 2) // es una maquina
		{	
			f.setPosicion(p);
		}
		if(f.getTipo()==3) // es un programa
		{
			if(!this.seleccionada){
				f.setPosicion(p);}
		}
		return false;
	}

}
