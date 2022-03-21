package com.metereologic.service.logicBusiness;

import com.metereologic.persistence.models.Location;
import com.metereologic.persistence.repository.ILocationRepository;
import com.metereologic.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ModelService<Location>
{
    @Autowired
    private ILocationRepository locationRepository;

    @Override
    public List<Location> listAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Location getById(Integer id) {
        return this.locationRepository.findById(id).get();
    }

    @Override
    public void save(Location location) {
        this.locationRepository.save(location);
    }

    @Override
    public void delete(Integer id) {
        this.locationRepository.deleteById(id);
    }
}
