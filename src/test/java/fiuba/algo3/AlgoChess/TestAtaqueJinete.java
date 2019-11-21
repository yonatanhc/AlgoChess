package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAtaqueJinete {

    @Test
    void test01AtaqueEnDistanciaCortaDeJinete(){
        Jugador jugador1 = new Jugador("nn");
        Jugador jugador2 = new Jugador("abc");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,9,5,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2,11,6,jugador2);


        Soldado soldado1 = new Soldado();
        tablero.ingresarUnidadEn(soldado1,12,3,jugador2);


        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2,11,3,jugador2);


        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,13,4,jugador2);
        //muevo jinete para activar habilidad
        tablero.moverUnidadAPosicion(9,5,10,5);

        assertEquals(95, soldado1.getPuntosDeVida());
        assertEquals(95, soldado2.getPuntosDeVida());
        assertEquals(100, jinete.getPuntosDeVida());
        assertEquals(95, jinete2.getPuntosDeVida());
        assertEquals(75, curandero.getPuntosDeVida());
    }

    @Test
    void test02AtaqueEnDistanciaMedianaDeJinete() {
        Jugador jugador1 = new Jugador("nn");
        Jugador jugador2 = new Jugador("abc");
        Tablero tablero = new Tablero(jugador1, jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,9,5,jugador1);

        Soldado soldado = new Soldado();
        tablero.ingresarUnidadEn(soldado,10,4,jugador1);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2,13,5,jugador2);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3,10,6,jugador1);

        Soldado soldado4 = new Soldado();
        tablero.ingresarUnidadEn(soldado4,13,6,jugador2);
        //muevo Jinete para activar habilidad
        tablero.moverUnidadAPosicion(9,5,10,5);

        assertEquals(100, soldado.getPuntosDeVida());
        assertEquals(85, soldado2.getPuntosDeVida());
        assertEquals(100, soldado3.getPuntosDeVida());
        assertEquals(85, soldado4.getPuntosDeVida());
        assertEquals(100, jinete.getPuntosDeVida());
    }
}
