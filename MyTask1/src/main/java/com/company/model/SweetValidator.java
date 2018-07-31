package com.company.model;

import com.company.model.entities.Sweet;

/**
 * A simple validator for sweet objects
 * Enforces noninstantiability
 */
public class SweetValidator {
    private static final int minCost = 1;
    private static final int maxCost = 200;

    private static final int minWeight = 1;
    private static final int maxWeight = 100;

    private static final int minSugar = 0;
    private static final int maxSugar = 100;

    private SweetValidator() {}

    /**
     * Checks whether a sweet object is valid
     * @return <code>true</code> if cost, weight and
     * sugar values are valid
     *         <code>false</code> otherwise
     */
    public static boolean isValidSweet(Sweet sweet) {
        return isValidCost(sweet.getCost()) &&
                isValidWeight(sweet.getWeight()) &&
                isValidSugar(sweet.getSugar());
    }

    private static boolean isValidCost(int cost) {
        return cost > minCost && cost < maxCost;
    }

    private static boolean isValidWeight(int weight) {
        return weight > minWeight && weight < maxWeight;
    }

    private static boolean isValidSugar(int sugar) {
        return sugar > minSugar && sugar < maxSugar;
    }
}
