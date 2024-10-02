package com.example.kudago.repo;

import com.example.kudago.model.Location;
import org.springframework.stereotype.Repository;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LocationRepo {
    private ConcurrentHashMap<String, Location> locationStore = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Location> getAllLocations() {
        return locationStore;
    }
    public Location getLocationBySlug(String slug) {
        return locationStore.get(slug);
    }
    public void addLocation(Location location) {
        locationStore.put(location.getSlug(), location);
    }
    public void updateLocation(String slug, Location location) {
        locationStore.put(slug, location);
    }
    public void deleteLocation(String slug) {
        locationStore.remove(slug);
    }
}