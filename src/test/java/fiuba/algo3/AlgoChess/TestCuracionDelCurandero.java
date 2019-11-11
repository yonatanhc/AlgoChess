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
        Tablero tablero = new Tablero();
        Curandero curandero = new Curandero();// vida de soldado 100
        Jugador jugador = new Jugador("marisol");
        tablero.ingresarUnidadEn(curandero, 4, 3,jugador);

        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 2, 2,jugador);

        Jugador jugador2 = new Jugador("manuel");
        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 2, 3,jugador2);

        Catapulta catapulta = new Catapulta(); // vida de jinete 100
        tablero.ingresarUnidadEn(catapulta, 4, 4,jugador);

        curandero.activarHabilidad();

        assertEquals(115, jinete1.getPuntosDeVida());
        assertEquals(100, jinete2.getPuntosDeVida());
        assertEquals(50, catapulta.getPuntosDeVida());

    }
}
