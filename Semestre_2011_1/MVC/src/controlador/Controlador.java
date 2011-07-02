package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import vista.Vista;
import modelo.Circulo;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Modelo;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private int estados = 0;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
	}
	
	public void verificarFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			cambiarFigura(tmp);
	    			//TODO cambiar esta funcion para que cambie los atributos de las figuras
	    			
	    			
	    		}
		    }
	    
	}

	public void cambiarPosicion(Figura f, Point p){
		f.setPosicion(p);
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public boolean getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	public void eVmousePressed(MouseEvent ev) {
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			//System.out.print("boton izquierdo");
			this.verificarFigura(ev.getPoint());
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			//System.out.print("boton derecho");
			this.anyadirFigura(new Cuadrado(ev.getPoint()));			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{   //System.out.print("boton del medio");
			this.anyadirFigura(new Circulo(ev.getPoint(),40,String.valueOf(estados)));
			estados++;
		}
		
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
			//El movimiento puede ser mas fluido recalculando el pto
			vista.repaint();
		}
	

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		}
	public void cambiarFigura(Figura a)
	{
		a.cambiarFigura();
		vista.repaint();
	}
}


