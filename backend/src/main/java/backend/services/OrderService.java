package backend.services;

import java.util.List;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.models.Order;
import backend.repos.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orders;

    @Transactional(readOnly = true)
    public List<Order> getAll() {
        return orders.findAll();
    }

    @Transactional
    public void save(Order order) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        order.setCreationDate(timeStamp);
        order.setStatus("accepted");
        orders.save(order);
    }

    @Transactional
    public void deleteById(long id) {
        orders.deleteById(id);
    }

    @Transactional
    public void updateStatusById(long id, String status) {
        var order = orders.findById(id).get();
        order.setStatus(status);
        orders.save(order);
    }
}
