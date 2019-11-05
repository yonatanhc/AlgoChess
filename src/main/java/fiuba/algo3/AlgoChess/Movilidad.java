package fiuba.algo3.AlgoChess;

public class Movilidad {

    public void moverUnidadA(Unidad unidad,Casillero origen,Casillero destino){
        if(destino.casilleroEstaLibre()){ //&& casilleroDestinoEsValido(desde,destino)
            unidad.setUbicacion(destino);
            destino.ingresarUnidad(unidad);
            origen.cambiarEstadoALibre();
        }
    }

    /*
	private boolean casilleroDestinoEsValido(Casillero desde,Casillero hasta){

    }*/
}
