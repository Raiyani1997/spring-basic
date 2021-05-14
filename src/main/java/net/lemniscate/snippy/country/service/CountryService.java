package net.lemniscate.snippy.country.service;

import org.springframework.data.domain.Page;

import net.lemniscate.snippy.country.model.Country;

public interface CountryService {
    
    public Page<Country> findPaginated(int pageNo, int pageSize);
}
