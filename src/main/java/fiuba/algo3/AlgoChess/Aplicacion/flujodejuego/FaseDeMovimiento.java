package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class FaseDeMovimiento extends Fase {


    public FaseDeMovimiento(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    @Override
    public void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeAtaque(this.algoChess));
    }

    @Override
    public void accionDeFase() {
        Unidad unidadPrueba = new Catapulta();
        Casillero casilleroPrueba = new Casillero(1,1);

        algoChess.obtenerTablero().intercambiarPosicionDeUnidad(unidadPrueba,casilleroPrueba);

        this.siguienteFase();
    }
}
