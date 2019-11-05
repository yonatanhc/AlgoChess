package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestMovimientoUnidad {

    @Test
    public void test01UnaUnidadMovibleSePuedeMoverEnCualquierDireccion(){
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        tablero.ubicarUnidad(jinete,3,4);

        jinete.moverUnidadA(3,5,tablero);
        assertEquals(true,jinete.getUbicacion().equals(tablero.getCasillero(3,5)));
    }

    @Test
    public void test02UnaUnidadMovibleNoSePuedeMoverAUnCasilleroOcupado(){
        Tablero tablero = new Tablero();

        Jinete jinete = new Jinete();
        tablero.ubicarUnidad(jinete,5,3);

        Jinete otroJinete = new Jinete();
        tablero.ubicarUnidad(otroJinete,5,4);

        assertThrows(CasilleroNoEstaLibreExcepcion.class,
                ()->{
                    otroJinete.moverUnidadA(5,3,tablero);
                });
    }

}
