package TestUnitarios;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuranderoTest {
    @Test
    void testComprobarPuntosDeVidaA75(){
        Curandero curandero =new Curandero();
        assertEquals(curandero.getPuntosDeVida(),75);
    }

    @Test
    void testCosteDeCuranderoIgualA2() {
        Curandero curandero = new Curandero();
        assertEquals(curandero.getCosto(),2);
    }

    @Test
    void testAtacarAUnSoldadoYVerificarDanioInexistente(){
        Curandero curandero = new Curandero();
        Soldado soldadoAAtacar = new Soldado();
        curandero.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),100);
    }

    @Test
    void testAtacarAUnCuranderoYVerificarDanioInexistente(){
        Curandero curandero = new Curandero();
        Curandero nuevoCurandero = new Curandero();
        curandero.atacarUnidad(nuevoCurandero);
        assertEquals(nuevoCurandero.getPuntosDeVida(),75);
    }

    @Test
    void testAtacarAUnJineteYVerificarDanioInexistente(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        curandero.atacarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),100);
    }

    @Test
    void testAtacarAUnaCatapultaYVerificarDanio(){
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        curandero.curarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),50);
    }

    @Test
    void testCurarAUnSoldadoYVerificarDanioInexistente(){
        Curandero curandero = new Curandero();
        Soldado soldadoAAtacar = new Soldado();
        curandero.curarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeVida(),115);
    }

    @Test
    void testCurarAUnCuranderoYVerificarCuracion(){
        Curandero curandero = new Curandero();
        Curandero nuevoCurandero = new Curandero();
        curandero.curarUnidad(nuevoCurandero);
        assertEquals(nuevoCurandero.getPuntosDeVida(),90);
    }

    @Test
    void testCurarAUnJineteYVerificarCuracion(){
        Curandero curandero = new Curandero();
        Jinete jinete = new Jinete();
        curandero.curarUnidad(jinete);
        assertEquals(jinete.getPuntosDeVida(),115);
    }

    @Test
    void testCurarAUnaCatapultaYVerificarQueNoSeCura(){
        Curandero curandero = new Curandero();
        Catapulta catapulta = new Catapulta();
        curandero.curarUnidad(catapulta);
        assertEquals(catapulta.getPuntosDeVida(),50);
    }

}