package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Unidad;
import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    //private int tamanioHorizontal;
    //private int tamanioVertical;
    private int ladoDelTablero;
    //private CampoAliado campoAliado;
    //private CampoEnemigo campoEnemigo;



    public Tablero(){
        this.ladoDelTablero = 20;
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.inicializarTablero();
    }

    public void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for(int i = 1; i <= this.ladoDelTablero; i++){
                for (int j = 1; j <= this.ladoDelTablero; j++) {
                    Casillero casillero = new Casillero(i,j);
                    casillero.setEsEnemigo(asignarLadoDelCampo(i));
                    this.tableroDelJuego.add(casillero);
                }
            }
        }
    }

    //Agrego una comparacion de la posicion Horizontal para determinar el campo
    private boolean asignarLadoDelCampo(int posicion){
        return posicion<=this.ladoDelTablero/2;
    }

    public void ingresarUnidadEn(Unidad nuevaUnidad,int posicionX,int posicionY,Jugador jugador){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(!casilleroALlenar.casilleroLibre()){throw new CasilleroOcupadoException();}
         else {
            nuevaUnidad.setUbicacion(casilleroALlenar);
            jugador.agregarUnidad(nuevaUnidad);
            nuevaUnidad.asignarTablero(this);
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

    public void moverUnidadA(Unidad unidad, Casillero destino){
        if(destino.casilleroLibre()){//&& unidad.getNombreDeUnidad() != "Catapulta"){ // realizar chequeo de catapulta
            unidad.getUbicacion().cambiarEstadoDelCasilleroALibre();
            unidad.setUbicacion(destino);
        }else{throw new CasilleroOcupadoException();}
    }

    public int tamanioDelTablero(){
        return this.tableroDelJuego.size();
    }

}