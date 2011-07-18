package Modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {
	protected Point posicion;
	protected boolean seleccionada;
	protected int tipo;
	public abstract boolean Union(Figura f, Point p,Point q);
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);

	private String lengA = null;
	private String lengB = null;
	private String lengC = null;
	
	public String getlengA()
	{
		return this.lengA;
	}
	public String getlengB()
	{
		return this.lengB;
	}
	public String getlengC()
	{
		return this.lengC;
	}
	public void setlengA(String LengA)
	{
		this.lengA = LengA;
	}
	public void setlengB(String LengB)
	{
		this.lengB = LengB;
	}
	public void setlengC(String LengC)
	{
		this.lengC = LengC;
	}
	public void setTipo(int Tipo)
	{
		this.tipo = Tipo;
	}
	public int getTipo()
	{
		return this.tipo;
	}
	
	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	public void setPosicion(int X, int Y)
	{
		this.posicion = new Point(X, Y);
	}
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}

	Point getPosicion(){
		return posicion;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void setSeleccionada(boolean sel){
		seleccionada=sel;
	}

}
