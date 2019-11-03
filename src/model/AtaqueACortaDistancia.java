package model;

public class AtaqueACortaDistancia extends TipoDeAtaque {
    private int distanciaMinima;
    private int distanciaMaxima;

    public AtaqueACortaDistancia(int danioCuerpoACuerpo, int danioADistancia) {
        super(danioCuerpoACuerpo,danioADistancia);
        this.distanciaMinima = 1;
        this.distanciaMaxima = 2;
    }

    @Override
    public void activarAtaque(Casillero origenDelAtaque) {
        realizarDanioCuerpoAcuerpo(origenDelAtaque,this.distanciaMinima);
        realizarDanioADistancia(origenDelAtaque,this.distanciaMaxima);
    }
}
