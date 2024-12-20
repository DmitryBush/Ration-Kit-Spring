package rationKit.Database;

import rationKit.ForProducts.Product.Product;

import java.util.List;

public interface IDirectory
{
    List<Product> getBasicProducts();
    List<Product> getGarnishProducts();
    List<Product> getAdditionProducts();
}
