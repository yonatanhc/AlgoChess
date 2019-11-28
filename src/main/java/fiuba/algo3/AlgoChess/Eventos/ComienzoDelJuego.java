package fiuba.algo3.AlgoChess.Eventos;


import fiuba.algo3.AlgoChess.Aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ComienzoDelJuego implements EventHandler<ActionEvent> {

    private Aplicacion app;

    public ComienzoDelJuego(Aplicacion app){
        this.app = app;
    }

    @Override
    public void handle(ActionEvent inicioDeJuego){
       this.app.ingresoDeJugadores();
    }

}
