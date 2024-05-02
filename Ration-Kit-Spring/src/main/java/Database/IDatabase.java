package Database;

import ForProducts.Product.Product;

import java.util.List;

public interface IDatabase
{
    List<Product> GetData(String sql);
    int GetSize();
}
