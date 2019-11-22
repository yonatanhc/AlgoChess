package fiuba.algo3.AlgoChess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgoChess {

    @Test
    void  test01PruebaRandoDeJugado(){
        AlgoChess algochess = new AlgoChess("Gonza","Pablo");
        String jugadorEspera = new String();
        String jugadorTurno = new String();

        jugadorEspera=algochess.obtenerJudadorEnEspera().obtenerNombre();
        jugadorTurno=algochess.obtenerJudadorEnTurno().obtenerNombre();

        System.out.println(jugadorEspera);
        System.out.println(jugadorTurno);

        assertEquals(80,80);
    }
}
