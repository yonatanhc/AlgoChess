package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAtaqueJinete {
    /*
    @Test
    void test01AtaqueEnDistanciaCortaDeJinete(){
        Jugador jugador1 = new Jugador("nn");
        Jugador jugador2 = new Jugador("abc");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,3,4,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2,11,12,jugador2);
        tablero.moverUnidadA(jinete2,tablero.obtenerCasillero(4,5));

        Soldado soldado1 = new Soldado();
        tablero.ingresarUnidadEn(soldado1,13,14,jugador2);
        tablero.moverUnidadA(soldado1,tablero.obtenerCasillero(1,6));

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2,20,20,jugador2);
        tablero.moverUnidadA(soldado2,tablero.obtenerCasillero(5,2));

       Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,17,4,jugador2);
        tablero.moverUnidadA(curandero,tablero.obtenerCasillero(7,6));



        jinete.activarHabilidad();

        assertEquals(95, soldado1.getPuntosDeVida());
        assertEquals(95, soldado2.getPuntosDeVida());
        assertEquals(100, jinete.getPuntosDeVida());
        assertEquals(95, jinete2.getPuntosDeVida());
        assertEquals(75, curandero.getPuntosDeVida());
        //assertEquals(50, catapulta2.getPuntosDeVida());


    }/*
}
