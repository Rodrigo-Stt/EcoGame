package com.ecogame.model;


public class ItemLixo {

    private double x;
    private double y;
    private final double velocidade;
    private final TipoLixo tipo;
    private final int tamanho = 34;

    public ItemLixo(double x, double y, double velocidade, TipoLixo tipo) {
        this.x = x;
        this.y = y;
        this.velocidade = velocidade;
        this.tipo = tipo;
    }

    public void cair() {
        this.y += velocidade;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public TipoLixo getTipo() {
        return tipo;
    }

    public int getTamanho() {
        return tamanho;
    }
}
