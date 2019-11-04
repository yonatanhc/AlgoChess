package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class PruebaTableroTest {

    /*
        el Tablero es de 8x5
        el Tablero esta 'dividido' en TableroAliado (que va desde (1,1) hasta el (4,5)) y el TableroEnemigo (es desde (5,1) hasta (8,5))
    */

    @Test
    public void test01NoSePuedeUbicarUnidadEnUnCasilleroOcupado(){
        Tablero tablero = new Tablero(); // todos los casilleros estan libre
        Jinete jinete = new Jinete();
        tablero.ubicarUnidadEn(jinete,3,4); // el casillero(3,4) esta ocupado

        Jinete otroJinete = new Jinete();
        assertThrows(CasilleroNoEstaLibreExcepcion.class,
                ()->{
                    tablero.ubicarUnidadEn(otroJinete, 3, 4);
                });
    }
    /*
	@Test
	public void test01UbicarUnidadAliadaEnCasilleroAliadoConExito() {
			Tablero tablero = new Tablero();
			Jugador jugador = new Jugador("maria");
			jugador.asignarTablero(new TableroEnemigo()); // del jugador maria su lado del tablero es: desde(5,1) hasta  (8,5)

			Jinete jinete = new Jinete();
			jugador.agregarUnidad(jinete);

			tablero.ubicarUnidadEn(jinete, 6, 3);

			assertEquals();
	}

    */
    @Test
    public void test02NoSePuedeUbicarUnidadAliadaEnCasilleroAliadoOcupado() {

        Tablero tablero = new Tablero();

        Jugador jugador = new Jugador("manuel");
        jugador.asignarTablero(new TableroAliado());

        Jinete jinete = new Jinete();
        jugador.agregarUnidad(jinete);

        tablero.ubicarUnidadEn(jinete,4,5);

        Jinete otroJinete = new Jinete();
        jugador.agregarUnidad(otroJinete);

        assertThrows(CasilleroNoEstaLibreExcepcion.class,
                ()->{
                    tablero.ubicarUnidadEn(otroJinete, 4, 5);
                });
    }


    @Test
    public void test03NoSePuedeUbicarUnidadAliadaEnTableroEnemigo() {
        Tablero tablero = new Tablero();

        Jugador jugador = new Jugador("jorge");
        jugador.asignarTablero(new TableroAliado()); //el tablero aliado comprende desde (1,1) hasta (4,5)

        Jinete jinete = new Jinete();
        jugador.agregarUnidad(jinete); // el jinete pertenece al jugador jorge y solo se puede ubicar en su lado del tablero
                                        // en este caso en lado aliado

        assertThrows(CasilleroEnemigoExcepcion.class,
                ()->{
                    tablero.ubicarUnidadEn(jinete, 7, 5); // el (7,5) en este caso representa el lado enemigo
                });
    }

}
