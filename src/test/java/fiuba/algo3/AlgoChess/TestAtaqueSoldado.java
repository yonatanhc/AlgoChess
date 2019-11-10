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
        Soldado soldado = new Soldado(tablero);// vida de soldado 100
        tablero.ingresarUnidadEn(soldado, 4, 3);


        Jinete jinete1 = new Jinete(tablero); // vida de jinete 100
        tablero.ingresarUnidadEn(jinete1, 3, 2);


        Jinete jinete2 = new Jinete(tablero);
        tablero.ingresarUnidadEn(jinete2, 2, 4);


        Jinete jinete3 = new Jinete(tablero);
        tablero.ingresarUnidadEn(jinete3, 6, 2);



        soldado.activarHabilidad();//realiza daño de 10

        assertEquals(90, jinete1.getPuntosDeVida());
        assertEquals(90, jinete2.getPuntosDeVida());
        assertEquals(90, jinete3.getPuntosDeVida());
    }
}
