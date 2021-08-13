package com.xworkz.jdbc.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.jdbc.dto.WebseriesDTO;

public interface WebseriesDAO {
	int save(WebseriesDTO dto);
	int total();
int findMaxSeason();
int findMinSeason();
Collection<WebseriesDTO> findAllSortByNameDesc();
Collection<WebseriesDTO> findAll(Predicate<WebseriesDTO> predicate);
Collection<WebseriesDTO> findAll();
Optional<WebseriesDTO> findOne(Predicate<WebseriesDTO> predicate);

}