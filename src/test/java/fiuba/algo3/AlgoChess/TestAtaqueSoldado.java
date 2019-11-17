package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestAtaqueSoldado {

    @Test
    void ataqueSoldado() {
        Tablero tablero = new Tablero();
        Soldado soldado = new Soldado();// vida de soldado 100
        Jugador jugador = new Jugador("marisol");
        tablero.ingresarUnidadEn(soldado, 4, 3,jugador);

        Jugador jugador2 = new Jugador("manuel");
        Jinete jinete1 = new Jinete(); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 3, 2,jugador2);


        Jinete jinete2 = new Jinete();
        tablero.ingresarUnidadEn(jinete2, 2, 4,jugador2);

        soldado.activarHabilidad();

        assertEquals(90, jinete1.getPuntosDeVida());
        assertEquals(100, jinete2.getPuntosDeVida());

    }
}
