package Modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	
	private List<Figura> listaFiguras;
	public Modelo(){
		listaFiguras = new ArrayList<Figura>();
	}
	public int getIndex(Point p)
	{Figura elemento =  null; 
	for (int i = 0;i<listaFiguras.size(); i++) {
				elemento = listaFiguras.get(i);
			if(elemento.dentroFigura(p)){
				return i;
			}
		}
	return -1;
	}
	public void limpiar()
	{	System.out.print("limpiar");
		this.listaFiguras.clear();
	}
	public void changeFigure(int index, Figura f)
	{
		listaFiguras.remove(index);
		listaFiguras.add(index, f);
	}
	
	public void AnyadirFigura(Figura f){
		listaFiguras.add(f);
		
	}
	
	public List<Figura> getListado(){
		return listaFiguras;
	}
	
	public void anyadirFigura(Figura f){
		listaFiguras.add(f);
	}
	
	public Figura getFiguraEn(Point p){
		for (Figura elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
				return elemento;				
			}
		}
		return null;
	}
}
