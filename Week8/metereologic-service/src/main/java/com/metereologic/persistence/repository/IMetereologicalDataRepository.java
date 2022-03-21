package com.metereologic.persistence.repository;

import com.metereologic.persistence.models.MetereologicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMetereologicalDataRepository extends JpaRepository<MetereologicalData, Integer>
{

}
