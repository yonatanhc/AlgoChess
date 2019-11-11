package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AtaqueDeCatapulta extends Habilidad {
    private int danioADistancia;

    public AtaqueDeCatapulta(Tablero tablero){
        super(new Rango(tablero));
        this.danioADistancia = 20;
    }

    public void activarHabilidad(Unidad unidad){
        ArrayList<Unidad> unidadesAfectadas = listaDeUnidadesAfectados(unidad.getUbicacion().getX(),unidad.getUbicacion().getY());
        for (int i = 0; i < unidadesAfectadas.size() ; i++){
            unidadesAfectadas.get(i).recibirDanio(danioADistancia);
        }
    }

    public ArrayList<Unidad> listaDeUnidadesAfectados(int x, int y) {
        ArrayList<Unidad> unidades = new  ArrayList<Unidad>();
        int rango = 6;
        while(unidades.size() == 0){
            listaDeUnidadesAfectados(x,y,rango,unidades);
            rango++;
        }
        if(unidades.size() > 0){
            Unidad unidadAtacar = unidades.get(0); //primer enemigo alcanzado
            return iterador(unidadAtacar,1);
        }
        return unidades;
    }

    public ArrayList<Unidad> iterador(Unidad unidad,int cantidad){
        ArrayList<Unidad> unidades = new  ArrayList<Unidad>();
        unidades.add(unidad);
        while(cantidad <= unidades.size()){
            int x = unidades.get(cantidad -1).getUbicacion().getX();
            int y = unidades.get(cantidad- 1).getUbicacion().getY();
            listaDeUnidadesAfectados(x,y,1,unidades);
            cantidad++;
        }
        return unidades;
    }
}
