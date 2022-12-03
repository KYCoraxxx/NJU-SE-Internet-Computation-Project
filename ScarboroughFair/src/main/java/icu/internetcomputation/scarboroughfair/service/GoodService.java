package icu.internetcomputation.scarboroughfair.service;

import org.springframework.beans.factory.annotation.Autowired;

import icu.internetcomputation.scarboroughfair.GoodRepository;
import icu.internetcomputation.scarboroughfair.entity.Good;

public class GoodService {
    @Autowired
    GoodRepository goodRepository;

    public GoodService(GoodRepository Repo)
    {
        this.goodRepository = Repo;
    }
}
