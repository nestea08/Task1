package com.company.controller.servlets;

import com.company.controller.DataValidator;
import com.company.controller.TextConstants;
import com.company.model.PresentInitializer;
import com.company.model.entities.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class PresentServlet extends HttpServlet {
    private Present present;

    private String index = "/WEB-INF/view/index.jsp";

    @Override
    public void init() {
        present = PresentInitializer.initialize();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(TextConstants.WEIGHT, present.getAllWeight());
        List<Sweet> sweets = present.getSweets();
        try {
            checkSortParameter(req);
            sweets = checkSugarParameters(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute(TextConstants.SWEETS, sweets);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    private void checkSortParameter(HttpServletRequest req) {
        Sorter sorter = new Sorter(present);
        String sort = req.getParameter(TextConstants.SORTING_TYPE) != null ? req.getParameter(TextConstants.SORTING_TYPE) : "";
        switch (sort) {
            case TextConstants.COST:
                sorter.sortByCost();
                break;
            case TextConstants.WEIGHT:
                sorter.sortByWeight();
                break;
            case TextConstants.SUGAR:
                sorter.sortBySugar();
                break;
            case "":
                break;
            default:
                throw new IllegalArgumentException("Nonexistent sorting type");
        }
    }

    private List<Sweet> checkSugarParameters(HttpServletRequest req) {
        Searcher searcher = new Searcher(present);
        String minSugarParam = req.getParameter(TextConstants.SUGAR_MINIMUM);
        String maxSugarParam = req.getParameter(TextConstants.SUGAR_MAXIMUM);
        if (Objects.isNull(minSugarParam) || Objects.isNull(maxSugarParam)) {
            return present.getSweets();
        }
        int minSugar = getNumberParameter(req, minSugarParam);
        int maxSugar = getNumberParameter(req, maxSugarParam);
        return searcher.search(minSugar, maxSugar);
    }

    private int getNumberParameter(HttpServletRequest req, String param) {
        if (DataValidator.isNotValid(param, DataValidator.NUMBER_REGEX)) {
            throw new IllegalArgumentException("Wrong input");
        }
        return Integer.parseInt(param);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(TextConstants.ENCODING);
        try {
            String type = req.getParameter(TextConstants.SWEET_TYPE) != null ? req.getParameter(TextConstants.SWEET_TYPE) : "";
            int cost = getNumberParameter(req, req.getParameter(TextConstants.COST));
            int weight = getNumberParameter(req, req.getParameter(TextConstants.WEIGHT));
            int sugar = getNumberParameter(req, req.getParameter(TextConstants.SUGAR));
            Sweet sweet = createSweet(type, cost, weight, sugar);
            present.addSweet(sweet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        doGet(req, resp);
    }

    private Sweet createSweet(String type, int cost, int weight, int sugar) {
        switch (type) {
            case TextConstants.CANDY:
                return new Candy(cost, weight, sugar, Candy.CandyType.JELLY);
            case TextConstants.CHOCOLATE:
                return new Chocolate(cost, weight, sugar, 70);
            case TextConstants.COOKIE:
                return new Cookie(cost, weight, sugar, Cookie.CookieType.CORN);
            default:
                throw new IllegalArgumentException("Nonexistent sweet type");
        }
    }

    public Present getPresent() {
        return present;
    }
}
