package com.company.model;

import com.company.model.entities.Candy;
import com.company.model.entities.Chocolate;
import com.company.model.entities.Cookie;
import com.company.model.entities.Present;

import java.util.Arrays;

/**
 * A static initializer for a <code>Present</code> objects
 * Enforces noninstantiability
 */
public class PresentInitializer {
    private PresentInitializer() {}

    /**
     * Creates a new <code>Present</code> initializing it
     * with three sweet objects
     * @return a <code>Present</code> object
     */
    public static Present initialize() {
        Present present = new Present();
        present.addAllSweets(Arrays.asList(
                new Candy(40, 30, 30, Candy.CandyType.CARAMEL),
                new Chocolate(100, 80, 10, 60),
                new Cookie(25, 50, 15, Cookie.CookieType.CORN)));
        return present;
    }
}
