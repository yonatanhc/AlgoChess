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
            this.estaLibre = false;
        }else{throw new CasilleroOcupadoException();}
    }

    public boolean casilleroLibre() {
       // if(!estaLibre) throw new CasilleroOcupadoException();
        //segun los comentarios de la entrega, no deberia ser un error preguntar si el casillero esta libre
        //si es un error, querer ubicar una unidad en la fase inicial en un casillero ocupado
        return estaLibre;
    }

    public void cambiarEstadoDelCasilleroALibre(){
        this.unidadAGuardar = null;
        this.estaLibre = true;
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

    public void setEsEnemigo(boolean asignarLadoDelCampo) {
    }
}
