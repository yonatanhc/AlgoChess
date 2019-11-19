package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

public class TestAtaqueCatapulta {
    @Test
    void test01AtaqueDeCatapulta(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,5,10,jugador);

        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,11,9,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,10,10,jugador);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,9,11,jugador);

        catapulta.activarHabilidad();

        assertEquals(80,soldado.getPuntosDeVida());
        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(55,curandero.getPuntosDeVida());
    }
    /*
    @Test
    void test02AtaqueDeCatapulta(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,8,8,jugador);

        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,18,8,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,13,8,jugador2);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,14,9,jugador2);

        catapulta.activarHabilidad();

        assertEquals(100,soldado.getPuntosDeVida());
        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(55,curandero.getPuntosDeVida());
    }*/
}
