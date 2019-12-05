package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class FaseFinal extends Fase {

    public FaseFinal(AlgoChess algoChess_pass) {
       super(algoChess_pass);

        StringBuilder string = new StringBuilder("Felicidades ");
        string.append(algoChess.obtenerJudadorEnTurno().obtenerNombre());

        Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
        dialogoAlerta.setTitle(string.toString());
        dialogoAlerta.setHeaderText("Ganaste la partida!");
        dialogoAlerta.initStyle(StageStyle.UTILITY);
        java.awt.Toolkit.getDefaultToolkit().beep();
        dialogoAlerta.showAndWait();

    }

    @Override
    public void siguienteFase(){
    }

    @Override
    public void accionDeFase(Unidad unidad, int x, int y) {

    }
}
