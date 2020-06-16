package com.dgb.model;

import java.util.List;

public interface ProductCrud {
    List<Product> read(int offset,int limit);
    Product create(Product product);
    int count();
    int maxID();
    Product update(Product product);
    List<Product> searchByName(String search);
    int countBySearch(String search);

}
