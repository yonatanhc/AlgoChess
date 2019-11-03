package model;

public class TableroEnemigo extends Tablero {

    private int ubicacionMinima;
    private int ubicacionMaxima;

    public TableroEnemigo() {
        this.ubicacionMinima = 5;
        this.ubicacionMaxima = 8;
    }

    public boolean EsCasilleroAliado(int x, int y) {

        if(x >= this.ubicacionMinima && x <= this.ubicacionMaxima && y >= 1 && y <= 5) {
            return true;
        }
        return false;
    }

}
