package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AtaqueDeCatapulta extends Habilidad {
    private int danioADistancia;
    private Unidad unidadAtacante;

    public AtaqueDeCatapulta(Tablero tablero){
        super(new Rango(tablero));
        this.danioADistancia = 20;
    }

    public void activarHabilidad(Unidad unidad){
        this.unidadAtacante = unidad;
        ArrayList<Unidad> unidadesAfectadas = listaDeUnidades(unidad.getUbicacion().getX(),unidad.getUbicacion().getY());
        for (int i = 0; i < unidadesAfectadas.size() ; i++){
            unidadesAfectadas.get(i).recibirDanio(danioADistancia);
        }
    }

    private ArrayList<Unidad> listaDeUnidades(int x, int y) {
        Unidad unidadEnemiga = primeraUnidadEnemiga(x,y);

        return iterador(unidadEnemiga,1);
        /*
        if(unidadEnemiga != null){
            return iterador(unidadEnemiga,1);
        }*/

    }

    //devuelve una lista con todas las  unidades adayacentes contiguas
    private ArrayList<Unidad> iterador(Unidad unidad,int cantidad){
        ArrayList<Unidad> unidades = new  ArrayList<Unidad>();
        unidades.add(unidad);
        while(cantidad <= unidades.size()){
            this.listaDeUnidadesAfectadas(unidades.get(cantidad -1).getUbicacion().getX(),unidades.get(cantidad- 1).getUbicacion().getY(),1,unidades);
            cantidad++;
        }
        return unidades;
    }

    private Unidad primeraUnidadEnemiga(int x, int y){
        ArrayList<Unidad> unidades = new  ArrayList<Unidad>();
        int rango = 6; //rango inicial
        while(unidades.size() == 0 && rango <= 20){
            this.listaDeUnidadesAfectadas(x,y,rango,unidades);
            filtrarUnidades(this.unidadAtacante,unidades,true);//remove las unidades aliadas
            rango++;
        }
        return unidades.get(0);
    }

}
