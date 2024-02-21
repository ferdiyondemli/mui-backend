package com.yalo.mui.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @GetMapping("/all")
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }
}

