package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueALejanaDistancia;

public class Catapulta extends Unidad {


    public Catapulta(){
        super(50,5);
        this.ataqueDeUnidad = new AtaqueALejanaDistancia(20);
        this.nombreDeUnidad = "Catapulta";
    }

    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeUnidad.devolverPuntosDeAtaque());
    }

}