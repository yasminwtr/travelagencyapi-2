package com.api.travelagency.repository;

import com.api.travelagency.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByNameOrLocation(String name, String location);
}
