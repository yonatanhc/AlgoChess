package Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.*;

public class SalirDelProgramaEventHandler implements EventHandler<ActionEvent> {
    Stage escenaPrincipal;
    public SalirDelProgramaEventHandler(Stage stage) {
       escenaPrincipal= stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Popup popup  = new Popup();
        Label tituloDeCuadroDeSalida = new Label("¿Esta seguro que desea salir?");
        tituloDeCuadroDeSalida.getStylesheets().add("Css/darkTheme.css");
        HBox cuadroSalida = new HBox();
        Image fondo = new Image("Css/Imagenes/fondoDeSalida.png");
        BackgroundImage backgroundimage = new BackgroundImage(fondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
        cuadroSalida.setAlignment(Pos.TOP_CENTER);
        Background fondoCuadro =new Background(backgroundimage);
        cuadroSalida.setSpacing(20);
        Button aceptar =new Button("Aceptar");
        aceptar.getStylesheets().add("Css/darkTheme.css");
        aceptar.setOnAction(new BotonAceptarEventHandler());
        Button cancelar =new Button("Cancelar");
        cancelar.getStylesheets().add("Css/darkTheme.css");
        cancelar.setOnAction(new BotonCancelarEventHandler(popup));
        cuadroSalida.getChildren().addAll(aceptar,cancelar);
        BorderPane border = new BorderPane();
        BorderPane.setAlignment(tituloDeCuadroDeSalida,Pos.CENTER);
        BorderPane.setMargin(tituloDeCuadroDeSalida,new Insets(25,10,10,10));
        border.setTop(tituloDeCuadroDeSalida);
        BorderPane.setMargin(cuadroSalida,new Insets(11,11,11,11));
        border.setCenter(cuadroSalida);
        border.setBackground(fondoCuadro);
        border.setPrefSize(250,122);
        popup.getContent().addAll(border);
        popup.show(escenaPrincipal,600,325);
    }
}
