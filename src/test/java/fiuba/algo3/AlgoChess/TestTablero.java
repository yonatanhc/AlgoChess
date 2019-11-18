package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestTablero {

    @Test
    void test01CorrectaCreacionEInicializacionDelTablero(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        assertEquals(tablero.tamanioDelTablero(),400);
    }

    @Test
    void test02UnidadSeIngresaExitosamenteEnElTableroEnLaPosicionX1Y2(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador1);
        assertEquals(tablero.obtenerCasillero(1,2).obtenerUnidad(),nuevoSoldado);
    }

    @Test
    void test03NoSePuedeIngresarUnidadEnUnaPosicionInvalida(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        assertThrows(ErrorDePosicionException.class,()->{
            tablero.ingresarUnidadEn(nuevoSoldado,20,21,jugador1);
        });

    }

    @Test
    void test04UnidadAliadaNoSePuedeIngresarEnUnCasilleroAliadoOcupado(){
        Jugador jugador1 = new Jugador("Juan");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador1);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            tablero.ingresarUnidadEn(otroSoldado,1,2,jugador1);
        });
    }



}