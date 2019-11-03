package Aplicacion;


import Eventos.SalirDelProgramaEventHandler;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    private int resolucionHorizontal = 1366;
    private int resolucionVertical = 768;

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoChess");
        stage.getIcons().add(new Image("Imagenes/icono.png"));
        //Creacion De Entorno
        Button botonCreditos = new Button("Creditos");
        Button inicioDePartida = new Button("Iniciar Juego");
        Button salidaDelPrograma = new Button("Salir");
        VBox box= new VBox();
        BorderPane panel = new BorderPane();
        Scene escena=new Scene(panel,resolucionHorizontal,resolucionVertical);

        //Estilo Del entorno
        botonCreditos.getStylesheets().add("Css/darkTheme.css");
        inicioDePartida.getStylesheets().add("Css/darkTheme.css");
        salidaDelPrograma.getStylesheets().add("Css/darkTheme.css");
        salidaDelPrograma.setAlignment(Pos.CENTER);
        salidaDelPrograma.setOnAction(new SalirDelProgramaEventHandler(stage));
        panel.setId("pane");
        BorderPane.setMargin(box,new Insets(0,280,200,0));
        panel.setRight(box);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(inicioDePartida,botonCreditos,salidaDelPrograma);
        box.setSpacing(15);
        escena.getStylesheets().add("Css/pantallaPrincipal.css");
        stage.setMaximized(true);
        stage.setScene(escena);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String []args){
        launch(args);
    }
}

