package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldadoTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Soldado nuevoSoldado =new Soldado();
        assertEquals(nuevoSoldado.getPuntosDeVida(),100);
    }

    @Test
    void testCosteDeSoldadoIgualA1() {
        Soldado nuevoSoldado = new Soldado();
        assertEquals(nuevoSoldado.getCosto(),1);
    }

    @Test
    void testAtacarAUnSoldadoYVerificarDanio(){
        Soldado nuevoSoldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        Jugador jugador = new Jugador("anonimo");
        nuevoSoldado.perteneceAlJugador(jugador);
        nuevoSoldado.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),90);
    }
    @Test
    void testAtacarAUnCuranderoYVerificarDanio(){
        Soldado nuevoSoldado = new Soldado();
        Curandero curandero = new Curandero();
        Jugador jugador = new Jugador("anonimo");
        nuevoSoldado.perteneceAlJugador(jugador);
        nuevoSoldado.atacarUnidad(curandero);
        assertEquals(curandero.getPuntosDeVida(),65);
    }

    @Test
    void testAtacarAUnJineteYVerificarDanio(){
        Soldado nuevoSoldado = new Soldado();
        Jinete jinete = new Jinete();
        Jugador jugador = new Jugador("anonimo");
        nuevoSoldado.perteneceAlJugador(jugador);
        nuevoSoldado.atacarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),90);
    }

    @Test
    void testAtacarAUnaCatapultaYVerificarDanio(){
        Soldado nuevoSoldado = new Soldado();
        Catapulta catapulta = new Catapulta();
        Jugador jugador = new Jugador("anonimo");
        nuevoSoldado.perteneceAlJugador(jugador);
        nuevoSoldado.atacarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),40);
    }

}