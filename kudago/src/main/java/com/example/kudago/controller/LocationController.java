package com.example.kudago.controller;

import com.example.kudago.model.Location;
import com.example.kudago.service.LocationService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public Collection<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{slug}")
    public Location getLocationBySlug(@PathVariable String slug) {
        return locationService.getLocationBySlug(slug);
    }

    @PostMapping
    public void createLocation(@RequestBody Location location) {
        locationService.addLocation(location);
    }

    @PutMapping("/{slug}")
    public void updateLocation(@PathVariable String slug, @RequestBody Location location) {
        locationService.updateLocation(slug, location);
    }

    @DeleteMapping("/{slug}")
    public void deleteLocation(@PathVariable String slug) {
        locationService.deleteLocation(slug);
    }
}