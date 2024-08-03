package com.activa.programa.service.crudService;

import com.activa.programa.model.DetailModel;
import com.activa.programa.model.CustomerGroupModel;
import com.activa.programa.model.RefProductModel;
import com.activa.programa.model.ColorModel;
import com.activa.programa.model.OrderModel;
import com.activa.programa.repository.IDetailRepository;
import com.activa.programa.repository.ICustomerGroupRepository;
import com.activa.programa.repository.IRefProductRepository;
import com.activa.programa.repository.IColorRepository;
import com.activa.programa.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailService {

    @Autowired
    private IDetailRepository detailRepository;

    @Autowired
    private ICustomerGroupRepository customerGroupRepository;

    @Autowired
    private IRefProductRepository refProductRepository;

    @Autowired
    private IColorRepository colorRepository;

    @Autowired
    private IOrderRepository orderRepository;

    public DetailModel createDetail(DetailModel detail) {
        // Verificar que las entidades relacionadas existan
        validateReferences(detail);

        return detailRepository.save(detail);
    }

    public DetailModel updateDetail(Long id, DetailModel detailDetails) {
        Optional<DetailModel> detailOptional = detailRepository.findById(id);
        if (detailOptional.isPresent()) {
            DetailModel existingDetail = detailOptional.get();

            // Verificar que las entidades relacionadas existan
            validateReferences(detailDetails);

            existingDetail.setOpalDetail(detailDetails.getOpalDetail());
            existingDetail.setCombinedDetail(detailDetails.getCombinedDetail());
            existingDetail.setGarmentDetail(detailDetails.getGarmentDetail());
            existingDetail.setEmbroideryDetail(detailDetails.getEmbroideryDetail());
            existingDetail.setEmbroideryLocation(detailDetails.getEmbroideryLocation());
            existingDetail.setCustomerGroupModel(detailDetails.getCustomerGroupModel());
            existingDetail.setRefProductModel(detailDetails.getRefProductModel());
            existingDetail.setColorModel(detailDetails.getColorModel());
            existingDetail.setOrderModel(detailDetails.getOrderModel());

            return detailRepository.save(existingDetail);
        } else {
            throw new RuntimeException("Detail not found with id: " + id);
        }
    }

    public void deleteDetail(Long id) {
        detailRepository.deleteById(id);
    }

    public Optional<DetailModel> getDetailById(Long id) {
        return detailRepository.findById(id);
    }

    public List<DetailModel> getAllDetails() {
        return detailRepository.findAll();
    }

    private void validateReferences(DetailModel detail) {
        // Verificar que el CustomerGroupModel exista
        if (detail.getCustomerGroupModel() != null) {
            if (!customerGroupRepository.existsById(detail.getCustomerGroupModel().getId())) {
                throw new RuntimeException("CustomerGroupModel not found with id: " + detail.getCustomerGroupModel().getId());
            }
        }

        // Verificar que el RefProductModel exista
        if (detail.getRefProductModel() != null) {
            if (!refProductRepository.existsById(detail.getRefProductModel().getProductRefCode())) {
                throw new RuntimeException("RefProductModel not found with id: " + detail.getRefProductModel().getProductRefCode());
            }
        }

        // Verificar que el ColorModel exista
        if (detail.getColorModel() != null) {
            if (!colorRepository.existsById(detail.getColorModel().getColorCode())) {
                throw new RuntimeException("ColorModel not found with id: " + detail.getColorModel().getColorCode());
            }
        }

        // Verificar que el OrderModel exista
        if (detail.getOrderModel() != null) {
            if (!orderRepository.existsById(detail.getOrderModel().getId())) {
                throw new RuntimeException("OrderModel not found with id: " + detail.getOrderModel().getId());
            }
        }
    }
}
