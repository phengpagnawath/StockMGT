package com.dgb.model;

import java.util.List;

public interface ProductCrud {
    List<Product> read(int offset,int limit);
    Product write(Product product);
    int count();

}
