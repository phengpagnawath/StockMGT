package com.dgb.model;

import java.util.List;

public interface ProductCrud {
    List<Product> read();
    Product write(Product product);

}
