package fiuba.algo3.AlgoChess.entidades;

public class Curandero extends Unidad {


    public Curandero(){
        super(75,2);
        this.nombreDeUnidad = "Curandero";
        this.ataqueDeUnidad = new AtaqueDeSanacion(15);
    }



    public void curarUnidad(Unidad unidadASanar) {
        if(!(unidadASanar.getNombreDeUnidad() == "Catapulta")) {
            unidadASanar.sanarDanio(this.ataqueDeUnidad.devolverPuntosDeAtaque());
        }
    }

}