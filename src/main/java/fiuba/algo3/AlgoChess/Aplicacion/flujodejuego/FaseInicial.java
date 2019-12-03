package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.CampoContrarioException;
import fiuba.algo3.AlgoChess.PuntosNoDisponibleDelJugadorException;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroOcupadoException;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


public class FaseInicial extends Fase {

    public FaseInicial(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }


    @Override
    public void siguienteFase(){
        this.algoChess.asignarFase(new FaseDeJuego(this.algoChess));
        throw new FaseDeJuegoException();
    }

    @Override
    public void accionDeFase(Unidad unidad, int x, int y){

        if(algoChess.obtenerJudadorEnTurno().asignoTodasLasUnidades() && algoChess.obtenerJugadorEnEspera().asignoTodasLasUnidades()) {
            this.siguienteFase();
        }
        this.algoChess.obtenerTablero().ingresarUnidadEn(unidad, x, y, this.algoChess.obtenerJudadorEnTurno());

    }

}
