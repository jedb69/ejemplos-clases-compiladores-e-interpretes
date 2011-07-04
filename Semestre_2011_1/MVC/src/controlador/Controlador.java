package controlador;

import java.awt.Point;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
	private Point rightPressed;
	private boolean a=false,b=false;
	public void setRightpressed(Point XY)
	{
		this.rightPressed = XY;
	}
	public Point getRightpressed()
	{
		return this.rightPressed;
	}
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
	}
	
	public boolean verificarFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			cambiarFigura(tmp);
	    			return true;   			
	    			
	    		}
		    }
	    return false; // quiere decir que no esta en una figura
	}
	public boolean verificarFigura(Point INIT,Point END){ //polimorfismo para verificar el inicio y final de las lineas
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(INIT)){
	    			this.a = true; 	
	    		}
	    		if(tmp.dentroFigura(END)){
	    			this.b = true;
	    			
	    		}
		    }
	    return a && b; 
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
			
			this.verificarFigura(ev.getPoint());			
			
		}else if(SwingUtilities.isRightMouseButton(ev)){//click boton parece que empezara a hacer una linea

			this.setRightpressed(ev.getPoint());
			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio a�ade figura tipo circulo
		{   
			this.anyadirFigura(new Circulo(ev.getPoint(),40,String.valueOf(estados)));
			estados++;
		}
		
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
			//El movimiento puede ser mas fluido recalculando el pto
			
		}
	

	public void eVmouseReleased (MouseEvent ev, String Letra) {
		
		if(SwingUtilities.isRightMouseButton(ev)){		//Solto el boton izquierdo, termina la linea
			if(this.verificarFigura(this.getRightpressed(),ev.getPoint()))
				{ //la linea comienza y termina en un circulo				
				 Pattern p = Pattern.compile("[a-z]");
			        Matcher m = p.matcher(Letra);
			        if ( m.find() ){ //validamos que haya una letra en el campo
			        	this.anyadirFigura(new Cuadrado(this.getRightpressed(),ev.getPoint(),Letra));
			        	}
			        
				
				this.a = this.b = false;
				}
			
			
		}
		vista.repaint();
		}
	public void cambiarFigura(Figura a)
	{
		a.cambiarFigura();
		vista.repaint();
	}
}


