package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.models.Order;
import backend.models.UpdateField;
import backend.services.OrderService;

@RestController
public class OrderController {
    @Autowired
    private OrderService orders;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orders.getAll();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orders.save(order);
        return order;
    }

    @DeleteMapping("/orders/{id}")
    public HttpStatus deleteOrder(@PathVariable long id) {
        orders.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/orders/{id}")
    public HttpStatus updateOrderStatus(@PathVariable long id, @RequestBody UpdateField updateField) {
        orders.updateStatusById(id, updateField.getValue());
        return HttpStatus.OK;
    }
}
