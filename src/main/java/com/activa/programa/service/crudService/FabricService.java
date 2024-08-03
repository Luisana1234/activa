package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.FabricModel;
import com.activa.programa.repository.IFabricRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FabricService {

    private final IFabricRepository fabricRepository;

    public List<FabricModel> getAllFabric() {
        return fabricRepository.findAll();
    }

    public FabricModel getFabricById(Long id) {
        return fabricRepository.findById(id).orElse(null);
    }

    public FabricModel createFabric(FabricModel fabric) {
        return fabricRepository.save(fabric);
    }

    public FabricModel updateFabric(Long id, FabricModel fabricDetails) {
        FabricModel fabric = fabricRepository.findById(id).orElse(null);
        if (fabric == null) {
            return null;
        }
        fabric.setFabricType(fabricDetails.getFabricType());
        fabric.setFabricComposition(fabricDetails.getFabricComposition());
        fabric.setFabricNotes(fabricDetails.getFabricNotes());
        return fabricRepository.save(fabric);
    }

    public void deleteFabric(Long id) {
        fabricRepository.deleteById(id);
    }
}
