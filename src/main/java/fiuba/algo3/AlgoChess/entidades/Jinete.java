package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueACortaDistancia;
import fiuba.algo3.AlgoChess.acciones.AtaqueALejanaDistancia;
import fiuba.algo3.AlgoChess.acciones.Movilidad;
import fiuba.algo3.AlgoChess.acciones.TipoDeAtaque;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

public class Jinete extends Unidad {
    private TipoDeAtaque tipoDeAtaque;
    private Movilidad movilidad;
    private AtaqueALejanaDistancia ataqueLejano;

    public Jinete(){
        super(100,3);
        this.movilidad = new Movilidad();
        this.tipoDeAtaque = new AtaqueACortaDistancia(5);
        this.ataqueLejano = new AtaqueALejanaDistancia(15);
    }

	public void moverUnidadA(int x, int y,Tablero tablero) {
    	Casillero destino = tablero.obtenerCasillero(x,y);
    	this.movilidad.moverUnidadA(this,getUbicacion(),destino);
	}

	@Override
    public void atacarUnidad (Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(0);
    }

	public void atacar() {
		Casillero origenDelAtaque = getUbicacion();
		this.tipoDeAtaque = new AtaqueACortaDistancia(5); //  tipoDeAtaqueAUsar(origenDelAtaque);
		tipoDeAtaque.activarAtaque(origenDelAtaque);
	}

}