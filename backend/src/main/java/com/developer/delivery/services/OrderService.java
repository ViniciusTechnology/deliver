package com.developer.delivery.services;

import com.developer.delivery.dto.OrderDTO;
import com.developer.delivery.dto.ProductDTO;
import com.developer.delivery.entities.Order;
import com.developer.delivery.entities.Product;
import com.developer.delivery.repositories.OrderRepository;
import com.developer.delivery.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(x-> new OrderDTO(x)).collect(Collectors.toList());

    }
}
