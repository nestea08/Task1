package com.company.model.entities;

import java.util.List;

public class Searcher {
    SugarSearcher sugarSearcher;

    public Searcher(SugarSearcher sugarSearcher) {
        this.sugarSearcher = sugarSearcher;
    }

    public List<Sweet> search(int min, int max) {
        return sugarSearcher.getSweetsBySugar(min, max);
    }
}
