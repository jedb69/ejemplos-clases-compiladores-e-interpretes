package Controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.ListIterator;

import Vista.Vista;
import Main.Figuras;
import Modelo.Figura;
import Modelo.Interprete;
import Modelo.Maquina;
import Modelo.Modelo;
import Modelo.Compilador;
import Modelo.Programa;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	private Point before;
	private Figuras fg;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			return tmp;
	    		}
		    }
	    return null;
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
	public void cambiarFigura(int indice,Figura f)
	{
		modelo.changeFigure(indice, f);
	}
	
	public Figura getFiguraEn(Point p){
		return modelo.getFiguraEn(p);
	}
	
	public void eVmousePressed(MouseEvent ev,String lenga, String lengb, String lengc) {
		if(SwingUtilities.isLeftMouseButton(ev)){//Click boton izquierdo selecciona figura
			before = ev.getPoint();
			seleccionada=this.getFiguraEn(ev.getPoint());
		}else if(SwingUtilities.isRightMouseButton(ev)){
			//click boton derecho a�ade figura tipo cuadrado
			if(this.getFiguraEn(ev.getPoint())==null){
				//selecciono un espacio en blanco y se crea la figura Compilador
			this.anyadirFigura(new Compilador(ev.getPoint(),lenga,lengb,lengc));
			}else
			{
				seleccionada = this.getFiguraEn(ev.getPoint());
				int tipo = seleccionada.getTipo();
				int index;
				tipo++;
				if(tipo>3){tipo=0;}
				if(tipo == 0)
				{
					index = this.modelo.getIndex(ev.getPoint());
					this.cambiarFigura(index,new Compilador(ev.getPoint(),lenga,lengb,lengc));
					fg.lenguajea.setVisible(true);
					fg.lenguajeb.setVisible(true);
					fg.lenguajec.setVisible(true);
					fg.lenguajea.setText("Leng. Fuente ");
					fg.lenguajeb.setText("Leng. Objeto ");
					fg.lenguajec.setText("Leng. Escrito");
					fg.lenga.setVisible(true);
					fg.lengb.setVisible(true);
					fg.lengc.setVisible(true);
				}
				if(tipo == 1)
				{
					//vamos a hacer un Interprete
					index = this.modelo.getIndex(ev.getPoint());
					this.cambiarFigura(index,new Interprete(ev.getPoint(),lenga,lengb));
					fg.lenguajea.setText("Leng. Fuente ");
					fg.lenguajeb.setText("Leng. Escrito");
					fg.lenguajec.setVisible(false);
					fg.lenga.setVisible(true);
					fg.lengb.setVisible(true);
					fg.lengc.setVisible(false);
				}if(tipo == 2)
				{
					//vamos a hacer una Maquina
					index = this.modelo.getIndex(ev.getPoint());
					this.cambiarFigura(index,new Maquina(ev.getPoint(),lenga));
					fg.lenguajea.setText("Leng. Maquina");
					fg.lenguajeb.setVisible(false);
					fg.lenguajec.setVisible(false);
					fg.lenga.setVisible(true);
					fg.lengb.setVisible(false);
					fg.lengc.setVisible(false);
				}if(tipo == 3)
				{
					//vamos a hacer un Programa
					index = this.modelo.getIndex(ev.getPoint());
					this.cambiarFigura(index,new Programa(ev.getPoint(),lenga,lengb));
					fg.lenguajea.setText("Nombre        ");
					fg.lenguajeb.setText("Leng. Escrito");
					fg.lenguajeb.setVisible(true);
					fg.lenguajec.setVisible(false);
					fg.lenga.setVisible(true);
					fg.lengb.setVisible(true);
					fg.lengc.setVisible(false);
				}
			}			
		}
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){
			//El movimiento puede ser mas fluido recalculando el pto
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
		}
	}

	public void eVmouseReleased (MouseEvent ev) {
		vista.repaint();
		if(before!=null){
		System.out.println("beforeX "+before.getX());
		System.out.println("beforeY "+before.getY());}
		if(seleccionada!=null){
			//Validamos posicion para encajar con los demas
			ListIterator<Figura> it=modelo.getListado().listIterator();
		    while (it.hasNext()) {
		    	Figura tmp=it.next();
		    		if(tmp.dentroFigura(ev.getPoint())){
		    			tmp.Union(seleccionada,this.before,ev.getPoint());
		    			this.before = null;
		    		}
			    }
			seleccionada.setSeleccionada(false);
			seleccionada=null;
		}
	}
	public void eVlimpiar()
	{
		this.modelo.limpiar();
		vista.repaint();
	}
	

}
