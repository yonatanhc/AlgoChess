package TestUnitarios;

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

    @Test
    void testAtacarAUnSoldadoYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Soldado soldadoAAtacar = new Soldado();
        nuevoCatapulta.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),98);
    }

    @Test
    void testAtacarAUnCuranderoYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Curandero curandero = new Curandero();
        nuevoCatapulta.atacarUnidad(curandero);
        assertEquals(curandero.getPuntosDeVida(),55);
    }

    @Test
    void testAtacarAUnJineteYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Jinete jinete = new Jinete();
        nuevoCatapulta.atacarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),80);
    }

    @Test
    void testAtacarAUnaCatapultaYVerificarDanio(){
        Catapulta nuevoCatapulta = new Catapulta();
        Catapulta catapulta = new Catapulta();
        nuevoCatapulta.atacarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),30);
    }

}