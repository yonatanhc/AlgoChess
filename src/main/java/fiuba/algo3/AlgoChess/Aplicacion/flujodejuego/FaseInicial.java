package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Unidad;

public class FaseInicial extends Fase {

    public FaseInicial(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }


    @Override
    public void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeMovimiento(this.algoChess));
    }

    @Override
    public void accionDeFase(){
        Unidad unidadPrueba = new Catapulta();

        while(algoChess.obtenerJudadorEnTurno().asignoTodasLasUnidades()){
            algoChess.obtenerJudadorEnTurno().agregarUnidad(unidadPrueba);
        }

        while(algoChess.obtenerJugadorEnEspera().asignoTodasLasUnidades()){
            algoChess.obtenerJugadorEnEspera().agregarUnidad(unidadPrueba);
        }

        this.siguienteFase();

    }

}
