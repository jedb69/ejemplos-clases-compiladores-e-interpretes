package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cuadrado extends Figura {
<<<<<<< HEAD
	private Point Init;
	private Point End;
	private String Letra;
	public void setInit(Point XY)
	{
		this.Init = XY;
	}
	public Point getInit()
	{
		return this.Init;
	}
	public Point getEnd()
	{
		return this.End;
	}
	public void setEnd(Point XY)
	{
		this.End = XY;
	}
	//se cambian el ancho y el alto a valores constantes
	public Cuadrado(Point INIT, Point END,String Let){
		this.Init = INIT;
		this.End = END;
		this.setLetra(Let);
=======
	
	//se cambian el ancho y el alto a valores constantes
	public Cuadrado(Point posicion){
		this.posicion=posicion; //Deberia estar en el constructor pero por simplicidad
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
<<<<<<< HEAD
		
		return (false);   
=======
		//actualizado
		boolean ancho = false, alto = false;
		if(p.x>posicion.x && p.x < posicion.x+130)
		{
			ancho = true;
		}
		if(p.y>posicion.y && p.y < posicion.y+40)
		{
			alto = true;
		}
		return ( ancho && alto);   
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.BLACK);
<<<<<<< HEAD
		System.out.println("entro");
		System.out.println("x = "+this.getInit().x+" y= "+this.getInit().y);
		System.out.println("x = "+this.getEnd().x+" y= "+this.getEnd().y);
		g.drawLine(this.getInit().x,this.getInit().y,this.getEnd().x,this.getEnd().y);
		g.setColor(Color.RED);
		g.drawString(this.getLetra(),(this.getEnd().x+this.getInit().x)/2,(this.getEnd().y+this.getInit().y)/2);
=======
		g.drawRect(this.getX(), this.getY(), 130, 25);
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
	}	
}
