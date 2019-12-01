package fiuba.algo3.AlgoChess.Aplicacion;

import fiuba.algo3.AlgoChess.AlgoChess;
import fiuba.algo3.AlgoChess.Aplicacion.Vista.InitialPhaseView;
import fiuba.algo3.AlgoChess.Eventos.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    private int resolucionHorizontal = 1360;
    private int resolucionVertical = 768;
    private Stage stage;
    private AlgoChess algoChess;

    @Override
    public void start(Stage stage){
        this.stage = stage;
        stage.setTitle("AlgoChess");
        stage.getIcons().add(new Image("Imagenes/iconos.png"));
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
        inicioDePartida.setOnAction(new ComienzoDelJuego(this));
        botonCreditos.setOnAction(new CreditosEventHandler(this));
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

    public void ingresoDeJugadores() {
        StackPane layout = new StackPane();
        Button botonAceptar = new Button();
        Label etiquetaIngreseNombres = new Label();
        Label etiquetaJugador1 = new Label();
        TextField textoJugador1 = new TextField();
        Label etiquetaJugador2 = new Label();
        TextField textoJugador2 = new TextField();
        Label etiquetaError= new Label();
        Button botonAtras = new Button("Atras");

        //LABEL INGRESE NOMBRES
        etiquetaIngreseNombres.setText("Ingrese Nombres de los Jugadores");
        etiquetaIngreseNombres.setId("ingrese-label");

        //jugador 1
        etiquetaJugador1.setText("Jugador 1:");
        etiquetaJugador1.setId("nombre-label");

        textoJugador1.setPromptText("Jugador 1");

        //jugador 2
        etiquetaJugador2.setText("Jugador 2:");
        etiquetaJugador2.setId("nombre-label");

        textoJugador2.setPromptText("Jugador 2");

        //label error
        etiquetaError.setText("");
        etiquetaError.setId("error-label");

        //boton
        botonAceptar.setText("Aceptar");

        //VBOX1
        VBox contenedorJugador1 = new VBox(etiquetaJugador1,textoJugador1);
        contenedorJugador1.setSpacing(5);

        //VBOX 2
        VBox contenedorJugador2 = new VBox(etiquetaJugador2,textoJugador2);
        contenedorJugador2.setSpacing(5);

        //HBOX
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        HBox contenedorBoton = new HBox(etiquetaError, region1, botonAceptar);
        contenedorBoton.setSpacing(0);

        //VBOX PRINCIPAL
        VBox contenedorPrincipal = new VBox(etiquetaIngreseNombres,contenedorJugador1, contenedorJugador2,contenedorBoton);
        contenedorPrincipal.setSpacing(15);
        contenedorPrincipal.setPadding(new Insets(20));
        contenedorPrincipal.setMaxHeight(320);
        contenedorPrincipal.setMaxWidth(350);
        //contenedorPrincipal.setId("hbox");

        layout.getChildren().addAll(contenedorPrincipal,botonAtras);
        layout.setPadding(new Insets(10));

        //eventos
        BotonAceptarNombresEventHandler botonAceptarEventHandler = new BotonAceptarNombresEventHandler(textoJugador1,textoJugador2,etiquetaError,this);
        botonAceptar.setOnAction(botonAceptarEventHandler);
        botonAceptar.defaultButtonProperty().bind(botonAceptar.focusedProperty());
        BotonAtrasEventHandler eh = new BotonAtrasEventHandler(this);
        botonAtras.setOnAction(eh);
        botonAtras.defaultButtonProperty().bind(botonAtras.focusedProperty());
        PantallaNombresEnterEventHandler textoEventHandler = new PantallaNombresEnterEventHandler(botonAceptar);
        textoJugador1.setOnKeyPressed(textoEventHandler);
        textoJugador2.setOnKeyPressed(textoEventHandler);

        //StackPane.setAlignment(layout, Pos.CENTER );
        StackPane.setAlignment(botonAtras,Pos.BOTTOM_LEFT);

        layout.setPrefWidth(1366);
        layout.setPrefHeight(768);

        Scene escena = new Scene(layout);
        escena.getStylesheets().add("Css/ingresoDeNombres.css");
        this.stage.setMaximized(true);
        this.stage.setScene(escena);
        this.stage.setFullScreen(true);
    }

    public Stage getStage() {
        return this.stage;
    }

    public void iniciarJuego(String nombre1,String nombre2) {
        this.algoChess = new AlgoChess(nombre1,nombre2);
        this.stage.setTitle("AlgoChess");
        this.refresh(nombre1,nombre2,this.algoChess);
    }

    public void refresh(String nombre1,String nombre2,AlgoChess algoChess) {
        InitialPhaseView initialPhase = new InitialPhaseView(nombre1,nombre2,this.stage,algoChess);//jugador1 y jugador2
    }

    public void Creditos(){
        BorderPane borderPane = new BorderPane();
        Label label = new Label("Integrantes");
        Label integrante1 = new Label("Alejandro, Pablo Martín");
        Label integrante2 = new Label("Huaman, Yonatan");
        Label integrante3 = new Label("Chávez Cabanillas, José E.");
        Label integrante4 = new Label("Rizzo, Gonzalo Gabriel");
        Button botonAtras = new Button("Atras");
        botonAtras.setOnAction(new BotonAtrasEventHandler(this));
        VBox vBox = new VBox(label,integrante1,integrante2,integrante3,integrante4);
        BorderPane.setAlignment(vBox,Pos.CENTER);
        BorderPane.setMargin(vBox,new Insets(120,50,100,100));
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(65);
        borderPane.setCenter(vBox);
        BorderPane.setAlignment(botonAtras,Pos.TOP_LEFT);
        BorderPane.setMargin(botonAtras,new Insets(0,25,400,200));
        botonAtras.setAlignment(Pos.CENTER_LEFT);
        borderPane.setBottom(botonAtras);
        Scene scene = new Scene(borderPane);
        scene.getStylesheets().add("Css/credito.css");
        this.stage.setScene(scene);
        this.stage.setMaximized(true);
        this.stage.show();
        this.stage.setFullScreen(true);
    }

}


