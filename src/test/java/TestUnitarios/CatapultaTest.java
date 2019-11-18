package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatapultaTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Catapulta nuevoCatapulta =new Catapulta();
        assertEquals(nuevoCatapulta.getPuntosDeVida(),50);
    }

    @Test
    void testCosteDeCatapultagualA5() {
        Catapulta nuevoCatapulta = new Catapulta();
        assertEquals(nuevoCatapulta.getCosto(),5);
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Catapulta catapulta = new Catapulta();
        Soldado soldado = new Soldado();
        tablero.ingresarUnidadEn(catapulta,8,6,jugador1);
        tablero.ingresarUnidadEn(soldado,14,6,jugador2);
        catapulta.activarHabilidad();
        assertEquals(soldado.getPuntosDeVida(),80);
    }

}