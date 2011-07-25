package Controlador;

import Modelo.Figura;
import Modelo.Modelo;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.awt.Point;
import java.io.File;
import java.util.List;

public class Guardar {

	public ObjectContainer conectar(String ruta, String nombreBase) { 
		new File(ruta).mkdir(); 
		return Db4o.openFile(ruta + File.separator + nombreBase); 
		} 
	
	static Guardar instancia = null; 
	static ObjectContainer db = null; 
	static Modelo modelo = new Modelo();
	
	public void grabar(Object obj) throws Db4oException { 
		db.store(obj);
		} 
	
	public static synchronized Guardar getInstancia(){ 

	if ( instancia == null ) 
	instancia = new Guardar(); 

	return instancia; 
	} 

	private void inicializar(){ 
	Guardar con = new Guardar(); 
	db = con.conectar("C:\\Users\\Jed\\Desktop\\comp", "Javier.db"); 
	} 
	
	public void ingresar(Object fig) { 
      db=conectar("C:\\Users\\Jed\\Desktop\\comp", "Javier.db");
		//ObjectContainer db=Db4o.openFile("C:\\Users\\Jed\\Desktop\\comp\\Javier.dat");
		try {
		    // do something with db4o
			db.set(fig);
			System.out.println("Stored "+fig);
		}
		finally {
		    db.close();
		}
		
		/*try { 
		 Guardar.getInstancia().grabar( fig ); 
		} catch (Db4oException ex) { 
		ex.printStackTrace(); 
		 System.out.println(ex.getMessage()); 
		} */

	} 
	
	public void borrar(Object fig) { 
		Guardar con = new Guardar();
		 db=con.conectar("C:\\Users\\Jed\\Desktop\\comp", "Javier.db");
		   int i=0;
		    
		    Figura cono;
	        ObjectSet result=db.get(fig);
	        //System.out.println("NO SE: "+result.next());
	        cono = (Figura) result.next();
	        db.delete(cono);
	        System.out.println("Deleted "+cono);
	        db.close();
	        
		

		}
	
	public void actualizar(Object fig, Point pos) { 
		Guardar con = new Guardar();
		 db=con.conectar("C:\\Users\\Jed\\Desktop\\comp", "Javier.db");
		   int i=0;
		   System.out.println("Actualizar figura "+fig);
		    Figura cono;
	        ObjectSet result=db.get(fig);
	        cono = (Figura) result.next();
	        System.out.println("Actualizar pos "+cono);
	        //cono.setPosicion(pos.x,pos.y);	        
	        db.set(cono);
	       
	        db.close();
	        
		

		}
	
	 public static Figura cargar() {
		 Guardar con = new Guardar();
		 db=con.conectar("C:\\Users\\Jed\\Desktop\\comp", "Javier.db");
		   int i=0;
		    Figura fig;
		    fig = null;
		    Object cono;
	        ObjectSet result=db.get(fig);
	        //System.out.println("NO SE: "+result.next());
	        while(result.hasNext()){
	        	if(i>0){
	            cono=result.next();
	        	  if(result.hasNext()){	
	        	  //fig=(Figura) cono;
	        		  }
	        	System.out.println("NO SE2: "+cono);
	        	
	        	}
	        	else{
	        	  System.out.println("NO SE2: "+result.next());}
	        	
	        	i++;
	        	
	        }
	        db.close();
	        return fig;
	    }

}
