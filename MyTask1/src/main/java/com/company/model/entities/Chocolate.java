package com.company.model.entities;

/**
 * Represents a single chocolate
 * While being a subtype of a sweet adds a cacao field
 */
public class Chocolate extends Sweet {
    private int cacao;

    /**
     * Constructs a new chocolate
     * Invokes a parent's super constructor with cost, weight and
     * sugar values
     */
    public Chocolate(int cost, int weight, int sugar, int cacao) {
        super(cost, weight, sugar);
        this.cacao = cacao;
    }

    public int getCacao() {
        return cacao;
    }

    @Override
    public String toString() {
        return "Chocolate";
    }
}
