package fiuba.algo3.AlgoChess.flujodejuego;

public class FaseInicial extends Fase {


    protected void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeMovimiento(this.algoChess));
    }


}
