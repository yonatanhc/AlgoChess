package Eventos;

import com.sun.javafx.scene.layout.region.LayeredBorderPaintConverter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.util.Optional;

public class SalirDelProgramaEventHandler implements EventHandler<ActionEvent> {
    Stage escenaPrincipal;
    public SalirDelProgramaEventHandler(Stage stage) {
       escenaPrincipal= stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Popup popup  = new Popup();
        Label tituloDeCuadroDeSalida = new Label("¿Esta seguro que desea salir?");
        HBox cuadroSalida = new HBox();
        Image fondo = new Image("Css/Imagenes/texturaMuro.jpg");
        BackgroundImage backgroundimage = new BackgroundImage(fondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        cuadroSalida.setAlignment(Pos.TOP_CENTER);
        Background fondoCuadro =new Background(backgroundimage);
        cuadroSalida.setSpacing(25);
        Button aceptar =new Button("Aceptar");
        aceptar.setOnAction(new BotonAceptarEventHandler());
        Button cancelar =new Button("Cancelar");
        cancelar.setOnAction(new BotonCancelarEventHandler(popup));
        cuadroSalida.getChildren().addAll(aceptar,cancelar);
        BorderPane border = new BorderPane();
        BorderPane.setAlignment(tituloDeCuadroDeSalida,Pos.CENTER);
        BorderPane.setMargin(tituloDeCuadroDeSalida,new Insets(10,10,10,10));
        border.setTop(tituloDeCuadroDeSalida);
        BorderPane.setMargin(cuadroSalida,new Insets(11,11,11,11));
        border.setCenter(cuadroSalida);
        border.setBackground(fondoCuadro);
        border.setPrefSize(200,50);
        popup.getContent().addAll(border);
        popup.show(escenaPrincipal,600,325);
    }
}
