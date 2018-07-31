package com.company.model.entities;

/**
 * Represents a single cookie
 * While being a subtype of a sweet adds a cookie type field
 */
public class Cookie extends Sweet {
    private CookieType type;

    /**
     * Describes types that the cookie assumes
     */
    public enum CookieType {
        OAT, CORN, SHORTBREAD
    }

    /**
     * Constructs a new cookie
     * Invokes a parent's super constructor with cost, weight and
     * sugar values
     */
    public Cookie(int cost, int weight, int sugar, CookieType type) {
        super(cost, weight, sugar);
        this.type =type;
    }

    public CookieType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cookie";
    }
}
