package com.qa.thain.alex.garage.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.thain.alex.garage.app.model.GarageAppModel;

@Repository
public interface GarageAppRepository extends JpaRepository<GarageAppModel,Long> {

}
