package fiuba.algo3.AlgoChess.Aplicacion.Vista;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;


public class PieceView{
    private double playerScale = 1;
    //private Tablero tablero;
    private HashMap<String,String> listaImage;

    private int lastXPosition;

    public PieceView() {
        listaView();
    }

    public void setPieceMap(MapView map,String piece,int x, int y) {
        //guarda en el tablero

        ImageView pieceImage = getImageViewMin(piece);
        map.addViewOnMap(pieceImage, x, y);
    }

    public ImageView getImageViewMin(String piece) {
        ImageView pieceImage = new ImageView(new Image(searchImage(piece)));
        pieceImage.setScaleX(playerScale);
        pieceImage.setScaleY(playerScale);
        pieceImage.setFitHeight(28);
        pieceImage.setFitWidth(28);

        return pieceImage;
    }

    public ImageView getImageViewMax(String piece) {
        ImageView pieceImage = new ImageView(new Image(searchImage(piece),90,100,false,false));
        return pieceImage;
    }

    private void listaView() {
        this.listaImage = new HashMap<String,String>();
        this.listaImage.put("soldado", "Imagenes/soldado.jpg");
        this.listaImage.put("jinete", "Imagenes/jinete.png");
        this.listaImage.put("curandero", "Imagenes/curandero.jpg");
        this.listaImage.put("catapulta", "Imagenes/catapulta.jpg");
    }

    public String searchImage(String piece) {

        return this.listaImage.get(piece);

    }



}