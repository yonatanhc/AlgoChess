package Test;

import Modelo.Catapulta;
import Modelo.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatapultaTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Catapulta nuevaCatapulta =new Catapulta();
        assertEquals(nuevaCatapulta.getPuntosDeSalud(),50);
    }

    @Test
    void testCosteDeLaCatapultaIgualA5() {
        Catapulta nuevaCatapulta = new Catapulta();
        assertEquals(nuevaCatapulta.getCosteDeUnidad(),5);
    }

    @Test
    void atacarAUnaUnidadYVerificarDanio(){
        Catapulta nuevoSoldado = new Catapulta();
        Soldado soldadoAAtacar = new Soldado();
        nuevoSoldado.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeSalud(),80);
    }

}