package com.activa.programa.service.crudService;
import org.springframework.stereotype.Service;

import com.activa.programa.model.OrderModel;
import com.activa.programa.repository.IOrderRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    
    private final IOrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public OrderModel updateOrder(Long id, OrderModel orderDetails) {
        OrderModel order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return null;
        }
        order.setRequestCode(orderDetails.getRequestCode());
        order.setOrderNumber(orderDetails.getOrderNumber());
        order.setOrderAdvisor(orderDetails.getOrderAdvisor());
        order.setOrderApproved(orderDetails.getOrderApproved());
        order.setOrderProductionDate(orderDetails.getOrderProductionDate());
        order.setOrderArrivalDate(orderDetails.getOrderArrivalDate());

        return orderRepository.save(order);
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
