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
<<<<<<< HEAD
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
=======
	
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
	}
	
<<<<<<< HEAD
	public boolean verificarFigura(Point posicion){
=======
	public void verificarFigura(Point posicion){
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			cambiarFigura(tmp);
<<<<<<< HEAD
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
	    			System.out.println("El inicio si");
	    		}
	    		if(tmp.dentroFigura(END)){
	    			this.b = true;
	    			System.out.println("el final si");
	    			
	    		}
		    }
	    return a && b; 
=======
	    			//TODO cambiar esta funcion para que cambie los atributos de las figuras
	    			
	    			
	    		}
		    }
	    
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
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
<<<<<<< HEAD
			
			this.verificarFigura(ev.getPoint());			
			
		}else if(SwingUtilities.isRightMouseButton(ev)){//click boton parece que empezara a hacer una linea

			this.setRightpressed(ev.getPoint());
			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio a�ade figura tipo circulo
		{   
=======
			//System.out.print("boton izquierdo");
			this.verificarFigura(ev.getPoint());
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo a�ade figura tipo cuadrado
			//System.out.print("boton derecho");
			this.anyadirFigura(new Cuadrado(ev.getPoint()));			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio a�ade figura tipo circulo
		{   //System.out.print("boton del medio");
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
			this.anyadirFigura(new Circulo(ev.getPoint(),40,String.valueOf(estados)));
			estados++;
		}
		
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
			//El movimiento puede ser mas fluido recalculando el pto
<<<<<<< HEAD
			
=======
			vista.repaint();
>>>>>>> ff4add3b64c94236279386dfeb6d4abb2ec43839
		}
	

	public void eVmouseReleased (MouseEvent ev, String Letra) {
		
		if(SwingUtilities.isRightMouseButton(ev)){		//Solto el boton izquierdo, termina la linea
			if(this.verificarFigura(this.getRightpressed(),ev.getPoint()))
				{ //la linea comienza y termina en un circulo
				this.anyadirFigura(new Cuadrado(this.getRightpressed(),ev.getPoint(),Letra));
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


