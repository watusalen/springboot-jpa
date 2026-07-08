package com.matusalenalves.course.services;

import com.matusalenalves.course.entities.OrderItem;
import com.matusalenalves.course.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    public OrderItem findById(Long id){
        Optional<OrderItem> orderItem = orderItemRepository.findById(id);
        return orderItem.isPresent() ? orderItem.get() : null;
    }
}