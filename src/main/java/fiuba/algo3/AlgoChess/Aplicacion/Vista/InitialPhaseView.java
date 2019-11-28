package fiuba.algo3.AlgoChess.Aplicacion.Vista;

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

public class InitialPhaseView {
	private Stage stage;
	private PieceView pieceView;
	private MapView mapView;
	private PlayerView player1;
	private PlayerView player2;
	private PlayerView turn;

	public InitialPhaseView(String jugador1,String jugador2, Stage stage) {
		this.stage = stage;
		this.pieceView = new PieceView();
		this.mapView = new MapView();//tamanio del tablero
		player1 =  new PlayerView(jugador1);
		player2 =  new PlayerView(jugador2);
		initialPhase();
	}

	public void initialPhase(){//player1 and player2
		this.stage.setTitle("Phase Initial");
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(head());

		player1.viewPlayer(hbox);
		hbox.getChildren().add(mapView);
		player2.viewPlayer(hbox);

		vbox.getChildren().add(hbox);
		hbox.setAlignment(Pos.CENTER);
		Scene theScene = new Scene(vbox);
		theScene.getStylesheets().add("Css/estilo.css");
		this.stage.setScene(theScene);
		this.stage.setMaximized(true);
		this.stage.show();
		this.stage.setFullScreen(true);
	}

	public HBox head() {
		HBox head = new HBox();
		head.setId("head");

		Image imgSoldado = new Image("Imagenes/soldado.jpg",80,80,false,false);
		ImageView soldado = new ImageView(imgSoldado);
		menuPiece(soldado,"soldado",head);

		Image imgJinete = new Image("Imagenes/jinete.png",80,80,false,false);
		ImageView jinete = new ImageView(imgJinete);
		menuPiece(jinete,"jinete",head);

		Image imgCatapulta = new Image("Imagenes/catapulta.jpg",80,80,false,false);
		ImageView catapulta = new ImageView(imgCatapulta);
		menuPiece(catapulta,"catapulta",head);

		Image imgCurandero = new Image("Imagenes/curandero.jpg",80,80,false,false);
		ImageView curandero= new ImageView(imgCurandero);
		menuPiece(curandero,"curandero",head);

		head.getChildren().addAll(soldado,jinete,catapulta,curandero);
		turnOf(head,player1);
		return head;
	}

	public void menuPiece(ImageView piece,String namePiece,HBox head) {
		piece.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				Popup popup = new Popup();
				//popup.
				VBox vbox = new VBox();


				Label labelx = new Label("Posicion x:");
				TextField x = new TextField ();
				HBox hbx = new HBox();
				hbx.getChildren().addAll(labelx, x);
				hbx.setSpacing(10);

				Label labely = new Label("Posicion y:");
				TextField y = new TextField ();
				HBox hby = new HBox();
				hby.getChildren().addAll(labely, y);
				hby.setSpacing(10);

				Button submit = new Button("Posicionar");
				submit.setStyle("-fx-background-color:#F1C40F;");
				submit.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						pieceView.setPieceMap(mapView,namePiece, Integer.parseInt(x.getText()),Integer.parseInt(y.getText()));
						changeShift(head,namePiece);
						popup.hide();
					}
				});

				vbox.getChildren().addAll(hbx,hby,submit);
				vbox.setId("vbox");


				Scene theScene = new Scene(vbox);
				popup.getContent().addAll(vbox);
				popup.show(stage);
			}
		});
	}

	public void changeShift(HBox head,String namePiece) {
		head.getChildren().remove(4);

		this.turn.setPiece(pieceView.getImageViewMax(namePiece));
		if(this.turn == player1) {
			turnOf(head,player2);
		}
		else {
			turnOf(head,player1);
		}

	}

	public void turnOf(HBox head,PlayerView player){
		this.turn = player;
		Button button = new Button("TURNO DE: "+player.getName());
		button.setStyle("-fx-background-color:#F7CF32");
		head.getChildren().add(button);
	}
}
