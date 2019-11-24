package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import fiuba.algo3.AlgoChess.entidades.*;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.CasilleroOcupadoException;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

public class TestUnidadMovible {

    @Test
    void test01JineteSePuedeMoverEnTodaDireccion(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Jinete jinete = new Jinete();
        Casillero ubicacion = tablero.obtenerCasillero(3,4);
        Casillero otraUbicacion = tablero.obtenerCasillero(3,5);

        jinete.setUbicacion(ubicacion);//al jinete se le ubica en el casillero (3,4)

        tablero.intercambiarPosicionDeUnidad(jinete,otraUbicacion);// la nueva ubicacion del casillero es (3,5)

        assertTrue(ubicacion.casilleroLibre());
        assertEquals(jinete.getUbicacion(), tablero.obtenerCasillero(3, 5));

    }

    @Test
    void test02SoldadoNoSePuedeMoverAUnCasilleroOcupado(){
        Jugador jugador = new Jugador("juan");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Casillero ubicacion = tablero.obtenerCasillero(7,5);
        Soldado soldado = new Soldado();
        soldado.setUbicacion(ubicacion);//soldado se ubica en el casillero (7,5)
        Casillero otraUbicacion = tablero.obtenerCasillero(6,5);
        Curandero curandero = new Curandero();
        curandero.setUbicacion(otraUbicacion);//curandero se ubica en el casillero (6,5)
        assertThrows(CasilleroOcupadoException.class,()->{
            tablero.intercambiarPosicionDeUnidad(soldado,ubicacion);
        });
    }

    @Test
    void test03PruebaMovimientoBatallon(){
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Batallon batallon;

        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1,3,4,jugador);
        tablero.ingresarUnidadEn(soldado2,2,3,jugador);
        tablero.ingresarUnidadEn(soldado3,3,5,jugador);

