package fiuba.algo3.AlgoChess.entidades;

public class Catapulta extends Unidad {


    public Catapulta(){
        super(50,5);
        this.ataqueDeUnidad = new AtaqueALejanaDistancia(20);
        this.nombreDeUnidad = "Catapulta";
    }



}