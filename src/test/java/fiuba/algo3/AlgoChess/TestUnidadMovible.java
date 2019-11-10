package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fiuba.algo3.AlgoChess.entidades.Batallon;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroOcupadoException;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

public class TestUnidadMovible {

    @Test
    void test01JineteSePuedeMoverEnTodaDireccion(){
        Tablero tablero = new Tablero();
        Jinete jinete = new Jinete();
        Casillero ubicacion = tablero.obtenerCasillero(3,4);
        Casillero otraUbicacion = tablero.obtenerCasillero(3,5);

        jinete.setUbicacion(ubicacion);//al jinete se le ubica en el casillero (3,4)

        tablero.moverUnidadA(jinete,otraUbicacion);// la nueva ubicacion del casillero es (3,5)

        assertTrue(otraUbicacion.casilleroLibre());
        assertEquals(jinete.getUbicacion(), tablero.obtenerCasillero(3, 5));

    }

    @Test
    void test02SoldadoNoSePuedeMoverAUnCasilleroOcupado(){
        Tablero tablero = new Tablero();
        Casillero ubicacion = tablero.obtenerCasillero(7,5);
        Soldado soldado = new Soldado();
        soldado.setUbicacion(ubicacion);//soldado se ubica en el casillero (7,5)
        Casillero otraUbicacion = tablero.obtenerCasillero(6,5);
        Curandero curandero = new Curandero();
        curandero.setUbicacion(otraUbicacion);//curandero se ubica en el casillero (6,5)
        assertThrows(CasilleroOcupadoException.class,()->{
            tablero.moverUnidadA(soldado,ubicacion);
        });
    }
/*
    @Test
    void test03PruebaMovimientoBatallon(){
        Tablero tablero = new Tablero();
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Batallon batallon;

        Casillero ubicacion;

        ubicacion = tablero.obtenerCasillero(3,4);
        soldado1.setUbicacion(ubicacion);
        ubicacion = tablero.obtenerCasillero(2,3);
        soldado2.setUbicacion(ubicacion);
        ubicacion = tablero.obtenerCasillero(3,5);
        soldado3.setUbicacion(ubicacion);

        ubicacion = tablero.obtenerCasillero(2,4);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        assertEquals(soldado1.getUbicacion(), tablero.obtenerCasillero(2, 4));
        assertEquals(soldado2.getUbicacion(), tablero.obtenerCasillero(1, 3));
        assertEquals(soldado3.getUbicacion(), tablero.obtenerCasillero(2, 5));

    }*/

}
