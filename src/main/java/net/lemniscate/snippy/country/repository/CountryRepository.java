package net.lemniscate.snippy.country.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import net.lemniscate.snippy.country.model.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer>{
    
}
