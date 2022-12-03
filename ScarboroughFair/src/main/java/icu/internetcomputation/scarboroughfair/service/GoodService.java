package icu.internetcomputation.scarboroughfair.service;

import icu.internetcomputation.scarboroughfair.GoodRepository;
import icu.internetcomputation.scarboroughfair.entity.Good;

public class GoodService {
    GoodRepository goodRepository;

    public GoodService(GoodRepository Repo)
    {
        this.goodRepository = Repo;
    }
}
