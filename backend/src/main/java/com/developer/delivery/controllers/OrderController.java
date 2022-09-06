package com.developer.delivery.controllers;

import com.developer.delivery.dto.OrderDTO;
import com.developer.delivery.dto.ProductDTO;
import com.developer.delivery.services.OrderService;
import com.developer.delivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){
        List<OrderDTO> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto){
        dto = orderService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping("/{id}/delivered")
    public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
        OrderDTO dto = orderService.setDelivered(id);
        return ResponseEntity.ok().body(dto);
    }
}
