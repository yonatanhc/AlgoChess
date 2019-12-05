package fiuba.algo3.AlgoChess.Aplicacion.Vista;

import fiuba.algo3.AlgoChess.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class InitialPhaseView{
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private AlgoChess algoChess;

	public InitialPhaseView(String jugador1,String jugador2, Stage stage,AlgoChess algochess){
		this.algoChess = algochess;
		this.stage = stage;
		this.mapView = new MapView(algochess,stage);//the events are to position the pieces
		this.mapView.setEventMovement(true);
		this.mapView.setPosTurn(2);
		this.mapView.getMapView();
		player1 =  new PlayerView(jugador1,"red");
		player2 =  new PlayerView(jugador2,"blue");
		mapView.setPlayers(player1,player2);

		initialPhase();

	}

	public void initialPhase(){
		this.stage.setTitle("Phase Initial");
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);

		player1.viewPlayer(hbox);
		hbox.getChildren().add(mapView);
		player2.viewPlayer(hbox);
		mapView.turnOfPlayer();

		hbox.setAlignment(Pos.CENTER);
		Scene theScene = new Scene(hbox);
		theScene.getStylesheets().add("Css/estilo.css");
		this.stage.setScene(theScene);
		this.stage.setMaximized(true);
		this.stage.show();
		//this.stage.setFullScreen(true);
	}
}
