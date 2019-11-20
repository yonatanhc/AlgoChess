package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;
import fiuba.algo3.AlgoChess.tableroycasilleros.Tablero;

import java.util.ArrayList;

public class AtaqueDeJinete extends Habilidad {
    private int danioCuerpoACuerpo;
    private int danioADistancia;
    private Unidad unidadAtacante;

    public AtaqueDeJinete(Tablero tablero){
        super(new Rango(tablero));
        this.danioCuerpoACuerpo = 5;
        this.danioADistancia = 15;
    }

    public void activarHabilidad(Unidad unidad){
        this.unidadAtacante = unidad;
        int x = unidad.getUbicacion().getX();
        int y = unidad.getUbicacion().getY();
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        listaDeUnidadesAfectadas(x,y,1,unidades);
        listaDeUnidadesAfectadas(x,y,2,unidades);
        tipoDeAtaqueAUsar(x,y,unidades);

    }

    private void tipoDeAtaqueAUsar(int x, int y ,ArrayList<Unidad> unidades){

        if(contieneSoloEnemigosCercanos(unidades)){
                ataqueConEspada();
        }
        else{
             if(contieneSoldadoAliado(unidades)){
                 ataqueConArcoFlecha();
             }
        }
    }
    private void ataqueConArcoFlecha(){
        ArrayList<Unidad> unidades = rangoDelAtaque(3,5);
        filtrarUnidades(this.unidadAtacante,unidades,true);
        for (int i = 0; i< unidades.size();i++){
            unidades.get(i).recibirDanio(this.danioADistancia);
        }

    }

    private void ataqueConEspada(){
        ArrayList<Unidad> unidades = rangoDelAtaque(1,2);
        //filtrarUnidades(this.unidadAtacante,unidades,true);
        for (int i = 0; i< unidades.size();i++){
            unidades.get(i).recibirDanio(this.danioCuerpoACuerpo);
        }
    }

    private ArrayList<Unidad> rangoDelAtaque(int inicio, int fin){
        int x = this.unidadAtacante.getUbicacion().getX();
        int y = this.unidadAtacante.getUbicacion().getY();
        ArrayList<Unidad> unidadesAfectadas = new ArrayList<Unidad>();
        for(int i = inicio ; i <= fin ; i++){
            listaDeUnidadesAfectadas(x,y,i,unidadesAfectadas);
        }
        return unidadesAfectadas;
    }

    private boolean contieneSoldadoAliado(ArrayList<Unidad> unidades){
        for (int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).getNombreDeUnidad() == "Soldado"){
                return true;
            }
        }
        return false;
    }

    private boolean contieneSoloEnemigosCercanos(ArrayList<Unidad> unidades){
        for (int i = 0; i < unidades.size(); i++){
            if(unidades.get(i).getJugador().equals(this.unidadAtacante.getJugador())){
                return false;
            }
        }
        return true;
    }
}
