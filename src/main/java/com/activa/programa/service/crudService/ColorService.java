package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.ColorModel;
import com.activa.programa.repository.IColorRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorService {


    private final IColorRepository colorRepository;

    public List<ColorModel> getAllColors() {
        return colorRepository.findAll();
    }

    public ColorModel getColorById(Long id) {
        return colorRepository.findById(id).orElse(null);
    }

    public ColorModel createColor(ColorModel color) {
        return colorRepository.save(color);
    }

    public ColorModel updateColor(Long id, ColorModel colorDetails) {
        ColorModel color = colorRepository.findById(id).orElse(null);
        if (color == null) {
            return null;
        }
        // updating color details
        color.setColorReference(colorDetails.getColorReference());
        color.setColorDescription(colorDetails.getColorDescription());
        return colorRepository.save(color);
    }

    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}