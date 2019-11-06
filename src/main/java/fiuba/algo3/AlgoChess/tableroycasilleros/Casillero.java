package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public class Casillero {
    private int x;
    private int y;
    private boolean estaLibre;
    private Unidad unidadAGuardar;

    public Casillero(int x, int y) {
        this.x = x;
        this.y = y;
        this.unidadAGuardar = null;
        this.estaLibre = true;
    }

    public void ocuparCasilleroConUnidad(Unidad unidadAOcuparCasillero){
        if(estaLibre) {
            this.unidadAGuardar = unidadAOcuparCasillero;
            this.estaLibre= false;
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    public boolean casilleroLibre() {
        return estaLibre;
    }


    public Unidad obtenerUnidad() {
        return unidadAGuardar;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
