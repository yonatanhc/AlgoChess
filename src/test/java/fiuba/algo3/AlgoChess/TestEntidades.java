package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntidades {

    //Una catapulta aliada ataca a una pieza enemiga y se verifica que se resta la vida
    //correspondiente.
    @Test
    public void test01CatapultaAliadaAtacaAEnemigoEstePierdeVida(){
        Catapulta catapultaAliada = new Catapulta();
        Soldado soldadoEnemigo = new Soldado();

        catapultaAliada.atacarUnidad(soldadoEnemigo);

        assertEquals(80,soldadoEnemigo.getPuntosDeVida());
    }

    //Un Soldado de infantería aliado ataca a una pieza enemiga y se verifica que se resta
    //la vida correspondiente.
    @Test
    public void test02SoldadoAliadoAtacaAEnemigoEstePierdeVida(){
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();
        soldadoAliado.atacarUnidad(soldadoEnemigo);
        assertEquals(90,soldadoEnemigo.getPuntosDeVida());
    }

}
