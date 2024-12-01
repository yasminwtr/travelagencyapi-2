package com.api.travelagency.service;

import com.api.travelagency.model.Destination;
import com.api.travelagency.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinationService {
    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public Destination addDestination(Destination destination) {
        return destinationRepository.save(destination);
    }
    
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public List<Destination> searchDestinations(String name, String location) {
        return destinationRepository.findByNameOrLocation(
                name == null ? "" : name,
                location == null ? "" : location
        );
    }

    public Optional<Destination> getDestinationById(Long id) {
        return destinationRepository.findById(id);
    }

    public Optional<Destination> addRatingToDestination(Long id, int rating) {
        return destinationRepository.findById(id).map(destination -> {
            destination.addRating(rating);
            destinationRepository.save(destination);
            return destination;
        });
    }

    public boolean deleteDestination(Long id) {
        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
