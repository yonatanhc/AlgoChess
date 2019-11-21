package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.MoverCatapultaError;
import fiuba.algo3.AlgoChess.acciones.Rango;
import fiuba.algo3.AlgoChess.acciones.RangoContiguo;
import fiuba.algo3.AlgoChess.entidades.Batallon;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    private int ladoDelTablero;
    private Jugador jugadorAliado;
   private Jugador jugadorEnemigo;

    public Tablero(Jugador jugador1, Jugador jugador2){
        this.ladoDelTablero = 20;
        this.jugadorAliado = jugador1;
        this.jugadorEnemigo = jugador2;
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.inicializarTablero();
    }

    private void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for(int i = 1; i <= this.ladoDelTablero; i++){
                for (int j = 1; j <= this.ladoDelTablero; j++) {
                    Casillero casillero = new Casillero(i,j);
                    casillero.setEsEnemigo(asignarLadoDelCampo(i));
                    this.tableroDelJuego.add(casillero);
                    this.asignarLadoDelCampoAJugador(casillero,i);
                }
            }
        }
    }

    private void asignarLadoDelCampoAJugador(Casillero casilleroAAsignar, int posicion) {
        if(posicion<=this.ladoDelTablero/2){
            this.jugadorAliado.campoDelJugador(casilleroAAsignar);
        }else{
            this.jugadorEnemigo.campoDelJugador(casilleroAAsignar);
        }
    }

    //Agrego una comparacion de la posicion Horizontal para determinar el campo
    private boolean asignarLadoDelCampo(int posicion){
        return posicion<=this.ladoDelTablero/2;
    }

    public void ingresarUnidadEn(Unidad nuevaUnidad, int posicionX, int posicionY, Jugador jugador){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(casilleroALlenar.casilleroLibre()){
            if (jugador.esMiCampo(casilleroALlenar)) {
                nuevaUnidad.setUbicacion(casilleroALlenar);
                jugador.agregarUnidad(nuevaUnidad);
                nuevaUnidad.asignarTablero(this);
            }
        }else{
            throw new CasilleroOcupadoException();
        }
    }

    public  Casillero obtenerCasillero(int posicionX, int posicionY) {
        Casillero casilleroADevolver;
            for (int i = 0; i < this.tableroDelJuego.size(); i++) {
                casilleroADevolver = this.tableroDelJuego.get(i);
                if ((casilleroADevolver.getX() == posicionX) && (casilleroADevolver.getY() == posicionY)) {
                    return casilleroADevolver;
                }
            }throw new ErrorDePosicionException();
    }

    public void intercambiarPosicionDeUnidadSoldado(Unidad unidad, Casillero destino) {
        unidad.getUbicacion().cambiarEstadoDelCasilleroALibre();
        unidad.setUbicacion(destino);
    }
    public void intercambiarPosicionDeUnidad(Unidad unidad, Casillero destino){
      if (destino.casilleroLibre()) {
          if (unidad.getNombreDeUnidad() != "Catapulta") { // realizar chequeo de catapulta
              if (unidad.getNombreDeUnidad() != "Soldado") { // realizo un chequeo para la movilidad del batallon
                  unidad.getUbicacion().cambiarEstadoDelCasilleroALibre();
                  unidad.setUbicacion(destino);
              } else {
                  // Si estoy aca la unidad es soldado.
                  RangoContiguo rango= new RangoContiguo(this);
                  ArrayList<Unidad> miembrosBatallon = rango.listaDeUnidadesAfectados(unidad.getUbicacion().getX(), unidad.getUbicacion().getY());
                  //Elimino si no es soldado y es el mismo soldado seleccionado
                  miembrosBatallon.removeIf(n -> n.getClass() != unidad.getClass()|| n==unidad || n.getJugador() != unidad.getJugador());
                  miembrosBatallon.add(unidad); //Me queda una lista con el soldado seleccionado y 2 contiguos

                  if (miembrosBatallon.size() >= 3) {

                      Batallon batallon = new Batallon(unidad,miembrosBatallon);
                      batallon.moverBatallon(destino);
                  } else {
                      this.intercambiarPosicionDeUnidadSoldado(unidad,destino);
                  }
              }
          }else{
                  throw new MoverCatapultaError();
              }
          } else {
              throw new CasilleroOcupadoException();
          }
    }
    public int tamanioDelTablero(){
        return this.tableroDelJuego.size();
    }

    public void moverUnidadAPosicion(int xInicial, int yInicial, int xFinal, int yFinal){
        Casillero casilleroOrigen = this.obtenerCasillero(xInicial,yInicial);
        Unidad unidadAMover = casilleroOrigen.obtenerUnidad();
        Casillero casilleroDestino = this.obtenerCasillero(xFinal,yFinal);
        intercambiarPosicionDeUnidad(unidadAMover,casilleroDestino);
        unidadAMover.activarHabilidad();
    }
}
