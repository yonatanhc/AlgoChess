package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Ataque;
import fiuba.algo3.AlgoChess.acciones.Rango;

import java.util.ArrayList;

public class Jinete extends Unidad {

    public Jinete() {
        super(100, 3);
        this.nombreDeUnidad = "Jinete";
    }

    public void activarHabilidad(){
        Rango rango = rangoDelAtaque();
        asignarTipoDeHabilidad(new Ataque(rango),0,20));
        getTipoDeHabilidad().activarHabilidad(this);
    }

    public Rango rangoDelAtaque(){
        int x = getUbicacion().getX();
        int y = getUbicacion().getY();
        ArrayList<Unidad> unidades = listaDeUnidades(x,y);
        if(){
          return new RangoCorto(getTablero()) ;
        }
        if(){
            return new RangoMedio(getTablero()) ;
        }
    }

}