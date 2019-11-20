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
        tablero.ingresarUnidadEn(curandero, 9, 3,jugador1);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 10, 2,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 3,jugador2);

        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta, 4, 4,jugador1);

        curandero.activarHabilidad();

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
        tablero.ingresarUnidadEn(curandero, 1, 1,jugador1);

        Soldado soldado1 = new Soldado(); // vida de jinete 100
        tablero.ingresarUnidadEn(soldado1, 1, 2,jugador1);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 15, 15,jugador2);
        tablero.moverUnidadAPosicion(15,15,2,2);

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 3, 3,jugador1);

        curandero.activarHabilidad();

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
        tablero.ingresarUnidadEn(curandero, 20, 20,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete, 19, 19,jugador2);

        Soldado soldado2 = new Soldado();
        tablero.ingresarUnidadEn(soldado2, 1, 1,jugador1);
        tablero.moverUnidadA(soldado2,tablero.obtenerCasillero(18,20));

        Soldado soldado3 = new Soldado();
        tablero.ingresarUnidadEn(soldado3, 18, 18,jugador2);

        curandero.activarHabilidad();

        assertEquals(75, curandero.getPuntosDeVida());//65
        assertEquals(115, jinete.getPuntosDeVida());//105
        assertEquals(100, soldado2.getPuntosDeVida());
        assertEquals(115, soldado3.getPuntosDeVida());

    }
}
