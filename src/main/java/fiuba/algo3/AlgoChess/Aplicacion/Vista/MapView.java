package fiuba.algo3.AlgoChess.Aplicacion.Vista;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.entidades.*;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import fiuba.algo3.AlgoChess.AlgoChess;


public class MapView extends Group {

    private  AlgoChess algoChess;
    public double width;
    public double heigth;
    private double tileWidth = 33;
    private double tileHeigth = 33;
    private GridPane table;
    private PlayerView turnOf;
    private PlayerView player1;
    private PlayerView player2;

    private Button[][] buttons;

    public MapView(AlgoChess algoChess, boolean eventMovement){
        this.algoChess = algoChess;
        table = new GridPane();
        width = tileWidth * 20;
        heigth = tileHeigth * 20;
        buttons = new Button[ (int)width][(int)heigth];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Button v = new Button();
                eventOnClick(v,i,j,eventMovement);
                v.setMinHeight(this.tileHeigth);
                v.setMinWidth(this.tileWidth);
                buttons[i][j] = v;
                table.add(v , i, j);
            }
        }
        table.setStyle("-fx-padding: 20;");
        this.addView(table);
    }

    public void addViewOnMap(Stage stage,PieceView piece, int x, int y) {
        Button button = piece.createButtonPieceMin();
        table.getChildren().remove(buttons[x][y]);
        buttons[x][y] = button;
        buttons[x][y].setStyle("-fx-border-color:"+this.turnOf.getColor());
        table.add(button,x,y);
        setPieceOnAlgoChess(piece,x,y);
        stage.close();
    }
    public void setPlayers(PlayerView player1,PlayerView player2){
        this.player1 = player1;
        this.player2 = player2;
    }
    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void eventOnClick(Button button,int x ,int y,boolean movePiece){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(movePiece){

                }
                else{
                    eventOnClickMenuPiece(x,y);
                }
                changeShift();
            }
        });

    }

    public void eventOnClickMenuPiece(int x ,int y){
        Stage stage = new Stage();
        HBox hbox = new HBox();

        PieceView soldado = new PieceView(new Soldado());
        Button soldadoB = soldado.createButtonPieceMax();
        positionPieceOnMap(stage,soldadoB,soldado,x,y);

        PieceView jinete = new PieceView(new Jinete());
        Button jineteB = jinete.createButtonPieceMax();
        positionPieceOnMap(stage,jineteB,jinete,x,y);

        PieceView curandero = new PieceView(new Curandero());
        Button curanderoB = curandero.createButtonPieceMax();
        positionPieceOnMap(stage,curanderoB,curandero,x,y);

        PieceView catapulta = new PieceView(new Catapulta());
        Button catapultaB = catapulta.createButtonPieceMax();
        positionPieceOnMap(stage,catapultaB,catapulta,x,y);

        hbox.getChildren().addAll(soldadoB,jineteB,curanderoB,catapultaB);

        Scene theScene = new Scene(hbox);
        stage.setScene(theScene);
        stage.show();
    }

    public void positionPieceOnMap(Stage stage,Button button,PieceView piece, int x, int y){
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                addViewOnMap(stage,piece,x,y);

            }

        });

    }

    public void changeShift(){
        this.algoChess.cambioDeTurno();
        turnOfPlayer();
    }

    public void turnOfPlayer(){
        String name = this.algoChess.obtenerJudadorEnTurno().obtenerNombre();
        if(name == player1.getName()){
            this.turnOf = player1;
        }
        if(name == player2.getName()){
            this.turnOf = player2;
        }

    }


    public void setPieceOnAlgoChess(PieceView piece, int x, int y){
        this.turnOf.setPiece(piece.createButtonPieceMax());

        //fijarse campoContrarioExcepcion
        this.algoChess.obtenerTablero().ingresarUnidadEn(piece.getUnidadOfPieceView(),x,y,this.algoChess.obtenerJudadorEnTurno());
    }

}