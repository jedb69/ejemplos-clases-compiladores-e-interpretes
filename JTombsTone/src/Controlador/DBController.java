package Controlador;

import java.awt.List;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;


import Modelo.Modelo;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.instrumentation.core.Db4oClassSource;
import com.db4o.query.Constraint;
import com.db4o.query.Query;

/*Esta es la clase donde se deberan hacer los metodos que inserten, borren y obtengan los valores de la base de datos*/
public class DBController {
	static Guardar instancia = null; 
	static ObjectContainer db = null; 
	
	public void Guardar(Object modelo)
	{	db = new Conexion().conectar();
		db.store(modelo);
		db.close();
		
	}

	public Object Cargar(String nombre)
	{ Object modelo=null;
	
		//debe retornar un ListIterator con los valores ya cargados de la base de datos
		return modelo;
	}
	
	public void dbBorrar(int id)
	{
		this.db =  new Conexion().conectar();
		Modelo modelo = new Modelo();
		
		ObjectSet<Modelo> result = db.queryByExample(modelo);
		Modelo found= result.get(id);
		db.delete(found);
		System.out.println("Deleted "+found.getNombre());
		db.close();
	}
	public Modelo dbCargar(int id)
	{
		this.db = new Conexion().conectar();
		Modelo modelo = new Modelo();
		ObjectSet<Modelo> result = db.queryByExample(modelo);
		
		Modelo found= result.get(id);db.close();
		return found;
	}
	
	public Vector<String> dbgetListado()
	{	Vector<String> listado = new Vector<String>();
		Modelo modelo = new Modelo();
		ObjectSet<Modelo> modelos = null;
		DBController.db =  new Conexion().conectar();
		try {
			 modelos = db.queryByExample(modelo);
		} catch (Exception e) {
			System.out.print("No hay registros");
		}
		
		int i = 0;
		while(modelos.hasNext())
		{	try {
			
			listado.add(modelos.next().getNombre());
			
			} catch (Exception e) {
				System.out.print("problema cargando los nombres");
			}
			i++;
		}
		db.close();
		return listado;
		
	}
}
