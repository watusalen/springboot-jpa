package com.matusalenalves.course.resources;

import com.matusalenalves.course.entities.OrderItem;
import com.matusalenalves.course.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemResources {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> list = orderItemService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(@PathVariable Long id){
        OrderItem orderItem = orderItemService.findById(id);
        return ResponseEntity.ok().body(orderItem);
    }
}