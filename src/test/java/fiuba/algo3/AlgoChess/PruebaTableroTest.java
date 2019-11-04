package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class PruebaTableroTest {

	/*
	@Test
	public void test01UbicarUnidadAliadaEnCasilleroAliadoConExito() {
			Tablero tableroAliado = new TableroAliado();
			Unidad jinete = new Jinete();
			tableroAliado.ubicarUnidadEn(jinete, 2, 3);
			Casillero casillero = tableroAliado.getCasillero(2,3);
			assertEquals();
	}*/


    @Test
    public void test02NoSePuedeUbicarUnidadAliadaEnCasilleroAliadoOcupado() {
        Tablero tableroAliado = new TableroAliado();

        Unidad jinete = new Jinete();
        tableroAliado.ubicarUnidadEn(jinete,3,5);

        Unidad otroJinete = new Jinete();

        assertThrows(CasilleroNoEstaLibreExcepcion.class,
                ()->{
                    tableroAliado.ubicarUnidadEn(otroJinete, 3, 5);
                });
    }

    @Test
    public void test03NoSePuedeUbicarUnidadAliadaEnTableroEnemigo() {
        Tablero tableroAliado = new TableroAliado();

        Unidad jinete = new Jinete();

        assertThrows(CasilleroEnemigoExcepcion.class,
                ()->{
                    tableroAliado.ubicarUnidadEn(jinete, 7, 5);
                });
    }

}
