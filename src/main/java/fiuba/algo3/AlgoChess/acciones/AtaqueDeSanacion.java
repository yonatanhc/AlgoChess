package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class AtaqueDeSanacion extends TipoDeAtaque {
    private int distanciaMinima;
    private int distanciaMaxima;
    private int sanacion;

    public AtaqueDeSanacion(int puntosDeSanacion){
        super(0,0); //No se realizan daños
        this.distanciaMinima = 1;
        this.distanciaMaxima = 2; //Solo puede hacerlo a corta distancia
        this.sanacion = puntosDeSanacion;
    }

    public int getSanacion() {
        return sanacion;
    }

    @Override
    public void activarAtaque(Casillero origenDelAtaque) {
        realizarDanioCuerpoAcuerpo(origenDelAtaque,this.distanciaMinima);
        realizarDanioADistancia(origenDelAtaque,this.distanciaMaxima);
    }
}
