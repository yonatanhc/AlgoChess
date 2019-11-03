package model;

public class Casillero {
	private int x;
	private int y;
	private EstadoDelCasillero estadoDelCasillero;
	
	public Casillero(int x, int y) {
		this.x = x;
		this.y = y; 
		this.estadoDelCasillero = new CasilleroLibre();
	}
	
	public void ingresarUnidad(Unidad unidad) {
		estadoDelCasillero = new CasilleroOcupado(unidad);
	}
	
	public void cambiarEstadoALibre() {
		estadoDelCasillero = new CasilleroLibre();
	}
	
	public boolean casilleroEstaLibre() {
		return estadoDelCasillero.estaLibre();
	}
	
	public Unidad getUnidad() {
		return this.estadoDelCasillero.getUnidad();
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
