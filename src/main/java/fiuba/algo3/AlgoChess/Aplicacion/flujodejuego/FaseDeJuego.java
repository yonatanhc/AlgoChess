package fiuba.algo3.AlgoChess.Aplicacion.flujodejuego;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.MoverCatapultaError;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroOcupadoException;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class FaseDeJuego extends Fase {


    public FaseDeJuego(AlgoChess algoChess_pass) {
        super(algoChess_pass);
    }

    @Override
    public void siguienteFase(){
        if(algoChess.obtenerJugadorEnEspera().tieneUnidades()){

          //  algoChess.cambioDeTurno();  //Se realiza cambio de turno fuera de este metodo

            //this.algoChess.asignarFase(new FaseDeJuego(this.algoChess));
        }else{
            this.algoChess.asignarFase(new FaseFinal(this.algoChess));
        }
    }

    @Override
    public void accionDeFase(Unidad unidad, int x, int y) {

        try {
            algoChess.obtenerTablero().moverUnidadAPosicion(unidad.getUbicacion().getX(), unidad.getUbicacion().getY(), x, y);
        }catch (CasilleroOcupadoException e){
            Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
            dialogoAlerta.setTitle("Error!CasilleroOcupadoException");
            dialogoAlerta.setHeaderText("Cuidado! Esta intentando moverse a un casillero ocupado");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            java.awt.Toolkit.getDefaultToolkit().beep();
            dialogoAlerta.showAndWait();
        }catch (MoverCatapultaError e){
            unidad.activarHabilidad();
        }

        this.siguienteFase();
    }


}

