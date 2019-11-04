package fiuba.algo3.AlgoChess;

public class TableroAliado implements TipoDeTablero {
    private int ubicacionMinima;
    private int ubicacionMaxima;

    public TableroAliado() {
        this.ubicacionMinima = 1;
        this.ubicacionMaxima = 4;
    }

    public boolean esCasilleroAliado(int x, int y) {

        if(x >= this.ubicacionMinima && x <= this.ubicacionMaxima && y >= 1 && y <= 5) {
            return true;
        }
        throw new CasilleroEnemigoExcepcion();
    }


}
