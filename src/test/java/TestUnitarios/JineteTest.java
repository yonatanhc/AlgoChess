package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JineteTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Jinete nuevoJinete =new Jinete();
        assertEquals(nuevoJinete.getPuntosDeVida(),100);
    }

    @Test
    void testCosteDeJineteIgualA3() {
        Jinete nuevoJinete = new Jinete();
        assertEquals(nuevoJinete.getCosto(),3);
    }
/*
    @Test
    void testAtacarAUnSoldadoYVerificarDanio(){
        Jinete nuevoJinete = new Jinete();
        Soldado soldadoAAtacar = new Soldado();
        Jugador jugador = new Jugador("anonimo");
        nuevoJinete.perteneceAlJugador(jugador);
        nuevoJinete.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),85);
    }

    @Test
    void testAtacarAUnCuranderoYVerificarDanio(){
        Jinete nuevoJinete = new Jinete();
        Curandero curandero = new Curandero();
        Jugador jugador = new Jugador("anonimo");
        nuevoJinete.perteneceAlJugador(jugador);
        nuevoJinete.atacarUnidad(curandero);
        assertEquals(curandero.getPuntosDeVida(),60);
    }

    @Test
    void testAtacarAUnJineteYVerificarDanio(){
        Jinete nuevoJinete = new Jinete();
        Jinete jinete = new Jinete();
        Jugador jugador = new Jugador("anonimo");
        nuevoJinete.perteneceAlJugador(jugador);
        nuevoJinete.atacarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),85);
    }

    @Test
    void testAtacarAUnaCatapultaYVerificarDanio(){
        Jinete nuevoJinete = new Jinete();
        Catapulta catapulta = new Catapulta();
        Jugador jugador = new Jugador("anonimo");
        nuevoJinete.perteneceAlJugador(jugador);
        nuevoJinete.atacarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),35);
    }*/

}