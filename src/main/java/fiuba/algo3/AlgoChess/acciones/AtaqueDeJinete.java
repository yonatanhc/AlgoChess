package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AtaqueDeJinete extends Habilidad {
    private int danioCuerpoACuerpo;
    private int danioADistancia;

    public AtaqueDeJinete(Tablero tablero){
        super(new Rango(tablero));
        this.danioCuerpoACuerpo = 5;
        this.danioADistancia = 15;
    }

    public void activarHabilidad(Unidad unidad){
        ArrayList<Unidad> unidadesAfectadas = rangoDelAtaque(unidad);
        //realizar ataque ala unidades de unidadesAfectadas
    }

    public ArrayList<Unidad> rangoDelAtaque(Unidad unidad){
        int x = unidad.getUbicacion().getX();
        int y = unidad.getUbicacion().getY();
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        listaDeUnidadesAfectados(x,y,1,unidades);

        ArrayList<Unidad> unidadesAfectadas = new ArrayList<Unidad>();
        if(ataqueConArcoFlecha(unidades)){
            listaDeUnidadesAfectados(x,y,1,unidadesAfectadas);
            listaDeUnidadesAfectados(x,y,2,unidadesAfectadas);
        }
        if(ataqueConEspada(unidades)){
            listaDeUnidadesAfectados(x,y,3,unidadesAfectadas);
            listaDeUnidadesAfectados(x,y,4,unidadesAfectadas);
            listaDeUnidadesAfectados(x,y,5,unidadesAfectadas);
        }
        return unidadesAfectadas;
    }

    public boolean ataqueConArcoFlecha(ArrayList<Unidad> unidades){
        return true;
    }

    public boolean ataqueConEspada(ArrayList<Unidad> unidades){
        return false;
    }
}
