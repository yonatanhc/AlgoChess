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
        this.stage.setTitle("Phase Game");
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);

        player1.viewPlayer(hbox);
        hbox.getChildren().add(mapView);
        player2.viewPlayer(hbox);
        //mapView.turnOfPlayer();

        hbox.setAlignment(Pos.CENTER);
        Scene theScene = new Scene(hbox);
        theScene.getStylesheets().add("Css/estilo.css");
        this.stage.setScene(theScene);
        this.stage.setMaximized(true);
        this.stage.show();
        //this.stage.setFullScreen(true);
    }

}
