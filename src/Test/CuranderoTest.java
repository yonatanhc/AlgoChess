package Test;

import Modelo.Curandero;
import Modelo.Soldado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuranderoTest {

    @Test
    void testComprobarPuntosDeVidaA100(){
        Curandero nuevoCurandero =new Curandero();
        assertEquals(nuevoCurandero.getPuntosDeSalud(),75);
    }

    @Test
    void testCosteDeCuranderoIgualA2() {
        Curandero nuevoCurandero = new Curandero();
        assertEquals(nuevoCurandero.getCosteDeUnidad(),2);
    }

    @Test
    void curarAUnaUnidadYVerificarSalud(){
        Curandero nuevoCurandero = new Curandero();
        Soldado soldadoACurar = new Soldado();
        nuevoCurandero.curarUnidad(soldadoACurar);
        assertEquals(soldadoACurar.getPuntosDeSalud(),115);
    }

    @Test
    void atacarAUnidadYQueNoRecibaDanio(){
        Curandero nuevoCurandero = new Curandero();
        Soldado soldadoAAtacar = new Soldado();
        nuevoCurandero.atacarUnidad(soldadoAAtacar);
        assertEquals(soldadoAAtacar.getPuntosDeSalud(),100);
    }

}