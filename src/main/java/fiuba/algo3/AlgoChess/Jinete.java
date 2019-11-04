package fiuba.algo3.AlgoChess;

public class Jinete extends Unidad {
    //private TipoDeAtaque tipoDeAtaque;
    //private Movilidad movilidad;

    public Jinete(){
        super(100,3);
       // this.movilidad = new Movilidad();
    }

    /*
	public void moverUnidadA(int x, int y) {
	    Casillero desde = getUbicacion();
	    Casillero hasta = getJugador().getTablero().getCasillero(x,y);
        this.movilidad.moverUnidadA(this,desde,hasta);
	}


	public void atacar() {
		Casillero origenDelAtaque = getUbicacion();
		this.tipoDeAtaque = tipoDeAtaqueAUsar(origenDelAtaque);

		tipoDeAtaque.activarAtaque(origenDelAtaque);
	}

	public TipoDeAtaque tipoDeAtaqueAUsar(Casillero origenDelAtaque) {
		if(//soldado cerca o ningun enemigo cerca) {
			return new AtaqueAMedianaDistancia(5,15);
		}

			return new AtaqueACortaDistancia(5,15);


	}*/
}