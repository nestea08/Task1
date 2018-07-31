package com.company.model.entities;

/**
 * Represents a single candy
 * While being a subtype of a sweet adds a candy type field
 */
public class Candy extends Sweet {
    private CandyType type;

    /**
     * Describes types that the candy assumes
     */
    public enum CandyType {
        MILKY, JELLY, CARAMEL
    }

    /**
     * Constructs a new candy
     * Invokes a parent's super constructor with cost, weight and
     * sugar values
     */
    public Candy(int cost, int weight, int sugar, CandyType type) {
        super(cost, weight, sugar);
        this.type = type;
    }

    public CandyType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Candy";
    }
}
