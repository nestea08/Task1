package com.company.model.entities;

import java.util.List;

public interface SugarSearcher {
    List<Sweet> getSweetsBySugar(int minSugar, int maxSugar);
}
