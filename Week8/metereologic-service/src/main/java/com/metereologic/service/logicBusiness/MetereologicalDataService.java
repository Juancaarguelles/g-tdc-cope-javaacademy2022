package com.metereologic.service.logicBusiness;

import com.metereologic.persistence.models.MetereologicalData;
import com.metereologic.persistence.repository.IMetereologicalDataRepository;
import com.metereologic.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetereologicalDataService implements ModelService<MetereologicalData>
{
    @Autowired
    private IMetereologicalDataRepository metereologicalDataRepository;

    @Override
    public List<MetereologicalData> listAll() {
        return this.metereologicalDataRepository.findAll();
    }

    @Override
    public MetereologicalData getById(Integer id) {
        return this.metereologicalDataRepository.findById(id).get();
    }

    @Override
    public void save(MetereologicalData metereologicalData)
    {
        this.metereologicalDataRepository.save(metereologicalData);
    }

    @Override
    public void delete(Integer id) {
        this.metereologicalDataRepository.deleteById(id);
    }
}
