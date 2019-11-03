package Test;

import Modelo.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldadoTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Soldado nuevoSoldado =new Soldado();
        assertEquals(nuevoSoldado.getPuntosDeSalud(),100);
    }

    @Test
    void testCosteDeSoldadoIgualA1() {
        Soldado nuevoSoldado = new Soldado();
        assertEquals(nuevoSoldado.getCosteDeUnidad(),1);
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Soldado nuevoSoldado = new Soldado();
        Soldado soldadoAAtacar = new Soldado();
        nuevoSoldado.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeSalud(),90);
    }
}