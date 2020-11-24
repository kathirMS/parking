package com.kathir.parking.database;

import com.kathir.parking.parkingClass.Info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOfInfo extends CrudRepository<Info,Integer> {
}
