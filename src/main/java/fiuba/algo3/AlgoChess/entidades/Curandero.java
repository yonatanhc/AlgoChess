package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueDeSanacion;

public class Curandero extends Unidad {

    protected AtaqueDeSanacion sanar;

    public Curandero(){
        super(75,2);
        this.sanar= new AtaqueDeSanacion(15);
    }


    public void curarUnidad(Unidad unidadAAtacar) {
        unidadAAtacar.sanarDanio(this.sanar.getSanacion());
    }
}