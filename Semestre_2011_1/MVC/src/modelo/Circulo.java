package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circulo extends Figura {

	private int radio;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public void setTipo(int Tipo)
	{
		this.tipo = Tipo;
	}
	public int getRadio(){
		return radio;
	}
	
	public Circulo(Point posicion, int radio,String numero){
		this.posicion=posicion;
		this.setLetra(numero);
		this.radio=radio; //Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	public boolean dentroFigura(Point p) {
		
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x, 2 ) + Math.pow(p.y - posicion.y, 2 )))		
				return true;
		else
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		int a=17,b=24;
		if(Integer.parseInt(this.getLetra())>9)
		{
			a=14;
		}
		g.drawString(String.valueOf(this.getLetra()), this.getX()+a,this.getY()+b);
		if(this.tipo == 1)
		{
			g.drawOval(this.getX()+2, this.getY()+2, this.getRadio()-4, this.getRadio()-4);
		}
		if(this.tipo == 2)
		{
			g.drawString("---->", this.getX()-23,this.getY()+23);
		}
	}

}