        ubicacion = tablero.obtenerCasillero(2,4);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        assertEquals(tablero.obtenerCasillero(2, 4), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1, 3),soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2, 5), soldado3.getUbicacion());

    }

    @Test
    void test04BatallonUnoSeQuedaQuietoPorObstaculoDePosicionFueraDelTablero(){
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();

        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Batallon batallon;

        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1,2,2,jugador);
        tablero.ingresarUnidadEn(soldado2,1,1,jugador);
        tablero.ingresarUnidadEn(soldado3,3,3,jugador);

        ubicacion = tablero.obtenerCasillero(1,2);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        //verificamos que el soldado1, no se mueve de su lugar
        assertEquals(tablero.obtenerCasillero(1, 2), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1, 1), soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2, 3), soldado3.getUbicacion());

    }

    @Test
    void test05BatallonUnoSeQuedaQuietoPorObstaculoDeCasilleroOcupado(){
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jinete jineteObstaculo = new Jinete();

        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Batallon batallon;

        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1,3,4,jugador);
        tablero.ingresarUnidadEn(soldado2,2,3,jugador);
        tablero.ingresarUnidadEn(soldado3,3,5,jugador);
        tablero.ingresarUnidadEn(jineteObstaculo,2,4,jugador);

        ubicacion = tablero.obtenerCasillero(2,4);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        //verificamos que el soldado1, no se mueve de su lugar
        assertEquals(tablero.obtenerCasillero(3, 4), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1, 3), soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2, 5), soldado3.getUbicacion());

        assertEquals(tablero.obtenerCasillero(2,4),jineteObstaculo.getUbicacion());

    }

    @Test
    void test06PruebaBatallonSeDisuelveCuandoUnSoldadoSeAleja(){

        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Batallon batallon;


        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1,3,4,jugador);
        tablero.ingresarUnidadEn(soldado2,2,3,jugador);
        tablero.ingresarUnidadEn(soldado3,3,5,jugador);

        ubicacion = tablero.obtenerCasillero(2,4);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        assertEquals(tablero.obtenerCasillero(2, 4), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1, 3),soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2, 5), soldado3.getUbicacion());

        //alejo una de las unidades
        tablero.intercambiarPosicionDeUnidad(soldado3,tablero.obtenerCasillero(2,6));
        //creo nuevamente el batallon
        batallon = new Batallon(soldado1);

        ubicacion = tablero.obtenerCasillero(2,3);
        batallon.moverBatallon(ubicacion);


        assertEquals(tablero.obtenerCasillero(2,3), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1,2), soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2,6), soldado3.getUbicacion()); //Este soldado se queda en el mismo lugar
    }


    @Test
    void test07PruebaBatallonSoloTomaHasta3SoldadosAliados() {
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Soldado soldado4 = new Soldado();
        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Batallon batallon;


        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1, 2, 2, jugador);
        tablero.ingresarUnidadEn(soldado2, 1, 2, jugador);
        tablero.ingresarUnidadEn(soldado3, 3, 2, jugador);
        tablero.ingresarUnidadEn(soldado4, 1, 3, jugador);

        ubicacion = tablero.obtenerCasillero(3, 3);

        batallon = new Batallon(soldado1);

        batallon.moverBatallon(ubicacion);

        assertEquals(tablero.obtenerCasillero(3, 3), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(1, 2), soldado2.getUbicacion()); //Este soldado se queda quieto
        assertEquals(tablero.obtenerCasillero(4, 3), soldado3.getUbicacion());
        assertEquals(tablero.obtenerCasillero(2, 4), soldado4.getUbicacion());
    }
    @Test
    void test08PruebaMovimientoBatallonDentroDelTablero(){
        Soldado soldado1 = new Soldado();
        Soldado soldado2 = new Soldado();
        Soldado soldado3 = new Soldado();
        Jugador jugador = new Jugador("jugador");
        Jugador jugador2 = new Jugador("Pedro");
        Tablero tablero = new Tablero(jugador,jugador2);
        Casillero ubicacion;

        tablero.ingresarUnidadEn(soldado1,7,6,jugador);
        tablero.ingresarUnidadEn(soldado2,8,6,jugador);
        tablero.ingresarUnidadEn(soldado3,6,6,jugador);

        ubicacion = tablero.obtenerCasillero(7,7);
        tablero.intercambiarPosicionDeUnidad(soldado1,ubicacion);
        ubicacion = tablero.obtenerCasillero(7,7);

        assertEquals(tablero.obtenerCasillero(7, 7), soldado1.getUbicacion());
        assertEquals(tablero.obtenerCasillero(8, 7),soldado2.getUbicacion());
        assertEquals(tablero.obtenerCasillero(6, 7), soldado3.getUbicacion());
    }

    //Movimiento de una Unidad en todas las direcciones

    @Test
    void moverUnidadAdelante(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,2,3);
        assertEquals(tablero.obtenerCasillero(2,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadAtras(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,2,1);
        assertEquals(tablero.obtenerCasillero(2,1).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,2);
        assertEquals(tablero.obtenerCasillero(3,2).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,2);
        assertEquals(tablero.obtenerCasillero(1,2).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalSuperiorDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,3);
        assertEquals(tablero.obtenerCasillero(3,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalSuperiorIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,3);
        assertEquals(tablero.obtenerCasillero(1,3).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalInferiorIzquierda(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,1,1);
        assertEquals(tablero.obtenerCasillero(1,1).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadDiagonalInferiorDerecha(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 2,2,jugador1);
        tablero.moverUnidadAPosicion(2,2,3,1);
        assertEquals(tablero.obtenerCasillero(3,1).obtenerUnidad(),soldadoAMover);
    }

    @Test
    void moverUnidadYVerificarAtacaInmediato(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Soldado soldadoAMover = new Soldado();
        Soldado soldadoARecibirDanio = new Soldado();
        tablero.ingresarUnidadEn(soldadoAMover, 9,2,jugador1);
        tablero.ingresarUnidadEn(soldadoARecibirDanio,11,2,jugador2);
        //Verifico salud de la unidad enemiga antes de mover unidad
        assertEquals(soldadoARecibirDanio.getPuntosDeVida(),100);
        tablero.moverUnidadAPosicion(9,2,10,2);
        //Verifico el danio recibido despues de mover unidad
        assertEquals(soldadoARecibirDanio.getPuntosDeVida(),90);
    }

    @Test
    void moverUnidadCuranderoYVerificarCurarInmediato(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Curandero curandero = new Curandero();
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        tablero.ingresarUnidadEn(curandero, 9,2,jugador1);
        tablero.ingresarUnidadEn(soldadoEnemigo,11,2,jugador2);
        tablero.ingresarUnidadEn(soldadoAliado,10,2,jugador1);
        //Verifico salud de la unidad enemiga y aliada antes de mover unidad
        assertEquals(soldadoAliado.getPuntosDeVida(),100);
        assertEquals(soldadoEnemigo.getPuntosDeVida(),100);
        tablero.moverUnidadAPosicion(9,2,10,3);
        //Verifico la salud recibido despues de mover unidad
        assertEquals(soldadoAliado.getPuntosDeVida(),115);
        assertEquals(soldadoEnemigo.getPuntosDeVida(),100);
    }

    @Test
    void moverCatapultaError(){
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Catapulta catapulta = new Catapulta();
        tablero.ingresarUnidadEn(catapulta, 2,2,jugador1);
        assertThrows(MoverCatapultaError.class,()->{
            tablero.moverUnidadAPosicion(2,2,3,1);
        });
    }

}
