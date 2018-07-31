package com.company.tests;

import com.company.model.entities.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PresentTest {
    private Present present;

    @Before
    public void setUp() {
        present = new Present();
    }

    @Test
    public void testAddSweet() {
        Sweet sweet = new Candy(50, 50, 50,null);
        boolean contains = present.getSweets().contains(sweet);
        present.addSweet(sweet);
        boolean new_contains = present.getSweets().contains(sweet);
        assertNotEquals(contains, new_contains);
    }

    @Test
    public void testRemoveSweet() {
        Sweet sweet = new Candy(50, 50, 50,null);
        present.addSweet(sweet);
        boolean contains = present.getSweets().contains(sweet);
        present.removeSweet(sweet);
        boolean new_contains = present.getSweets().contains(sweet);
        assertNotEquals(contains, new_contains);
    }

    @Test
    public void testSortSweetsByCost() {
        List<Sweet> sweets = initializeSweets();
        present.addAllSweets(sweets);
        ArrayList<Sweet> newSweets = new ArrayList<>();
        newSweets.add(sweets.get(1));
        newSweets.add(sweets.get(0));
        newSweets.add(sweets.get(2));
        present.sortSweetsByCost();
        assertEquals(newSweets, present.getSweets());
    }

    @Test
    public void testSortSweetsByWeight() {
        List<Sweet> sweets = initializeSweets();
        present.addAllSweets(sweets);
        ArrayList<Sweet> newSweets = new ArrayList<>();
        newSweets.add(sweets.get(0));
        newSweets.add(sweets.get(2));
        newSweets.add(sweets.get(1));
        present.sortSweetsByWeight();
        assertEquals(newSweets, present.getSweets());
    }

    @Test
    public void testSortSweetsBySugar() {
        List<Sweet> sweets = initializeSweets();
        present.addAllSweets(sweets);
        ArrayList<Sweet> newSweets = new ArrayList<>();
        newSweets.add(sweets.get(2));
        newSweets.add(sweets.get(1));
        newSweets.add(sweets.get(0));
        present.sortSweetsBySugar();
        assertEquals(newSweets, present.getSweets());
    }

    @Test
    public void testFindSweetsBySugar() {
        List<Sweet> sweets = initializeSweets();
        present.addAllSweets(sweets);
        int lowSugar = 15;
        int maxSugar = 25;
        ArrayList<Sweet> newSweets = new ArrayList<>();
        newSweets.add(sweets.get(1));
        assertEquals(newSweets, present.getSweetsBySugar(lowSugar, maxSugar));
    }

    private List<Sweet> initializeSweets() {
        return new ArrayList<>(Arrays.asList(
                new Candy(50, 10, 50,null),
                new Chocolate(25, 30, 20,0),
                new Cookie(70, 20, 10,null)));
    }


}