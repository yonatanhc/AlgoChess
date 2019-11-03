package model;

public abstract class TipoDeAtaque {
    private TipoDeDanio tipoDeDanio;

    public TipoDeAtaque(int danioCuerpoACuerpo, int danioADistancia) {
        this.tipoDeDanio = new TipoDeDanio(danioCuerpoACuerpo,danioADistancia);
    }

    public abstract void activarAtaque(Casillero origenDelAtaque);

    public void realizarDanioCuerpoAcuerpo(Casillero origenDelAtaque,int distanciaDelAtaque) {
        tipoDeDanio.realizarDanioCuerpoACuerpo(origenDelAtaque, distanciaDelAtaque);
    }

    public void realizarDanioADistancia(Casillero origenDelAtaque,int distanciaDelAtaque) {
        tipoDeDanio.realizarDanioADistancia(origenDelAtaque, distanciaDelAtaque);
    }
}
