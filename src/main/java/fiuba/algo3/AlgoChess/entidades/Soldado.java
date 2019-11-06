package fiuba.algo3.AlgoChess.entidades;

import fiuba.algo3.AlgoChess.acciones.AtaqueACortaDistancia;

public class Soldado extends Unidad {

    private AtaqueACortaDistancia ataqueDelSoldado;


    public Soldado(){
        super(100,1);
        ataqueDelSoldado = new AtaqueACortaDistancia(10, 0);
    }

    public void atacarUnidad(Unidad unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDelSoldado.devolverPuntosDeAtaqueCuerpoACuerpo());
    }

}