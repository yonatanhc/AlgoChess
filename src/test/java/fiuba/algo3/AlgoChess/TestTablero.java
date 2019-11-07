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

        assertEquals(nuevoCampo.cantidadDeCasillerosTotales(),40);
        assertEquals(otroCampo.cantidadDeCasillerosTotales(),40);
    }*/

    @Test
    void test02UnidadSeIngresaExitosamenteEnElTableroEnLaPosicionX1Y2(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");

        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador);
        assertEquals(tablero.obtenerCasillero(1,2).obtenerUnidad(),nuevoSoldado);
    }

    @Test
    void test03NoSePuedeIngresarUnidadEnUnaPosicionInvalida(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");
        Soldado nuevoSoldado = new Soldado();

        assertThrows(ErrorDePosicionException.class,()->{
            tablero.ingresarUnidadEn(nuevoSoldado,9,2,jugador);
        });

    }

    @Test
    void test04UnidadAliadaNoSePuedeIngresarEnUnCasilleroAliadoOcupado(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Juan");
        Soldado nuevoSoldado = new Soldado();
        tablero.ingresarUnidadEn(nuevoSoldado,1,2,jugador);
        Soldado otroSoldado = new Soldado();
        assertThrows(CasilleroOcupadoException.class,()->{
            tablero.ingresarUnidadEn(otroSoldado,1,2,jugador);
        });
    }

    /*
    @Test
    void test05NoSePuedeIngresarUnidadAliadaEnUnCampoEnemigo(){
        Tablero tablero = new Tablero();
        Jugador jugador = new Jugador("Pedro");
        Soldado nuevoSoldado = new Soldado();
        jugador.agregarUnidad(nuevoSoldado);

        assertThrows(CampoContrarioException.class,()->{
            tablero.ingresarUnidadEn(nuevoSoldado,5,2);
        });*/

}