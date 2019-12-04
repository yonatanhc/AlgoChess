package fiuba.algo3.AlgoChess.Aplicacion.Vista;


import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.HashMap;


public class PieceView {
    private Unidad unidad;
    private Button pieceButton;
    private double playerScale = 1;
    private HashMap<String, String> listaImage;
    private boolean eventMovement;
    private int lastXPosition;
    private MapView mapView;

    public PieceView(Unidad unidad ,MapView mapView) {
        this.mapView = mapView;
        this.unidad = unidad;
        listaView();
        eventMovement = false;
    }

    public void changeMovement(){
        this.eventMovement = true;
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

    public Button createButtonPieceMin(int x , int y) {
        Button button= new Button();
        button.setGraphic(getImageViewMin(this.unidad.getNombreDeUnidad()));
        addEventMovement(button,x,y);
        return button;
    }

    public Unidad getUnidadOfPieceView(){
        return this.unidad;
    }

    public void addEventMovement(Button button,int x, int y){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {


            @Override
            public void handle(MouseEvent event) {

                if(unidad.getJugador().obtenerNombre() != mapView.getTurnOf().getName()){
                    Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
                    dialogoAlerta.setTitle("Error! Pieza Contraria");
                    dialogoAlerta.setHeaderText("Esta seleccionando una pieza del jugador contrario. Elija una de sus piezas");
                    dialogoAlerta.initStyle(StageStyle.UTILITY);
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    dialogoAlerta.showAndWait();
                }

                else if(event.getButton().equals(MouseButton.PRIMARY)){
                    if(eventMovement){
                        if(unidad.getNombreDeUnidad() == "Catapulta") {eventCatapulta();}
                        else {showMovementTypes(x,y);}
                    }
                }
                else{

                        Stage stage = new Stage();
                        stage.setTitle("Vida de Pieza");
                        VBox vbox = new VBox();
                        Text text = new Text("Vida Disponible");
                        Button b = new Button(String.valueOf(unidad.getPuntosDeVida()));
                        vbox.getChildren().addAll(text,b);
                        Scene theScene = new Scene(vbox,50,50);
                        stage.setScene(theScene);
                        stage.show();

                }

            }

        });
    }

    public Button getMovementView(String name){
        Button b1 = new Button();
        ImageView pieceImage = new ImageView(new Image("imagenes/"+name+".jpg"));
        pieceImage.setScaleX(playerScale);
        pieceImage.setScaleY(playerScale);
        pieceImage.setFitHeight(23);
        pieceImage.setFitWidth(13);

        b1.setGraphic(pieceImage);
        return b1;
    }

    public void showMovementTypes(int x, int y){
        Stage stage = new Stage();
        HBox hbox = new HBox();

        Button b1 = getMovementView("arriba");
        performRightMovement(this,b1,x,y,x,y+1,stage);
        Button b = new Button();
        Button b2 = getMovementView("abajo");
        performRightMovement(this,b2,x,y,x,y-1,stage);
        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(b2,b,b1);

        Button b6 = getMovementView("arribaIzquierda");
        performRightMovement(this,b6,x,y,x-1,y-1,stage);
        Button b3 = getMovementView("izquierda");
        performRightMovement(this,b3,x,y,x-1,y,stage);
        Button b5 = getMovementView("abajoIzquierda");
        performRightMovement(this,b5,x,y,x-1,y+1,stage);
        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(b6,b3,b5);

        Button b8 = getMovementView("arribaDerecha");
        performRightMovement(this,b8,x,y,x+1,y-1,stage);
        Button b4 = getMovementView("derecha");
        performRightMovement(this,b4,x,y,x+1,y,stage);
        Button b7 = getMovementView("abajoDerecha");
        performRightMovement(this,b7,x,y,x+1,y+1,stage);
        VBox vbox3 = new VBox();
        vbox3.getChildren().addAll(b8,b4,b7);


        hbox.getChildren().addAll(vbox1,vbox2,vbox3);

        Scene theScene = new Scene(hbox);
        stage.setScene(theScene);
        stage.show();
    }

    public void performRightMovement(PieceView pieceView,Button button, int x, int y,int n, int m, Stage stage){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                mapView.changeButton(pieceView,x,y,n,m);
                stage.close();

            }

        });
    }

    public void eventCatapulta(){
        //activar ataque para catapulta en algoChess
        Stage stage = new Stage();
        Button b = new Button("Activar Ataque");
        b.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.close();
            }
        });
        Scene theScene = new Scene(b);
        stage.setScene(theScene);
        stage.show();
        mapView.getAlgoChess().accionDeFase(unidad,1,1);

    }

}

