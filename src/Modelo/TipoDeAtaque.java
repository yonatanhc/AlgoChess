package Modelo;

import org.jetbrains.annotations.Contract;

public abstract class TipoDeAtaque {

    protected int puntosDeAtaque;

    public TipoDeAtaque(int puntos){
        this.puntosDeAtaque=puntos;
    }

    public int devolverPuntosDeAtaque(){
        return this.puntosDeAtaque;
    }
}
