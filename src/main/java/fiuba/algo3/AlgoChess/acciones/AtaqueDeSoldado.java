package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AtaqueDeSoldado extends Habilidad {
    private int danioCuerpoACuerpo;
    private Unidad unidadAtacante;

    public AtaqueDeSoldado(Tablero tablero){
        super(new Rango(tablero));
        this.danioCuerpoACuerpo = 10;
    }

    public void activarHabilidad(Unidad unidad){
        this.unidadAtacante = unidad;
        ArrayList<Unidad> unidadesAfectados = rangoDelAtaque(unidad.getUbicacion().getX(),unidad.getUbicacion().getY());
        /*
        for (int i = 0; i < unidadesAfectados.size();i++){
            unidadesAfectados.get(i).recibirDanio(this.danioCuerpoACuerpo);
        }*/
        if(unidadesAfectados.size() > 0){
            unidadesAfectados.get(0).recibirDanio(this.danioCuerpoACuerpo);
        }

    }

    public ArrayList<Unidad> rangoDelAtaque(int x, int y){
        ArrayList<Unidad> unidadesAfectados = new ArrayList<Unidad>();
        for(int i = 1; i <= 2;i++){
            this.listaDeUnidadesAfectadas(x,y,i,unidadesAfectados);
        }
        filtrarUnidades(unidadesAfectados);

        return unidadesAfectados;
    }

    public void filtrarUnidades(ArrayList<Unidad> unidades){
        for(int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).getJugador().equals(this.unidadAtacante.getJugador())){
                unidades.remove(i);
            }
        }
    }
}
