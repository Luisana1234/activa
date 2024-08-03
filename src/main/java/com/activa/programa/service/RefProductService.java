package com.activa.programa.service;

import com.activa.programa.model.RefProductModel;
import com.activa.programa.model.ProductModel;
import com.activa.programa.model.LineTypeModel;
import com.activa.programa.model.MeasureModel;
import com.activa.programa.model.SizeModel;
import com.activa.programa.repository.*;
import com.activa.programa.repository.IMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefProductService {

    @Autowired
    private IRefProductRepository refProductRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ILineTypeRepository lineTypeRepository;

    @Autowired
    private IMeasurementRepository measurementRepository;

    @Autowired
    private ISizeRepository sizeRepository;

    // Crear un nuevo registro de RefProductModel
    public RefProductModel createRefProduct(RefProductModel refProduct) {
        // Validar las referencias a las tablas padre
        validateReferences(refProduct);
        return refProductRepository.save(refProduct);
    }

    // Actualizar un registro existente de RefProductModel
    public RefProductModel updateRefProduct(Long id, RefProductModel refProductDetails) {
        Optional<RefProductModel> refProductOptional = refProductRepository.findById(id);
        if (refProductOptional.isPresent()) {
            RefProductModel existingRefProduct = refProductOptional.get();

            // Validar las referencias a las tablas padre
            validateReferences(refProductDetails);

            existingRefProduct.setProductModel(refProductDetails.getProductModel());
            existingRefProduct.setLineTypeModel(refProductDetails.getLineTypeModel());
            existingRefProduct.setMeasureModel(refProductDetails.getMeasureModel());
            existingRefProduct.setSizeModel(refProductDetails.getSizeModel());
            existingRefProduct.setDescription(refProductDetails.getDescription());
            existingRefProduct.setPhoto(refProductDetails.getPhoto());

            return refProductRepository.save(existingRefProduct);
        } else {
            throw new RuntimeException("RefProductModel not found with id: " + id);
        }
    }

    // Eliminar un registro de RefProductModel
    public void deleteRefProduct(Long id) {
        refProductRepository.deleteById(id);
    }

    // Obtener un registro de RefProductModel por ID
    public RefProductModel getRefProductById(Long id) {
        Optional<RefProductModel> refProduct = refProductRepository.findById(id);
        return refProduct.orElse(null);
    }

    // Obtener todos los registros de RefProductModel
    public List<RefProductModel> getAllRefProducts() {
        return refProductRepository.findAll();
    }

    // Validar que las referencias a las tablas padre existen
    private void validateReferences(RefProductModel refProduct) {
        if (refProduct.getProductModel() != null) {
            if (!productRepository.existsById(refProduct.getProductModel().getId())) {
                throw new RuntimeException("ProductModel not found with id: " + refProduct.getProductModel().getId());
            }
        }

        if (refProduct.getLineTypeModel() != null) {
            if (!lineTypeRepository.existsById(refProduct.getLineTypeModel().getId())) {
                throw new RuntimeException("LineTypeModel not found with id: " + refProduct.getLineTypeModel().getId());
            }
        }

        if (refProduct.getMeasureModel() != null) {
            if (!measurementRepository.existsById(refProduct.getMeasureModel().getId())) {
                throw new RuntimeException("MeasureModel not found with id: " + refProduct.getMeasureModel().getId());
            }
        }
        if (refProduct.getSizeModel() != null) {
            if (!sizeRepository.existsById(refProduct.getSizeModel().getSizeCode())) {
                throw new RuntimeException("SizeModel not found with id: " + refProduct.getSizeModel().getSizeCode());
            }
        }
    }
}
