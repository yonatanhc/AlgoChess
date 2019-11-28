package fiuba.algo3.AlgoChess;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFlujoDeJuego {

        @Test
        void test01ControldeTurnos(){

            AlgoChess algoChess = new AlgoChess("Juan","Alejandro");

            Jugador jugador1 = algoChess.obtenerJugadorEnEspera();
            Jugador jugador2 = algoChess.obtenerJudadorEnTurno();

            algoChess.avanzarSiguienteFase(); //Se pasa a la fase de movimiento (No hay cambio de turno)

            assertEquals(jugador1,algoChess.obtenerJugadorEnEspera() );
            assertEquals(jugador2,algoChess.obtenerJudadorEnTurno() );

            algoChess.avanzarSiguienteFase(); //Se pasa a la fase de ataque (No hay cambio de turno)

            assertEquals(jugador1,algoChess.obtenerJugadorEnEspera() );
            assertEquals(jugador2,algoChess.obtenerJudadorEnTurno() );

            algoChess.avanzarSiguienteFase(); // Se vuelve nuevamente a la fase de movimiento SE INTERCAMBIAN LOS JUGADORES

            assertEquals(jugador2,algoChess.obtenerJugadorEnEspera() );
            assertEquals(jugador1,algoChess.obtenerJudadorEnTurno() );

            algoChess.avanzarSiguienteFase(); // Se pasa a la fase de ataque nuevamente
            algoChess.avanzarSiguienteFase(); // Se pasa a la fase de Movimientos y se deberían intercambiar nuevamente los Jugadores

            assertEquals(jugador1,algoChess.obtenerJugadorEnEspera() );
            assertEquals(jugador2,algoChess.obtenerJudadorEnTurno() );



        }

}
