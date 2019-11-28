package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;

public class FaseDeMovimiento extends Fase {


    public FaseDeMovimiento(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    public void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeAtaque(this.algoChess));
    }
}
