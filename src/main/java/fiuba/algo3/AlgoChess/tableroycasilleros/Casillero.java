package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public class Casillero {
    private int x;
    private int y;
    private boolean estaOcupado;
    private Unidad unidadAGuardar;

    public Casillero(int x, int y) {
        this.x = x;
        this.y = y;
        this.unidadAGuardar = null;
    }

    public void ocuparCasilleroConUnidad(Unidad unidadAOcuparCasillero){
        if(!estaOcupado) {
            this.unidadAGuardar = unidadAOcuparCasillero;
            this.estaOcupado= true;
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    public boolean casilleroOcupado() {
        return estaOcupado;
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
