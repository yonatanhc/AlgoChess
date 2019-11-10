package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.Rango;
import fiuba.algo3.AlgoChess.acciones.RangoContiguo;
import fiuba.algo3.AlgoChess.tableroycasilleros.Casillero;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;
import java.util.List;

public class Batallon {
    private Tablero tablero;
    private List<Unidad> miembrosBatallon;
    private int maxCantMiembros = 3;
    private RangoContiguo rango;



    public Batallon(Soldado soldado){
        this.tablero = soldado.getTablero();
        this.rango = new RangoContiguo(tablero);
        this.miembrosBatallon = new ArrayList<Unidad>();

        ArrayList<Unidad> unidadesCercanas = rango.listaDeUnidadesAfectados(soldado.getUbicacion().getX(),soldado.getUbicacion().getY());

        //Elimino si no es soldado y es el mismo soldado seleccionado
        unidadesCercanas.removeIf(n -> n.nombreDeUnidad != "Soldado" && n == soldado && n.getJugador() != soldado.getJugador());
        this.miembrosBatallon = unidadesCercanas.subList(1,2);
        this.miembrosBatallon.add(soldado); //Me queda una lista con el soldado seleccionado y 2 contiguos
    }

    public void moverBatallon(Casillero casilleroDestino){

        int xOrigen = this.miembrosBatallon.get(maxCantMiembros).getUbicacion().getX();
        int yOrigen = this.miembrosBatallon.get(maxCantMiembros).getUbicacion().getY();

        for(int i = maxCantMiembros; i>0; i--){

            int xdiff = xOrigen - this.miembrosBatallon.get(i).getUbicacion().getX();
            int ydiff = yOrigen - this.miembrosBatallon.get(i).getUbicacion().getY();

            casilleroDestino = tablero.obtenerCasillero(casilleroDestino.getX()+xdiff,casilleroDestino.getY()+ydiff);
            tablero.moverUnidadA(this.miembrosBatallon.get(i),casilleroDestino);
        }




        
    }

}
