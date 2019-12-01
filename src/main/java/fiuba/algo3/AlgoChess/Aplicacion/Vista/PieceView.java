package fiuba.algo3.AlgoChess.Aplicacion.Vista;


import fiuba.algo3.AlgoChess.entidades.Unidad;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;


public class PieceView {
    private Unidad unidad;
    private Button pieceButton;
    private double playerScale = 1;
    //private Tablero tablero;
    private HashMap<String, String> listaImage;

    private int lastXPosition;

    public PieceView(Unidad unidad) {
        this.unidad = unidad;
        listaView();
    }

    public ImageView getImageViewMin(String piece) {
        ImageView pieceImage = new ImageView(new Image(searchImage(piece)));
        pieceImage.setScaleX(playerScale);
        pieceImage.setScaleY(playerScale);
        pieceImage.setFitHeight(25);
        pieceImage.setFitWidth(16);
        return pieceImage;
    }

    public ImageView getImageViewMax(String piece) {
        ImageView pieceImage = new ImageView(new Image(searchImage(piece), 90, 100, false, false));
        return pieceImage;
    }

    private void listaView() {
        this.listaImage = new HashMap<String, String>();
        this.listaImage.put("Soldado", "Imagenes/soldado.jpg");
        this.listaImage.put("Jinete", "Imagenes/jinete.png");
        this.listaImage.put("Curandero", "Imagenes/curandero.jpg");
        this.listaImage.put("Catapulta", "Imagenes/catapulta.jpg");
    }

    public String searchImage(String piece) {

        return this.listaImage.get(piece);

    }

    public Button createButtonPieceMax() {
        Button button= new Button();
        button.setGraphic(getImageViewMax(this.unidad.getNombreDeUnidad()));
        return button;
    }

    public Button createButtonPieceMin() {
        Button button= new Button();
        button.setGraphic(getImageViewMin(this.unidad.getNombreDeUnidad()));
        return button;
    }

    public Unidad getUnidadOfPieceView(){
        return this.unidad;
    }

}

