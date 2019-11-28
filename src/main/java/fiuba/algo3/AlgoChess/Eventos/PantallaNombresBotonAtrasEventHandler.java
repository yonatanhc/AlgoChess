package fiuba.algo3.AlgoChess.Eventos;


import fiuba.algo3.AlgoChess.Aplicacion.Aplicacion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class PantallaNombresBotonAtrasEventHandler  implements EventHandler<ActionEvent> {
	private Aplicacion app;
	
	public PantallaNombresBotonAtrasEventHandler(Aplicacion app) {
		this.app = app;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {		
		this.app.start(this.app.getStage());
	}

}