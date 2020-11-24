package com.kathir.parking.database;
import com.kathir.parking.parkingClass.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryOfParking extends CrudRepository<Parking,Integer>{

}
