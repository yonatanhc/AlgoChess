package fiuba.algo3.AlgoChess;

import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Curandero;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;
import org.junit.jupiter.api.Test;

public class TestAtaqueCatapulta {
    @Test
    void test01AtaqueDeCatapulta(){
        Tablero tablero = new Tablero();

        Catapulta catapulta = new Catapulta(tablero);
        tablero.ingresarUnidadEn(catapulta,12,10);

        Soldado soldado = new Soldado(tablero);
        tablero.ingresarUnidadEn(soldado,6,9);

        Jinete jinete = new Jinete(tablero);
        tablero.ingresarUnidadEn(jinete,5,10);

        Curandero curandero = new Curandero(tablero);
        tablero.ingresarUnidadEn(curandero,5,11);

        catapulta.activarHabilidad();

        assertEquals(80,soldado.getPuntosDeVida());
        assertEquals(80,jinete.getPuntosDeVida());
        assertEquals(55,curandero.getPuntosDeVida());
    }
}
