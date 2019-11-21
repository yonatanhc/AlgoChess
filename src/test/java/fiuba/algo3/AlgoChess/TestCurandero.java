package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCurandero {

    @Test
    void test01CuranderoNoSanaACatapultaAliada() {

        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 8, 3,jugador1);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 10, 2,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 3,jugador2);

        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta, 9, 4,jugador1);

        tablero.moverUnidadAPosicion(8,3,9,2);

        assertEquals(115, jinete1.getPuntosDeVida());
        assertEquals(100, jinete2.getPuntosDeVida());
        assertEquals(50, catapulta.getPuntosDeVida());
    }

    @Test
    void test02Curandero(){
        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 9, 2,jugador1);

        Soldado soldado1 = new Soldado(); // vida de jinete 100
        tablero.ingresarUnidadEn(soldado1, 9, 3,jugador1);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 13, 5,jugador2);
        tablero.moverUnidadAPosicion(13,5,12,5);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 9, 1,jugador1);

        tablero.moverUnidadAPosicion(9,2,10,2);

        assertEquals(75, curandero.getPuntosDeVida());
        assertEquals(115, soldado1.getPuntosDeVida());
        assertEquals(100, soldado2.getPuntosDeVida());
        assertEquals(115, soldado3.getPuntosDeVida());

    }

    @Test
    void test03Curandero(){
        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);

        Curandero curandero = new Curandero();// vida de curandero 75
        tablero.ingresarUnidadEn(curandero, 12, 2,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete, 12, 3,jugador2);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 10, 4,jugador1);
        tablero.moverUnidadAPosicion(10,4,11,4);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 11, 1,jugador2);

        tablero.moverUnidadAPosicion(12,2,11,2);

        assertEquals(65, curandero.getPuntosDeVida());//65
        assertEquals(105, jinete.getPuntosDeVida());//105
        assertEquals(100, soldado2.getPuntosDeVida());
        assertEquals(115, soldado3.getPuntosDeVida());

    }
}
