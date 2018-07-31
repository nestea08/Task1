package com.company.model.entities;


import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a present containing multiple sweets
 * Is a wrapper class for <code>List</code> of sweets
 * Provide methods for adding, removing, sorting and getting
 * specified sweets
 */
public class Present {
    private List<Sweet> sweets;

    /**
     * Constructs a new present initializing a list
     */
    public Present() {
        sweets = new ArrayList<>();
    }


    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public void addAllSweets(Collection<? extends Sweet> sweets) {
        this.sweets.addAll(sweets);
    }

    public void removeSweet(Sweet sweet) {
        sweets.remove(sweet);
    }

    public void sortSweetsByCost() {
        sweets.sort(Comparator.comparingInt(Sweet::getCost));
    }

    public void sortSweetsByWeight() {
        sweets.sort(Comparator.comparingInt(Sweet::getWeight));
    }

    public void sortSweetsBySugar() {
        sweets.sort(Comparator.comparingInt(Sweet::getSugar));
    }

    public int getAllWeight() {
        return sweets.stream().mapToInt(Sweet::getWeight).sum();
    }

    public List<Sweet> getSweetsBySugar(int min, int max) {
        return sweets.stream().
                filter(sweet -> sweet.getSugar() > min && sweet.getSugar() < max).
                collect(Collectors.toList());
    }

    /**
     * Provides access to sweets field
     * Makes a copy of the list for needs of security.
     * Sweet's objects inside the list are not copied
     * @return a copy of the list
     */
    public List<Sweet> getSweets() {
        return new ArrayList<>(sweets);
    }

}
