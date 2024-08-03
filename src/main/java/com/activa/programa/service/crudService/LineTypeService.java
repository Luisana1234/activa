package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.LineTypeModel;
import com.activa.programa.repository.ILineTypeRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LineTypeService {
    
    private final ILineTypeRepository lineTypeRepository;

    public List<LineTypeModel> getAllLineTypes() {
        return lineTypeRepository.findAll();
    }

    public LineTypeModel getLineTypeById(Long id) {
        return lineTypeRepository.findById(id).orElse(null);
    }

    public LineTypeModel createLineType(LineTypeModel lineType) {
        return lineTypeRepository.save(lineType);
    }

    public LineTypeModel updateLineType(Long id, LineTypeModel lineTypeDetails) {
        LineTypeModel lineType = lineTypeRepository.findById(id).orElse(null);
        if (lineType == null) {
            return null;
        }
        lineType.setName(lineTypeDetails.getName());
        return lineTypeRepository.save(lineType);
    }

    public void deleteLineType(Long id) {
        lineTypeRepository.deleteById(id);
    }
}