package model;

public class TipoDeDanio {
    private int danioCuerpoAcuerpo;
    private int danioADistancia;

    public TipoDeDanio(int danioCuerpoACuerpo, int danioADistancia) {
        this.danioCuerpoAcuerpo = danioCuerpoACuerpo;
        this.danioADistancia = danioADistancia;
    }

    public void realizarDanioCuerpoACuerpo(Casillero origenDelAtaque,int distanciaDelAtaque) {
        //buscar los casilleros validos adyacentes a origenDelAtaque en distanciaDelAtaque
        //y acada casillero , preguntar si esta ocupado y q no pertenezcan  al jugador
        //si cumplen esas condiciones:
        //unidad.recibirDaño(dañoCuerpoACuerpo);
    }

    public void realizarDanioADistancia(Casillero origenDelAtaque,int distanciaDelAtaque) {
        //buscar los casilleros validos adyacentes a origenDelAtaque en distanciaDelAtaque
        //y acada casillero , preguntar si esta ocupado y q no pertenezcan  al jugador
        //si cumplen esas condiciones:
        //unidad.recibirDaño(dañoCuerpoACuerpo);
    }
}
