package Modelo;



public abstract class Unidades {
    protected int puntosDeSalud;
    protected int costeDeUnidad;
    protected Jugador jugadorDuenio;

    public Unidades(int salud, int coste){
        this.puntosDeSalud=salud;
        this.costeDeUnidad=coste;
    }

    public abstract void atacarUnidad(Unidades unidadAAtacar);

    public abstract void moverUnidad();

    public int getCosteDeUnidad() {
        return costeDeUnidad;
    }

    public int getPuntosDeSalud() {
        return puntosDeSalud;
    }

    protected void recibirDanio(int danioRecibido) {
        this.puntosDeSalud -= danioRecibido;
    }

    protected void sanarDanio(int devolverPuntosDeAtaque) {
        this.puntosDeSalud += devolverPuntosDeAtaque;
    }
}
