package fiuba.algo3.AlgoChess.acciones;

import fiuba.algo3.AlgoChess.entidades.Unidad;

import java.util.ArrayList;

public class Ataque extends Habilidad {
    private int danioCuerpoACuerpo;
    private int danioADistancia;
    private Unidad unidad;
    public Ataque(Rango rango,int danioCuerpoACuerpo, int danioADistancia){
        super(rango);
        this.danioCuerpoACuerpo = danioCuerpoACuerpo;
        this.danioADistancia = danioADistancia;
    }

    public void activarHabilidad(Unidad unidad){
        this.unidad = unidad;
        int x = unidad.getUbicacion().getX();
        int y = unidad.getUbicacion().getY();
        ArrayList<Unidad> unidadesAfectadas = listaDeUnidadesAfectadas(x,y);
       // ArrayList<Unidad> unidadesEnemigas = filtrarUnidades(unidadesAfectadas);
        realizarAtaque(unidadesAfectadas);
    }

    private void realizarAtaque(ArrayList<Unidad> unidadesEnemigas){
        for (int i = 0; i < unidadesEnemigas.size();i++){
            unidadesEnemigas.get(i).recibirDanio(this.danioADistancia);
        }
    }
    /*
    public  ArrayList<Unidad> filtrarUnidades( ArrayList<Unidad> unidades){
        ArrayList<Unidad> unidadesEnemigas = new ArrayList<Unidad>();
        for (int i = 0; i < unidades.size();i++){
            if(!this.unidad.getJugador().equals(unidades.get(i).getJugador())){
                unidadesEnemigas.add(unidades.get(i));
            }
        }
        return unidadesEnemigas;
    }*/
}
