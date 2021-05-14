package net.lemniscate.snippy.country.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.lemniscate.snippy.country.model.Country;
import net.lemniscate.snippy.country.repository.CountryRepository;
import net.lemniscate.snippy.country.service.CountryService;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Page<Country> findPaginated(int pageNo, int pageSize) {
        PageRequest page = PageRequest.of(pageNo, pageSize, Sort.by(Order.asc("population")));
        Page<Country> findAll = countryRepository.findAll(page);
        // findAll.toList()
        return findAll;
    }
    
}
