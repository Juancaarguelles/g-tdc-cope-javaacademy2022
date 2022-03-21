package com.metereologic.persistence.repository;

import com.metereologic.persistence.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationRepository extends JpaRepository<Location, Integer> {
}
