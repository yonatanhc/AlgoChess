package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.Aplicacion.flujodejuego.Fase;
import fiuba.algo3.AlgoChess.Aplicacion.flujodejuego.FaseInicial;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.Random;

public class AlgoChess {
    private Jugador jugadorEnTurno;
    private Jugador jugadorEnEspera;
    private Tablero tablero;
    private Fase faseActual;


    public  AlgoChess(String nombre1, String nombre2) {

        Random rand = new Random();

        if (rand.nextInt(2) == 0 ) {
            this.jugadorEnTurno = new Jugador(nombre1);
            this.jugadorEnEspera = new Jugador(nombre2);
        }else{
            this.jugadorEnTurno = new Jugador(nombre2);
            this.jugadorEnEspera = new Jugador(nombre1);
        }

        this.faseActual = new FaseInicial(this);
        this.tablero = new Tablero(jugadorEnTurno, jugadorEnEspera);
    }

    public void avanzarSiguienteFase(){this.faseActual.siguienteFase();}
    public void asignarFase(Fase fase){this.faseActual = fase;}

    public Jugador obtenerJudadorEnTurno(){ return this.jugadorEnTurno;}
    public Jugador obtenerJugadorEnEspera(){return this.jugadorEnEspera;}

    public Tablero obtenerTablero(){return this.tablero;}


    public void cambioDeTurno(){
        Jugador aux;
        aux = this.jugadorEnTurno;
        this.jugadorEnTurno = this.jugadorEnEspera;
        this.jugadorEnEspera = aux;
    }


}
