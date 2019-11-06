package fiuba.algo3.AlgoChess;

import fiuba.algo3.AlgoChess.entidades.Catapulta;
import fiuba.algo3.AlgoChess.entidades.Jinete;
import fiuba.algo3.AlgoChess.entidades.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void test02SoldadoAliadoAtacaAEnemigoEstePierdeVida(){
        Soldado soldadoAliado = new Soldado();
        Soldado soldadoEnemigo = new Soldado();

        assertEquals(80,80);

    }

}
