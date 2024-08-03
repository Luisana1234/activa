package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.MeasureModel;
import com.activa.programa.repository.IMeasurementRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasureService {
    private final IMeasurementRepository measurementRepository;

    public List<MeasureModel> getAllMeasure() {
        return measurementRepository.findAll();
    }

    public MeasureModel getMeasureById(Long id) {
        return measurementRepository.findById(id).orElse(null);
    }

    public MeasureModel createMeasure(MeasureModel Measure) {
        return measurementRepository.save(Measure);
    }

    public MeasureModel updateMeasure(Long id, MeasureModel MeasureDetails) {
        MeasureModel Measure = measurementRepository.findById(id).orElse(null);
        if (Measure == null) {
            return null;
        }
        Measure.setMeasureSize(MeasureDetails.getMeasureSize());
        return measurementRepository.save(Measure);
        
    }
    public void deleteMeasure(Long id) {
        measurementRepository.deleteById(id);
    }
}
