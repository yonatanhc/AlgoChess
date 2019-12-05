package fiuba.algo3.AlgoChess.Aplicacion.Vista;

import fiuba.algo3.AlgoChess.AlgoChess;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FaseDeJuegoVista {
    private Stage stage;
    private PieceView pieceView;
    private MapView mapView;
    private PlayerView player1;
    private PlayerView player2;
    private AlgoChess algoChess;

    public FaseDeJuegoVista(PlayerView jugador1, PlayerView jugador2, AlgoChess algoChess,MapView mapView,Stage stage){
        this.player1=jugador1;
        this.player2=jugador2;
        this.algoChess=algoChess;
        this.mapView=mapView;

        this.stage=stage;
        mostrarVistaDeJuego();
    }

    public void mostrarVistaDeJuego(){
        this.stage.setTitle("fase Juego");
        this.mapView.setEventMovement(false);
        this.player1.deletePoint();
        this.player2.deletePoint();
        mapView.setPosTurn(1);
    }

}
