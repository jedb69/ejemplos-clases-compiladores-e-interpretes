package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cuadrado extends Figura {
	
	//se cambian el ancho y el alto a valores constantes
	public Cuadrado(Point posicion){
		this.posicion=posicion; //Deberia estar en el constructor pero por simplicidad
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
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
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(), this.getY(), 130, 25);
	}	
}
