package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;

public class FaseDeAtaque extends Fase {

    public FaseDeAtaque(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    public void siguienteFase(){
        if(algoChess.obtenerJugadorEnEspera().tieneUnidades()){

            algoChess.cambioDeTurno();  //Se realiza cambio de turno antes de cambiar de fase

            this.algoChess.asignarFase(new FaseDeMovimiento(this.algoChess));
        }else{
            this.algoChess.asignarFase(new FaseFinal(this.algoChess));
        }


    }
}
