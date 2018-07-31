package com.company.model.entities;

import com.company.model.SweetValidator;

import java.util.Objects;

/**
 * Represents a single abstracted sweet
 */
public abstract class Sweet {
    private int cost;
    private int weight;
    private int sugar;

    /**
     * Constructs a new sweet with specified cost, weight and sugar
     * Uses SweetValidator to check values validity
     * @throws IllegalArgumentException if values are not valid
     */
    Sweet(int cost, int weight, int sugar) throws IllegalArgumentException{
        this.cost = cost;
        this.weight = weight;
        this.sugar = sugar;
        if (SweetValidator.isValidSweet(this) == false) {
            throw new IllegalArgumentException("Sweet is not valid");
        }
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    public int getSugar() {
        return sugar;
    }

    /**
     * Compares two objects for equality
     * Overriding it in child classes may lead to violating equals contract
     * @return <code>true</code> if the objects are the same;
     *         <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sweet)) {
            return false;
        }
        Sweet sweet = (Sweet) obj;
        return sweet.cost == cost && sweet.sugar == sugar && sweet.weight == weight;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(cost);
        result = 31 * result + Integer.hashCode(weight);
        result = 31 * result + Integer.hashCode(sugar);
        return result;
    }
}
