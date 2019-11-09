package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueACortaDistancia;
import fiuba.algo3.AlgoChess.acciones.AtaqueALejanaDistancia;
import fiuba.algo3.AlgoChess.acciones.TipoDeAtaque;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;

public class Jinete extends Unidad {
    private TipoDeAtaque tipoDeAtaque;
    private AtaqueALejanaDistancia ataqueLejano;

    public Jinete(){
        super(100,3);
        this.nombreDeUnidad = "Jinete";
        this.tipoDeAtaque = new AtaqueACortaDistancia(5);
        this.ataqueDeUnidad = new AtaqueACortaDistancia(15);
    }




	public void atacar() {
		Casillero origenDelAtaque = getUbicacion();
		this.tipoDeAtaque = new AtaqueACortaDistancia(5); //  tipoDeAtaqueAUsar(origenDelAtaque);
		tipoDeAtaque.activarAtaque(origenDelAtaque);
	}

}