package fiuba.algo3.AlgoChess.Aplicacion.Vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PlayerView {
	private String namePlayer;
	private int points;
	private VBox player;
	private VBox vbox;
	private ScrollPane piece;
	private String color;

	public PlayerView(String name,String color) {
		this.color = color;
		this.namePlayer = name;
		this.points = 20;
		this.player = new VBox();
		 this.vbox = new VBox();
		 this.vbox.setAlignment(Pos.CENTER);
		this.piece = new ScrollPane();
		piece.setContent(this.vbox);
		piece.setPrefSize(80,400);
		piece.setFitToHeight(true);
		player.setStyle("-fx-spacing:15;-fx-background-color:"+color);
	}

	public void viewPlayer(HBox hbox) {
		this.player.setId("player");
		Text name = new Text(this.namePlayer);
		name.setStyle("-fx-font-size:50px");


		this.player.getChildren().addAll(name,this.piece);
		hbox.getChildren().add(player);
	}

	public void setPiece(Button piece) {
		this.vbox.getChildren().add(piece);
		//agregar onclick de datos de la pieza
	}

	public String getName() {
		return this.namePlayer;
	}

	public String getColor(){
		return this.color;
	}
}
