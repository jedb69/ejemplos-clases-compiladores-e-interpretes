package Modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Interprete extends Figura{

	private Figura arriba =  null;
	private Figura abajo = null; 
	
	
	public Interprete(Point posicion, String lenga, String lengb){
		this.posicion=posicion;
		this.seleccionada=false;
		this.tipo = 1;
		this.setlengA(lenga);
		this.setlengB(lengb);
		this.setlengC(null);
		//Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		if (p.getX() > this.getX()-20 && p.getX() < this.getX()+20 )
		{	if(p.getY() > this.getY()-20 && p.getY() < this.getY()+20){	
			return true;
			}
		}
		
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(this.getX()-20, this.getY()-20, this.getX()+20, this.getY()-20);
		g.drawLine(this.getX()-20, this.getY()-20, this.getX()-20, this.getY()+20);
		g.drawLine(this.getX()+20, this.getY()-20, this.getX()+20, this.getY()+20);
		g.drawLine(this.getX()-20, this.getY()+20, this.getX()+20, this.getY()+20);
		g.drawLine(this.getX()-20, this.getY(), this.getX()+20, this.getY());
		g.drawString(this.getlengA(), this.getX()-18, this.getY()-6);
		g.drawString(this.getlengB(), this.getX()-18, this.getY()+15);
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawLine(this.getX()-20, this.getY()-20, this.getX()+20, this.getY()-20);
			g.drawLine(this.getX()-20, this.getY()-20, this.getX()-20, this.getY()+20);
			g.drawLine(this.getX()+20, this.getY()-20, this.getX()+20, this.getY()+20);
			g.drawLine(this.getX()-20, this.getY()+20, this.getX()+20, this.getY()+20);
			g.drawLine(this.getX()-20, this.getY(), this.getX()+20, this.getY());
			g.drawString(this.getlengA(), this.getX()-18, this.getY()-6);
			g.drawString(this.getlengB(), this.getX()-18, this.getY()+15);
		}
	}

	@Override
	public boolean Union(Figura f, Point p, Point q) {
		if(f.getTipo()==0)// es un compilador
		{	
				if(f.getlengC().equals(this.getlengA()))
				{
				f.setPosicion(this.getX(),this.getY()-60);
				}else
				{
					f.setPosicion(p);
				}
				
		}
		if(f.getTipo()==1) // es un interprete
		{
			if(!this.seleccionada){
				f.setPosicion(p);}
		}
		if(f.getTipo() == 2) // es una maquina
		{	
			if(f.getlengA().equals(this.getlengB()))
			{
			f.setPosicion(this.getX(),this.getY()+40);
			}else
			{
				f.setPosicion(p);
			}
		}
		if(f.getTipo()==3) // es un programa
		{
			if(f.getlengB().equals(this.getlengA()))
			{
			f.setPosicion(this.getX(),this.getY()-40);
			}else
			{
				f.setPosicion(p);
			}
		}
		return false;
	}

}
