package com.company.model.entities;

public class Sorter {
    private PresentSorter presentSorter;

    public Sorter(PresentSorter presentSorter) {
        this.presentSorter = presentSorter;
    }

    public void sortByCost() {
        presentSorter.sortSweetsByCost();
    }

    public void sortByWeight() {
        presentSorter.sortSweetsByWeight();
    }

    public void sortBySugar() {
        presentSorter.sortSweetsBySugar();
    }
}
