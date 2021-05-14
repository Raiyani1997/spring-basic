package net.lemniscate.snippy.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import net.lemniscate.snippy.country.model.Country;
import net.lemniscate.snippy.country.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    
    @Autowired
    private CountryService countryService;

    @GetMapping("/{pageNo}/{pageSize}")
    public Page<Country> getPaginatedCountries(@PathVariable int pageNo, @PathVariable int pageSize) {
        return countryService.findPaginated(pageNo, pageSize);
    }
}
