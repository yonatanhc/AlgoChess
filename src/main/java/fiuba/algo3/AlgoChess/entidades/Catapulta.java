package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueALejanaDistancia;

public class Catapulta extends Unidad {

    AtaqueALejanaDistancia ataqueDeLaCatapulta;

    public Catapulta(){
        super(50,5);
        this.ataqueDeLaCatapulta = new AtaqueALejanaDistancia(20);
        this.nombreDeUnidad = "Catapulta";
    }

    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeLaCatapulta.devolverPuntosDeAtaque());
    }

}