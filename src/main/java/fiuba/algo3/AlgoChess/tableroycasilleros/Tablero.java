package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Unidad;

import java.util.ArrayList;

public class Tablero {

    private ArrayList<Casillero> tableroDelJuego;
    private int tamanioHorizontal;
    private int tamanioVertical;




    public Tablero(){
        this.tableroDelJuego = new ArrayList<Casillero>();
        this.tamanioVertical = 5;
        this.tamanioHorizontal = 8;
        this.inicializarTablero();
    }

    public void inicializarTablero() {
        if(this.tableroDelJuego.isEmpty()) {
            for(int i = 1; i <= this.tamanioHorizontal; i++){
                for (int j = 1; j <= this.tamanioVertical; j++) {
                    this.tableroDelJuego.add(new Casillero(i, j));
                }
            }
        }
    }

    private void ingresarUnidadEn(Unidad nuevaUnidad,int posicionX,int posicionY,Jugador jugador){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(casilleroALlenar.casilleroLibre()){
            nuevaUnidad.setUbicacion(casilleroALlenar);
            jugador.agregarUnidad(nuevaUnidad);
        }
        else {throw new CasilleroOcupadoException();}
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

    public Unidad obtenerUnidadDePosicion(int posicionX, int posicionY){
        return this.obtenerCasillero(posicionX,posicionY).obtenerUnidad();
    }

    private boolean esCasilleroValido(int x, int y){
        if(x >= 1 && x <= 8 && y >= 1 && y <= 5){
            return true;
        }
        throw new ErrorDePosicionException();
    }
}