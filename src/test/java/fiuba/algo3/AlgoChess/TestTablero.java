package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTablero {

    @Test
    void comprobarCreacionDelTablero(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        CampoAliado nuevoCampo = new CampoAliado(jugador1,jugador2);
        CampoEnemigo otroCampo = new CampoEnemigo(jugador2);
        assertEquals(nuevoCampo.cantidadDeCasillerosTotales(),40);
        assertEquals(otroCampo.cantidadDeCasillerosTotales(),40);
    }

    @Test
    void comprobarIngresoDeUnidadEnPosicionX1Y2(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        CampoAliado nuevoTablero = new CampoAliado(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        nuevoTablero.ingresarUnidad(nuevoSoldado,1,2);
        assertEquals(nuevoTablero.obtenerUnidadDePosicion(1,2),nuevoSoldado);
    }

    @Test
    void comprobarErrorDePosicion(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        CampoAliado nuevoTablero = new CampoAliado(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        assertThrows(ErrorDePosicionException.class,()->{
            nuevoTablero.ingresarUnidad(nuevoSoldado,9,2);
        });

    }

    @Test
    void comprobarCasilleroLleno(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Pedro");
        CampoAliado nuevoTablero = new CampoAliado(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        nuevoTablero.ingresarUnidad(nuevoSoldado,1,2);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            nuevoTablero.ingresarUnidad(otroSoldado,1,2);
        });
    }

    @Test
    void comprobarCampoAliado(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        CampoAliado nuevoCampo = new CampoAliado(jugador1,jugador2);
        assertEquals(nuevoCampo.cantidadDeCasilleros(),20);
    }

    @Test
    void comprobarCampoEnemigo(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        CampoEnemigo otroCampo = new CampoEnemigo(jugador2);
        assertEquals(otroCampo.cantidadDeCasilleros(),20);
    }

    @Test
    void comprobarIngresoACampoEnemigo(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        CampoAliado nuevoCampo = new CampoAliado(jugador1, jugador2);
        Soldado nuevoSoldado = new Soldado();
        assertThrows(CampoContrarioException.class,()->{
            nuevoCampo.ingresarUnidad(nuevoSoldado,5,2);
        });
    }
}