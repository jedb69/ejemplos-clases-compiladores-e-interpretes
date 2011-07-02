package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {
	protected Point posicion;
	private String letra;
	public int tipo;
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);	
	public void cambiarFigura()
	{	System.out.println(this.tipo);
		this.tipo++;
		if(this.tipo>2)
		{
			this.tipo=0;
		}
	}
	
	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}

	public Point getPosicion(){
		return posicion;
	}
	public String getLetra()
	{
		return letra;
	}
	public void setLetra(String Letra)
	{
		this.letra = Letra;
	}

}
