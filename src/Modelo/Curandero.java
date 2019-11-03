package Modelo;

public class Curandero extends Unidades {

    protected AtaqueDeSanacion sanar;

    public Curandero(){
        super(75,2);
        this.sanar= new AtaqueDeSanacion(15);
    }

    @Override
    public void atacarUnidad(Unidades unidadAAtacar){
        unidadAAtacar.recibirDanio(0);
    }

    @Override
    public void moverUnidad(){

    }

    public void curarUnidad(Unidades unidadAAtacar) {
        unidadAAtacar.sanarDanio(this.sanar.devolverPuntosDeAtaque());
    }
}
