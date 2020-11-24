package com.kathir.parking.service;

import com.kathir.parking.database.RepositoryOfParking;
import com.kathir.parking.database.RepositoryOfInfo;
import com.kathir.parking.parkingClass.Info;
import com.kathir.parking.parkingClass.Parking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingService {
    @Autowired
    private RepositoryOfParking repositoryOfParking;
    @Autowired
    private RepositoryOfInfo repositoryOfInfo;

    //get the value from parking database
    public List<Parking> getParkingList() {
         List<Parking> parkingList = new ArrayList<>();
         repositoryOfParking.findAll().forEach(parking ->parkingList.add(parking));
         return parkingList;
    }

    //post the value
    public Parking createPark(Parking new1){
        return  repositoryOfParking.save(new1);

    }

    //get the info value
    public List<Info> getInfo(){
        List<Info> infoArrayList = new ArrayList<>();
        repositoryOfInfo.findAll().forEach(info ->infoArrayList.add(info));
        return infoArrayList;
    }

   //post the info value
    public Info postInfo(Info value) {
        return repositoryOfInfo.save( value);
    }

    //delete the row from info database
    public String deleteRowInInfo(Integer id) {
        repositoryOfInfo.delete(id);
        return "successfully Deleted";
    }
}
