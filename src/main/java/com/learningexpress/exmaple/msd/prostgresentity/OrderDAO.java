package com.learningexpress.exmaple.msd.prostgresentity;

import com.learningexpress.exmaple.msd.prostgresentity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDAO extends CrudRepository<Order,Integer> {
}
