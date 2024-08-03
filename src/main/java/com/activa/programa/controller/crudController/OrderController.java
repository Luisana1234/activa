package com.activa.programa.controller.crudController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.activa.programa.model.OrderModel;
import com.activa.programa.service.crudService.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/addOrder")
    public String showaaddOrders() {
        return "admin/addFormulary/addOrders";
    }

    @GetMapping()
    public String getAllOrders(Model model) {
        List<OrderModel> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/Orders";}


        @GetMapping("/{id}")
        public ResponseEntity<OrderModel> getOrderById (@PathVariable("id") Long id){
            OrderModel order = orderService.getOrderById(id);
            if (order == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(order, HttpStatus.OK);
        }

        @PostMapping("/create")
        public ResponseEntity<OrderModel> createOrder (@RequestBody OrderModel order){
            OrderModel createdOrder = orderService.createOrder(order);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<OrderModel> updateOrder (@PathVariable("id") Long id, @RequestBody OrderModel order){
            OrderModel updatedOrder = orderService.updateOrder(id, order);
            if (updatedOrder == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteOrder (@PathVariable("id") Long id){
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


