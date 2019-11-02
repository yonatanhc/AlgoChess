package Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class BotonCancelarEventHandler implements EventHandler<ActionEvent> {
    private Popup ventana;

    public BotonCancelarEventHandler(Popup ventanaSalir){
        this.ventana = ventanaSalir;
    }

    @Override
    public void handle(ActionEvent arg0) {
        ventana.hide();
    }
}
