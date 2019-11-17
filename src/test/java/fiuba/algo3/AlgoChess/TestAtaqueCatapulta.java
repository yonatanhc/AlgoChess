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
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("jorge");
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,12,10,jugador);

        Jugador jugador2 = new Jugador("manuel");
        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,6,9,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,5,10,jugador);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,5,11,jugador);

        catapulta.activarHabilidad();

        assertEquals(80,soldado.getPuntosDeVida());
        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(55,curandero.getPuntosDeVida());
    }

    @Test
    void test02AtaqueDeCatapulta(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("maria");
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta,8,8,jugador);

        Jugador jugador2 = new Jugador("fredy");
        Soldado soldado = new Soldado();//unidad enemiga
        tablero.ingresarUnidadEn(soldado,6,8,jugador2);

        Jinete jinete = new Jinete();
        tablero.ingresarUnidadEn(jinete,1,10,jugador2);

        Curandero curandero = new Curandero();
        tablero.ingresarUnidadEn(curandero,1,11,jugador2);

        catapulta.activarHabilidad();

        assertEquals(100,soldado.getPuntosDeVida());
        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(55,curandero.getPuntosDeVida());
    }
}
