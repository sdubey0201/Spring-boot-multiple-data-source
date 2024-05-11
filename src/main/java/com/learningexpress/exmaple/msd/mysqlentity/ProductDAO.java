package com.learningexpress.exmaple.msd.mysqlentity;

import com.learningexpress.exmaple.msd.mysqlentity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDAO extends CrudRepository<Product,Integer> {

}
