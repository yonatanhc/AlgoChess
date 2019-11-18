package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCuracionDelCurandero {

    @Test
    void test01CuracionCatapulta() {
        Curandero curandero = new Curandero();// vida de curandero 75
        Jugador jugador1 = new Jugador("marisol");
        Jugador jugador2 = new Jugador("Manuel");
        Tablero tablero = new Tablero(jugador1,jugador2);
        tablero.ingresarUnidadEn(curandero, 9, 3,jugador1);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 10, 2,jugador1);

        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 11, 3,jugador2);

        Catapulta catapulta = new Catapulta(); // vida de jinete 100
        tablero.ingresarUnidadEn(catapulta, 4, 4,jugador1);

        curandero.activarHabilidad();

        assertEquals(115, jinete1.getPuntosDeVida());
        assertEquals(100, jinete2.getPuntosDeVida());
        assertEquals(50, catapulta.getPuntosDeVida());

    }
}
