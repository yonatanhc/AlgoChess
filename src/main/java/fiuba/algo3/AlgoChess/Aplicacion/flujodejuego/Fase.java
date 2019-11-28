package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;

public abstract class Fase {
    protected AlgoChess algoChess;

    public Fase(AlgoChess algoChessCreated){this.algoChess = algoChessCreated;}

    public abstract void siguienteFase();

}
