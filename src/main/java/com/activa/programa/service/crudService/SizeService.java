package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.SizeModel;
import com.activa.programa.repository.ISizeRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeService {

    private final ISizeRepository sizeRepository;

    public List<SizeModel> getAllSizes() {
        return sizeRepository.findAll();
    }

    public SizeModel getSizeById(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }

    public SizeModel createSize(SizeModel size) {
        return sizeRepository.save(size);
    }

    public SizeModel updateSize(Long id, SizeModel sizeDetails) {
        SizeModel Size = sizeRepository.findById(id).orElse(null);
        if (Size == null) {
            return null;
        }
        Size.setSizeValue(sizeDetails.getSizeValue());
        Size.setSizeNotes(sizeDetails.getSizeNotes());
        Size.setSizeSpecifications(sizeDetails.getSizeSpecifications());
        return sizeRepository.save(Size);
    }
    public void deleteSize(Long id) {
        sizeRepository.deleteById(id);
    }
}
