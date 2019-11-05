package fiuba.algo3.AlgoChess;

public class Jinete extends Unidad {
    private TipoDeAtaque tipoDeAtaque;
    private Movilidad movilidad;

    public Jinete(){
        super(100,3);
        this.movilidad = new Movilidad();
    }

	public void moverUnidadA(int x, int y,Tablero tablero) {
    	this.movilidad.moverUnidadA(this,getUbicacion(),tablero.getCasillero(x,y));
	}

	public void atacar() {
		Casillero origenDelAtaque = getUbicacion();
		this.tipoDeAtaque = new AtaqueACortaDistancia(5,15); //  tipoDeAtaqueAUsar(origenDelAtaque);

		tipoDeAtaque.activarAtaque(origenDelAtaque);
	}
	/*
	public TipoDeAtaque tipoDeAtaqueAUsar(Casillero origenDelAtaque) {
		if(//soldado cerca o ningun enemigo cerca) {
			return new AtaqueAMedianaDistancia(5,15);
		}

			return new AtaqueACortaDistancia(5,15);


	}*/
}