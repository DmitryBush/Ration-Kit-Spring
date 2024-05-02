package Database;

import ForProducts.Product.Product;

import java.util.List;

public interface IDirectory
{
    List<Product> getBasic_Products();
    List<Product> getGarnish_Products();
    List<Product> getAddition_Products();
}
