package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;

public class Curar extends Habilidad {
    private int curacion;
    public Curar(Rango rango,int curacion){
        super(rango);
        this.curacion = curacion;
    }

    @Override
    public void activarHabilidad(Unidad unidad) {

    }
}
