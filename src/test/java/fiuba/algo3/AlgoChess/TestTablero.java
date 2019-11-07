package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTablero {
    /*
    @Test
    void test01CorrectaCreacionEInicializacionDelTablero(){
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        tablero.asignarCampoEnemigoAJugador(jugador1);
        tablero.asignarCampoAliadoAJugador(jugador2);
        assertEquals(nuevoCampo.cantidadDeCasillerosTotales(),40);
        assertEquals(otroCampo.cantidadDeCasillerosTotales(),40);
    }*/
/*
    @Test
    void test02UnidadSeIngresaExitosamenteEnElTableroEnLaPosicionX1Y2(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");
        tablero.asignarCampoAliadoAJugador(jugador);
        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEnCampoAliado(nuevoSoldado,1,2);
        assertEquals(tablero.obtenerUnidadDePosicion(1,2),nuevoSoldado);
    }

    @Test
    void test03NoSePuedeIngresarUnidadEnUnaPosicionInvalida(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");
        tablero.asignarCampoEnemigoAJugador(jugador);
        Soldado nuevoSoldado = new Soldado();
        assertThrows(ErrorDePosicionException.class,()->{
            tablero.ingresarUnidadEnCampoEnemigo(nuevoSoldado,9,2);
        });

    }

    @Test
    void test04UnidadAliadaNoSePuedeIngresarEnUnCasilleroAliadoOcupado(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");

        tablero.asignarCampoAliadoAJugador(jugador);
        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEnCampoAliado(nuevoSoldado,1,2);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            tablero.ingresarUnidadEnCampoAliado(otroSoldado,1,2);
        });
    }

    /*
    @Test
    void test05NoSePuedeIngresarUnidadAliadaEnUnCampoEnemigo(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pedro");
        tablero.asignarCampoAliadoAJugador(jugador);
        Soldado nuevoSoldado = new Soldado();
        jugador.agregarUnidad(nuevoSoldado);
        assertThrows(CampoContrarioException.class,()->{
            tablero.ingresarUnidadEnCampoEnemigo(nuevoSoldado,5,2);
        });
    }*/
}