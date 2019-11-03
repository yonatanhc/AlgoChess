package model;

import excepciones.CasilleroNoEstaLibreExcepcion;

public class CasilleroOcupado implements EstadoDelCasillero {

private Unidad unidad;
	
	
	public CasilleroOcupado(Unidad unidad) {
		this.unidad = unidad;
	}
	
	@Override
	public boolean estaLibre() {
		throw new CasilleroNoEstaLibreExcepcion();
	}

	@Override
	public Unidad getUnidad() {
		return this.unidad;
	}


}
