package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
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
    void testcurarAUnaUnidadYVerificarSalud(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoACurar = new Soldado();
        tablero.ingresarUnidadEn(curandero,1,2,jugador1);
        tablero.ingresarUnidadEn(soldadoACurar,2,3,jugador1);
        curandero.activarHabilidad();
        assertEquals(soldadoACurar.getPuntosDeVida(),115);
    }

    @Test
    void curanderoNoPuedeCurarUnidadEnemiga(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoACurarEnemigo = new Soldado();
        tablero.ingresarUnidadEn(curandero,10,2,jugador1);
        tablero.ingresarUnidadEn(soldadoACurarEnemigo,11,2,jugador2);
        curandero.activarHabilidad();
        assertEquals(soldadoACurarEnemigo.getPuntosDeVida(),100);
    }
}