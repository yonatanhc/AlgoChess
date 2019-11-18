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
        this.listaDeUnidadesAfectadas(x,y,1,unidades);
        tipoDeAtaqueAUsar(x,y,unidades);

    }

    private void tipoDeAtaqueAUsar(int x, int y ,ArrayList<Unidad> unidades){
        int cantidadInicial = unidades.size();
        filtrarUnidades(this.unidadAtacante,unidades,false);
        int cantidadFinal = unidades.size();
        if(cantidadInicial != cantidadFinal && unidades.size() == 0){
                ataqueConEspada();
        }
        else{
            for(int i = 1 ; i <= unidades.size() ; i++){
                if(unidades.get(i).getNombreDeUnidad() == "Soldado"){
                    ataqueConArcoFlecha();
                }
            }
        }


    }
    private void ataqueConArcoFlecha(){
        ArrayList<Unidad> unidades = rangoDelAtaque(3,5);
        filtrarUnidades(this.unidadAtacante,unidades,true);
        for (int i = 1; i<= unidades.size();i++){
            unidades.get(i).recibirDanio(this.danioADistancia);
        }

    }

    private void ataqueConEspada(){
        ArrayList<Unidad> unidades = rangoDelAtaque(1,2);
        filtrarUnidades(this.unidadAtacante,unidades,true);
        for (int i = 1; i<= unidades.size();i++){
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

}
