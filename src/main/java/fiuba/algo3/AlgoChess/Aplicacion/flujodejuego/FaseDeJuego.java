package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class FaseDeJuego extends Fase {


    public FaseDeJuego(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    @Override
    public void siguienteFase(){
        if(algoChess.obtenerJugadorEnEspera().tieneUnidades()){

            algoChess.cambioDeTurno();  //Se realiza cambio de turno antes de cambiar de fase

            this.algoChess.asignarFase(new FaseDeJuego(this.algoChess));
        }else{
            this.algoChess.asignarFase(new FaseFinal(this.algoChess));
        }
    }

    @Override
    public void accionDeFase() {
        Unidad unidadPrueba = new Catapulta();
        Casillero casilleroPrueba = new Casillero(1,1);

        algoChess.obtenerTablero().intercambiarPosicionDeUnidad(unidadPrueba,casilleroPrueba);

        this.siguienteFase();
    }
}

