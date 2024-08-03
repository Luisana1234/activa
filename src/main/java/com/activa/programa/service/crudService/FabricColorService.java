package com.activa.programa.service.crudService;
import com.activa.programa.model.FabricColorModel;
import com.activa.programa.model.FabricModel;
import com.activa.programa.model.ColorModel;
import com.activa.programa.repository.IFabricColorRepository;
import com.activa.programa.repository.IFabricRepository;
import com.activa.programa.repository.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FabricColorService {

    @Autowired
    private IFabricColorRepository fabricColorRepository;

    @Autowired
    private IFabricRepository fabricRepository;

    @Autowired
    private IColorRepository colorRepository;

    // Crear un nuevo registro de FabricColorModel
    public FabricColorModel createFabricColor(FabricColorModel fabricColor) {
        // Validar las referencias a las tablas padre
        validateReferences(fabricColor);
        return fabricColorRepository.save(fabricColor);
    }

    // Actualizar un registro existente de FabricColorModel
    public FabricColorModel updateFabricColor(Long id, FabricColorModel fabricColorDetails) {
        Optional<FabricColorModel> fabricColorOptional = fabricColorRepository.findById(id);
        if (fabricColorOptional.isPresent()) {
            FabricColorModel existingFabricColor = fabricColorOptional.get();

            // Validar las referencias a las tablas padre
            validateReferences(fabricColorDetails);

            existingFabricColor.setGarmentDescription(fabricColorDetails.getGarmentDescription());
            existingFabricColor.setGarmentNotes(fabricColorDetails.getGarmentNotes());
            existingFabricColor.setFabricModel(fabricColorDetails.getFabricModel());
            existingFabricColor.setColorModel(fabricColorDetails.getColorModel());

            return fabricColorRepository.save(existingFabricColor);
        } else {
            throw new RuntimeException("FabricColorModel not found with id: " + id);
        }
    }

    // Eliminar un registro de FabricColorModel
    public void deleteFabricColor(Long id) {
        fabricColorRepository.deleteById(id);
    }

    // Obtener un registro de FabricColorModel por ID
    public Optional<FabricColorModel> getFabricColorById(Long id) {
        return fabricColorRepository.findById(id);
    }

    // Obtener todos los registros de FabricColorModel
    public List<FabricColorModel> getAllFabricColors() {
        return fabricColorRepository.findAll();
    }

    // Validar que las referencias a las tablas padre existen
    private void validateReferences(FabricColorModel fabricColor) {
        if (fabricColor.getFabricModel() != null) {
            if (!fabricRepository.existsById(fabricColor.getFabricModel().getId())) {
                throw new RuntimeException("FabricModel not found with id: " + fabricColor.getFabricModel().getId());
            }
        }

        if (fabricColor.getColorModel() != null) {
            if (!colorRepository.existsById(fabricColor.getColorModel().getColorCode())) {
                throw new RuntimeException("ColorModel not found with id: " + fabricColor.getColorModel().getColorCode());
            }
        }
    }
}
