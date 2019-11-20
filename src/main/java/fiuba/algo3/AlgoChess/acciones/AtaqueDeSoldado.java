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
        ArrayList<Unidad> unidadesAfectadas = rangoDelAtaque(unidad.getUbicacion().getX(),unidad.getUbicacion().getY());

        for (int i = 0; i < unidadesAfectadas.size();i++){
            unidadesAfectadas.get(i).recibirDanio(this.danioCuerpoACuerpo);
        }
    }

    public ArrayList<Unidad> rangoDelAtaque(int x, int y){
        ArrayList<Unidad> unidadesAfectadas = new ArrayList<Unidad>();
        for(int i = 1; i <= 2;i++){
            listaDeUnidadesAfectadas(x,y,i,unidadesAfectadas);
        }
        filtrarUnidades(this.unidadAtacante,unidadesAfectadas,true);

        return unidadesAfectadas;
    }


}
