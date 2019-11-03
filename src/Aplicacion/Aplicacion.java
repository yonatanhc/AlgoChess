package Aplicacion;

import Eventos.SalirDelProgramaEventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;


import java.awt.*;
public class Aplicacion extends Application {
    private int resolucionHorizontal = 775;
    private int resolucionVertical = 500;

    @Override
    public void start(Stage stage){
        stage.setTitle("AlgoChess");
        stage.getIcons().add(new Image("Imagenes\\icono.png"));
        Label tituloDelPrograma = new Label("AlgoChess");
        Button botonInformacion = new Button("I");
        botonInformacion.setAlignment(Pos.CENTER);
        Button inicioDePartida = new Button("Iniciar Juego");
        inicioDePartida.setAlignment(Pos.CENTER);
        Button salidaDelPrograma = new Button("Salir");
        salidaDelPrograma.setAlignment(Pos.CENTER);
        salidaDelPrograma.setOnAction(new SalirDelProgramaEventHandler(stage));
        VBox box= new VBox();
        box.getChildren().addAll(botonInformacion,inicioDePartida,salidaDelPrograma);
        box.setSpacing(15);
        box.setAlignment(Pos.CENTER_RIGHT);
        Scene escena=new Scene(box,resolucionHorizontal,resolucionVertical);
        stage.setScene(escena);
        stage.show();
        stage.setFullScreen(true);
    }

    public static void main(String []args){
        launch(args);
    }
}

