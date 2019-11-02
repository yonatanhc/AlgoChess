package Modelo;

public class Soldado extends Unidades {

    private AtaqueCuerpoACuerpo ataqueDelSoldado;

    public Soldado(){
        super(100,1);
        ataqueDelSoldado = new AtaqueCuerpoACuerpo(10);
    }

    @Override
    public void atacarUnidad(Unidades unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDelSoldado.devolverPuntosDeAtaque());
    }

    @Override
    public void moverUnidad(){

    }

}
