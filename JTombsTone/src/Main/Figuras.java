package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Modelo.Figura;
import Modelo.Modelo;
import Vista.Vista;
import Controlador.Controlador;
import Controlador.Guardar;





public class Figuras implements ActionListener{
	static JButton guardar = new JButton("Guardar");
	static JButton abrir = new JButton("Abrir");
	static JButton borrar = new JButton("Borrar");
	static JButton limpiar =  new JButton("Limpiar");
	static JTextField nombre = new JTextField();
	static JList lista = new JList();
	static DefaultListModel list =  new DefaultListModel();
	public static Vector<String> todo;
	public static JTextField lenga = new JTextField("java");
	public static JTextField lengb = new JTextField("C#");
	public static JTextField lengc = new JTextField("php");
	public static JLabel lenguajea = new JLabel("Leng. Fuente ");
	public static JLabel lenguajeb = new JLabel("Leng. Objeto ");
	public static JLabel lenguajec = new JLabel("Leng. Escrito");
	public static JScrollPane scroll = new JScrollPane(lista);
	static Modelo modelo = new Modelo();
	static Vista vista = new Vista(new Dimension(600,400),modelo);
	static Controlador controlador = new Controlador(modelo,vista);
	static JFrame frame = new JFrame();
	static JFrame inicio = new JFrame();
	public static void main(String[] args) {
		try{
			
			Figuras hola = new Figuras();
			inicio.setLayout(null);
			nombre.setColumns(15);
			lenga.setColumns(17);
			lengb.setColumns(17);
			lengc.setColumns(17);
			nombre.setBounds(110, 5,170, 25);
			inicio.add(nombre);
			guardar.setBounds(5,5,100,25);
			inicio.add(guardar);
			
			scroll.setBounds(5, 35, 275, 150);
			inicio.add(scroll);
			abrir.setBounds(5, 185, 84, 25);
			inicio.add(abrir);
			
			limpiar.setBounds(92,185,100,25);
			inicio.add(limpiar);
			
			borrar.setBounds(195, 185, 84, 25);
			inicio.add(borrar);
			
			
			lenguajea.setBounds(5, 215, 100, 25);
			inicio.add(lenguajea);
			lenga.setBounds(110, 215, 170, 25);
			inicio.add(lenga);
			
			lenguajeb.setBounds(5, 245, 100, 25);
			inicio.add(lenguajeb);
			lengb.setBounds(110, 245, 170, 25);
			inicio.add(lengb);
			
			lenguajec.setBounds(5, 275, 100, 25);
			inicio.add(lenguajec);
			lengc.setBounds(110, 275, 170, 25);
			inicio.add(lengc);
			
			borrar.addActionListener(hola);
			abrir.addActionListener(hola);
			guardar.addActionListener(hola);
			limpiar.addActionListener(hola);
		
			JTextField text =  new JTextField();
			frame.add(text);
			frame.setTitle("Jtombstone 1.0 BETA");
			inicio.setTitle("Herramientas");
			//Set the window initial Size & default close operation
			frame.setVisible(true);
			inicio.setVisible(true);
			Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
			fullscreen.width=fullscreen.width-400;
			fullscreen.height=fullscreen.height-400;
			inicio.setBounds(fullscreen.width+80, 50, 290, fullscreen.height+27);
			frame.setBounds(50,50,fullscreen.width,fullscreen.height);
			frame.getContentPane().setPreferredSize(fullscreen);
			frame.setResizable(false);
			inicio.setResizable(false);
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		    Container guiobjects = frame.getContentPane();
		    guiobjects.setLayout(new BorderLayout());
			
			
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll);
			todo = vista.dbgetListado();
			lista.setBounds(5, 5, 200,200);
			int i = 0;
			while(i<todo.size())
			{	try {
				list.addElement(todo.get(i));
				i++;
			} catch (Exception e) {
				break;
			}
				
			}
			lista.setModel(list);
			/*ModelScroll.repaint();
			frame.repaint();*/
			frame.pack();
		}catch (RuntimeException e){
			System.out.println(e.toString());
		}

	}

	public static void exitApplication() {
		  
        }
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource() == guardar ){
            //TODO programar que se guarde  el diagrama que ya esta hecho y su validacion
			vista.dbGuardar(this.nombre.getText());
			todo = vista.dbgetListado();
       		list.clear();
       		int i = 0;
       		while(i<todo.size())
       		{	try {
			list.addElement(todo.get(i));
			i++;
			} catch (Exception e11) {
			break;
			}}
			
			}
        if( e.getSource() == abrir ){
        	System.out.print("abrir");
        	vista.dbCargar(this.lista.getSelectedIndex());
            //TODO programar abrir el diagrama seleccionado en la lista
        	}
        if( e.getSource() == borrar){
           vista.dbBorrar(this.lista.getSelectedIndex());
       		todo = vista.dbgetListado();
       		list.clear();
       		int i = 0;
       		while(i<todo.size())
       		{	try {
			list.addElement(todo.get(i));
			i++;
			} catch (Exception e11) {
			break;
			}
			
		}
		lista.setModel(list);
        	}
        if(e.getSource() == limpiar )
        	{
        	 Figuras.vista.eVlimpiar();
        	
        	}

		}

}


