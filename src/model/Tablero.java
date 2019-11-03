package model;

import excepciones.CasilleroEnemigoExcepcion;
import excepciones.CasilleroNoEstaLibreExcepcion;
import excepciones.CasilleroNoExisteExcepcion;

import java.util.ArrayList;

public abstract class Tablero {
	private ArrayList<Casillero> tablero;
	
	public Tablero() {
		this.tablero = new ArrayList<Casillero>();
		inicializarTablero();
	}
	private void inicializarTablero() {
		 for(int i = 1; i <= 8 ; i++) {
			 for(int j = 1 ; j <= 5 ; j++) {
				 this.tablero.add(new Casillero(i,j));
			 }
		 }
	}
	 
	public  void ubicarUnidadEn(Unidad unidad,int x, int y){
		Casillero casillero = getCasillero(x,y);

		if(casilleroValido(x,y)) {
			unidad.setUbicacion(casillero);
			casillero.ingresarUnidad(unidad);
		}
	}

	public abstract boolean EsCasilleroAliado(int x, int y);
	
	public Casillero getCasillero(int x, int y) {
		for(int i = 0; i < this.tablero.size(); i++) {
			Casillero casillero = this.tablero.get(i);
			if(casillero.getX() == x && casillero.getY() == y) {
				return casillero;
			}
		}
		
		throw new CasilleroNoExisteExcepcion();
	 }

	private boolean casilleroValido(int x, int y) {
		Casillero casillero = getCasillero(x,y);
		if(EsCasilleroAliado(x,y) && casillero.casilleroEstaLibre()) {
            return true;
        }

		return false;
	}
}
