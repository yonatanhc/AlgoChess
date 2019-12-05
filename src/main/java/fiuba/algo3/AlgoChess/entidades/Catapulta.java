package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.MoverCatapultaError;
import fiuba.algo3.AlgoChess.acciones.AtaqueDeCatapulta;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class Catapulta extends Unidad {


    public Catapulta(){
        super(50,5);
        this.nombreDeUnidad = "Catapulta";
    }

    public void activarHabilidad(){
        asignarTipoDeHabilidad(new AtaqueDeCatapulta(getTablero()));
        getTipoDeHabilidad().activarHabilidad(this);
    }

    @Override
    public void moverUnidad(Casillero destino) {
        throw new MoverCatapultaError();
    }

}