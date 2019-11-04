package fiuba.algo3.AlgoChess;

public class Movilidad {
    public Movilidad(){

    }

    public void moverUnidadA(Unidad unidad, Casillero desde,Casillero hasta){
        if(hasta.casilleroEstaLibre()){
            hasta.ingresarUnidad(unidad);
            desde.cambiarEstadoALibre();
        }
    }
}
