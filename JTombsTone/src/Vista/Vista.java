package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import Modelo.Modelo;
import Modelo.Figura;
import javax.swing.JPanel;
import Main.Figuras;
import Controlador.Controlador;


public class Vista extends JPanel  {
	static final long serialVersionUID = 0L;
	private Modelo modelo;
	//jtextfield para obtener los valores de los textfields que estan en el otro frame
	private Figuras fg;
	

	public Controlador controlador;  //IMPORTANTE DEBE SER REGISTRADO O todo FALLA
	
	public Vista(Dimension size, Modelo modelo){
		super();
		this.modelo=modelo;
		setPreferredSize(size);
		setBackground(Color.white);
		setFocusable(true);

		//Mejorable al 1000% solo por simplificacion realizado de esta forma
		MouseController mouseControl = new MouseController() {
			public void mouseClicked(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
			public void mouseMoved(MouseEvent event) {}
			public void mousePressed(MouseEvent event) {
			    eVmousePressed(event);	}
			public void mouseReleased(MouseEvent event) {
				eVmouseReleased(event);	}
			public void mouseDragged(MouseEvent event) {
				eVmouseDragged(event);	}
		};
		
		this.addMouseListener(mouseControl);
		this.addMouseMotionListener(mouseControl);
	}
	public boolean isFocusable(){ 
		return true; 
		} 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		pintarTodo(g2);
	}
	
	private void pintarTodo(Graphics2D g){
		for (Figura elemento : modelo.getListado()) {
			elemento.dibujar(g);
		}
	}

	public void eVmousePressed(MouseEvent ev) {
		
		if(controlador!=null && !fg.lenga.getText().equals("") && !fg.lengb.getText().equals("") && !fg.lengc.getText().equals(""))
		{
			controlador.eVmousePressed(ev,fg.lenga.getText(),fg.lengb.getText(),fg.lengc.getText());
		}
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseDragged(ev);
		}
	}
	
	public void eVmouseReleased (MouseEvent ev) {
		if(controlador!=null)
		{
			controlador.eVmouseReleased(ev);
		}
	}
	public void eVlimpiar()
	{
		this.controlador.eVlimpiar();
	}
	public void dbGuardar(String Nombre)
	{
		this.controlador.dbGuardar(Nombre);
	}
	public Vector<String> dbgetListado()
	{
		return this.controlador.dbgetListado();
	}
	public void dbBorrar(int id)
	{
		this.controlador.dbBorrar(id);
	}
	public void dbCargar(int id)
	{
		this.controlador.dbCargar(id);
	}

}


/**************************************************
* SOLO para ahorrar espacio y simplificar cosas
**************************************************/
class MouseController implements MouseListener, MouseMotionListener {
	public void mouseClicked(MouseEvent event) {}
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}
	public void mousePressed(MouseEvent event) {}
	public void mouseReleased(MouseEvent event) {}
	public void mouseDragged(MouseEvent event) {}
	public void mouseMoved(MouseEvent event) {}
}

