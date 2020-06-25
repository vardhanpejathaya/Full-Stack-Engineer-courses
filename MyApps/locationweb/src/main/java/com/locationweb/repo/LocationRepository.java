package com.locationweb.repo;

import com.locationweb.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
