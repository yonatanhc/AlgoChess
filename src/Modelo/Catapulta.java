package Modelo;

public class Catapulta extends Unidades {

    AtaqueADistancia ataqueDeLaCatapulta;

    public Catapulta(){
        super(50,5);
        this.ataqueDeLaCatapulta = new AtaqueADistancia(20);
    }

    @Override
    public void atacarUnidad(Unidades unidadAAtacar){
        unidadAAtacar.recibirDanio(ataqueDeLaCatapulta.devolverPuntosDeAtaque());
    }

    @Override
    public void moverUnidad(){

    }
}
