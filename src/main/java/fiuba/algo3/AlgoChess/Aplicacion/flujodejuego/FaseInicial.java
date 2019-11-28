package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;

public class FaseInicial extends Fase {

    public FaseInicial(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    public void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeMovimiento(this.algoChess));
    }


}
