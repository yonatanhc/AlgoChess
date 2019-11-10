package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public class Curacion implements Habilidad {

    private int puntosDeCuracion;

    public Curacion(int puntos){
        this.puntosDeCuracion = puntos;
    }

    @Override
    public void atacar() {

    }

    @Override
    public void curar(Unidad unidadAcurar) {

    }
}
