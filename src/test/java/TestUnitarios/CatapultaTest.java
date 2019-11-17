package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
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
    /*
    @Test
    void testAtacarAUnSoldadoYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Soldado soldadoAAtacar = new Soldado();
        Jugador jugador = new Jugador("anonimo");
        nuevoCatapulta.perteneceAlJugador(jugador);
        nuevoCatapulta.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),80);
    }

    @Test
    void testAtacarAUnCuranderoYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Curandero curandero = new Curandero();
        Jugador jugador = new Jugador("anonimo");
        nuevoCatapulta.perteneceAlJugador(jugador);
        nuevoCatapulta.atacarUnidad(curandero);
        assertEquals(curandero.getPuntosDeVida(),55);
    }

    @Test
    void testAtacarAUnJineteYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Jinete jinete = new Jinete();
        Jugador jugador = new Jugador("anonimo");
        nuevoCatapulta.perteneceAlJugador(jugador);
        nuevoCatapulta.atacarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),80);
    }

    @Test
    void testAtacarAUnaCatapultaYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Catapulta catapulta = new Catapulta();
        Jugador jugador = new Jugador("anonimo");
        nuevoCatapulta.perteneceAlJugador(jugador);
        nuevoCatapulta.atacarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),30);
    }*/

}