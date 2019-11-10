package fiuba.algo3.AlgoChess.entidades;

public class Soldado extends Unidad {

    public Soldado(){
        super(100,1);
        this.nombreDeUnidad = "Soldado";
        this.ataqueDeUnidad = new AtaqueACortaDistancia(10);
    }




}