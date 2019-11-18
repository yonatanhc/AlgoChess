package TestUnitarios;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
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
    void atacarAUnaUnidadYVerificarDanio(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,10,9,jugador1);
        tablero.ingresarUnidadEn(soldadoAAtacar,11,9,jugador2);
        nuevoSoldado.activarHabilidad();
        assertEquals(soldadoAAtacar.getPuntosDeVida(),90);
    }

}