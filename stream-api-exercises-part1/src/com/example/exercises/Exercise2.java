package com.example.exercises;

import java.util.stream.Collectors;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.Country;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		var countryCountsByContinent =
		countryDao.findAllCountries()
		          .stream()
		          .collect(Collectors.groupingBy(Country::getContinent,Collectors.mapping(country -> Long.valueOf(country.getPopulation()),Collectors.reducing(0L, Long::sum))));
		System.out.println(countryCountsByContinent);
	}

}