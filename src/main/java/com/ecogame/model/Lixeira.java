package com.ecogame.model;

public class Lixeira {

    private final TipoLixo tipoAceito;
    private final int x;
    private final int largura = 150;
    private final int altura = 70;

    public Lixeira(TipoLixo tipoAceito, int x) {
        this.tipoAceito = tipoAceito;
        this.x = x;
    }

    public boolean aceita(ItemLixo item) {
        return item.getTipo() == this.tipoAceito;
    }

    public TipoLixo getTipoAceito() {
        return tipoAceito;
    }

    public int getX() {
        return x;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}
