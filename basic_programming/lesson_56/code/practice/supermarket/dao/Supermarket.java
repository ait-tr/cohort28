package practice.supermarket.dao;

import model.Product;

public interface Supermarket {

    boolean addProduct (Product product);
    Product removeProduct(Long barCode);
    Product findByBarCode(Long barCode);
    Iterable<Product> findByCategory (String category);
    Iterable<Product> findByBrand (String brand);
    Iterable<Product> findProductsWithExpireDate();
    int skuQuantity(); //  для складского учета
    // SKU (аббр. англ. stock keeping unit «единица складского учёта»)

}
