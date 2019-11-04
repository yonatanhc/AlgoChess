package fiuba.algo3.AlgoChess;

public class TableroEnemigo implements TipoDeTablero {

    private int ubicacionMinima;
    private int ubicacionMaxima;

    public TableroEnemigo() {
        this.ubicacionMinima = 5;
        this.ubicacionMaxima = 8;
    }

    public boolean esCasilleroAliado(int x, int y) {

        if(x >= this.ubicacionMinima && x <= this.ubicacionMaxima && y >= 1 && y <= 5) {
            return true;
        }
        throw new CasilleroEnemigoExcepcion();
    }

}