package fiuba.algo3.AlgoChess.tableroycasilleros;

import fiuba.algo3.AlgoChess.Jugador;
import fiuba.algo3.AlgoChess.entidades.Unidad;

import java.util.ArrayList;

public class CampoEnemigo extends Tablero {

    private Jugador jugador;
    private int maximoHorizontal;
    private int minimoHorizontal;
    private ArrayList<Casillero> campo;

    public CampoEnemigo(Jugador jugadorAAsignarLado){
        this.jugador = jugadorAAsignarLado;
        this.maximoHorizontal = 4;
        this.minimoHorizontal = 1;
        this.campo = new ArrayList<Casillero>();
        this.asignarCampo(minimoHorizontal,maximoHorizontal);
    }

    @Override
    public boolean verificarValidezDelCasillero(Casillero casillero){
        if(this.campo.contains(casillero)){
            return true;
        }throw new CampoContrarioException();
    }

    @Override
    public void asignarCampo(int inicioCampo,int finalCampo){
        while (inicioCampo<=finalCampo){
            for(int j = 1;j<=this.tamanioVertical;j++){
                campo.add(this.obtenerCasillero(inicioCampo,j));
            }
            inicioCampo++;
        }
    }

    @Override
    public int cantidadDeCasilleros(){
        return this.campo.size();
    }

    public void ingresarUnidad(Unidad nuevaUnidad,int posicionX,int posicionY){
        Casillero casilleroALlenar = this.obtenerCasillero(posicionX,posicionY);
        if(verificarValidezDelCasillero(casilleroALlenar)){
            casilleroALlenar.ocuparCasilleroConUnidad(nuevaUnidad);
            this.jugador.agregarUnidad(nuevaUnidad);
        }
    }

}