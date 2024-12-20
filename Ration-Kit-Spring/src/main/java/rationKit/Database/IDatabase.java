package rationKit.Database;

import rationKit.ForProducts.Product.Product;

import java.util.List;

public interface IDatabase
{
    List<Product> GetData(String sql);
}
