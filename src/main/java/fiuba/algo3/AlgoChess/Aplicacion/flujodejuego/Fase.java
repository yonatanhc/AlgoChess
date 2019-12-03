package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Unidad;

public abstract class Fase {
    protected AlgoChess algoChess;

    public Fase(AlgoChess algoChessCreated){this.algoChess = algoChessCreated;}

    public abstract void siguienteFase();

    public abstract void accionDeFase(Unidad unidad, int x, int y); //Ejecuta la accion principal de la fase

}
