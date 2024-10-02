package com.example.kudago.service;

import com.example.kudago.model.Location;
import com.example.kudago.repo.LocationRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepository;
    public Collection<Location> getAllLocations() {
        return locationRepository.getAllLocations().values();
    }
    public Location getLocationBySlug(String slug) {
        return locationRepository.getLocationBySlug(slug);
    }
    public void addLocation(Location location) {
        locationRepository.addLocation(location);
    }
    public void updateLocation(String slug, Location location) {
        locationRepository.updateLocation(slug, location);
    }
    public void deleteLocation(String slug) {
        locationRepository.deleteLocation(slug);
    }
}