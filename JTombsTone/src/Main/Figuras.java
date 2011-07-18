package Main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import Modelo.Modelo;
import Vista.Vista;
import Controlador.Controlador;





public class Figuras implements ActionListener{
	static JButton guardar = new JButton();
	static JButton abrir = new JButton();
	static JButton borrar = new JButton();
	static JTextField nombre = new JTextField();
	static JList lista = new JList();
	static JScrollPane scroll = new JScrollPane();
	public static JTextField lenga = new JTextField("java");
	public static JTextField lengb = new JTextField("C#");
	public static JTextField lengc = new JTextField("php");
	static JLabel lenguajea = new JLabel("Lenguaje A");
	static JLabel lenguajeb = new JLabel("Lenguaje B");
	static JLabel lenguajec = new JLabel("Lenguaje C");
	public static void main(String[] args) {
		try{
			
			
			final JFrame frame = new JFrame();
			final JFrame inicio = new JFrame();
			Figuras hola = new Figuras();
			
			lista.setBounds(100, 100, 200,200);
			scroll.setBounds(0, 0, 100, 200);
			scroll.setViewportView(lista);
			nombre.setColumns(15);
			lenga.setColumns(15);
			lengb.setColumns(15);
			lengc.setColumns(15);
			
			guardar.setLabel("Guardar");
			abrir.setLabel("Abrir");
			borrar.setLabel("Borrar");
			guardar.setBounds(0, 0, 100, 60);
			abrir.setBounds(0, 0, 100, 60);
			nombre.setBounds(105, 122, 100, 60);
			inicio.add(guardar);
			inicio.add(nombre);
			inicio.add(scroll);
			inicio.add(abrir);
			inicio.add(borrar);
			
			
			inicio.add(lenga);
			inicio.add(lenguajea);
			
			inicio.add(lengb);
			inicio.add(lenguajeb);
			
			inicio.add(lengc);
			inicio.add(lenguajec);
			borrar.addActionListener(hola);
			abrir.addActionListener(hola);
			guardar.addActionListener(hola);
			inicio.setLayout(new FlowLayout());
			JTextField text =  new JTextField();
			frame.add(text);
			frame.setTitle("Jtombstone");
			inicio.setTitle("Herramientas");
			//Set the window initial Size & default close operation
			frame.setVisible(true);
			inicio.setVisible(true);
			inicio.setTitle("Guardar/abrir/nuevo");
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
			Modelo modelo = new Modelo();
			Vista vista = new Vista(new Dimension(600,400),modelo);
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			guiobjects.add(ModelScroll);
			/*ModelScroll.repaint();
			frame.repaint();*/
			frame.pack();
		}catch (RuntimeException e){
			exitApplication();
		}

	}


	public static void exitApplication() {
		   System.out.println("Saliendo Adios...");
		   System.exit(0);
        }


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("entroooo");
		if( e.getSource() == guardar ){
            //TODO programar que se guarde  el diagrama que ya esta hecho y su validacion
			}
        if( e.getSource() == abrir ){
            //TODO programar abrir el diagrama seleccionado en la lista
        	}
        if( e.getSource() == borrar){
            //TODO programar el borrado del diagrama seleccionado en la lista
        	}
	}

}