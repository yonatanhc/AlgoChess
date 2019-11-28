package fiuba.algo3.AlgoChess.Eventos;

import fiuba.algo3.AlgoChess.Aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CreditosEventHandler implements EventHandler<ActionEvent> {

    private Aplicacion pantallaPrincipal;

    public CreditosEventHandler(Aplicacion app){
        this.pantallaPrincipal=app;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        this.pantallaPrincipal.Creditos();
    }


}
