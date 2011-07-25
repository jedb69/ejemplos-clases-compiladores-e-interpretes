package Controlador;

import java.io.File;

import Modelo.Modelo;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

public class Conexion{
	static Guardar instancia = null; 
	static Modelo modelo = new Modelo();
	public ObjectContainer conectar() { 
		new File("datos").mkdir(); 
		return Db4o.openFile("datos"+ File.separator +"db.db"); 
		} 
	

}
