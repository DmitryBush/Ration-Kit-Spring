package Database;

import ForProducts.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DirectoryBean")
public class Directory implements IDirectory
{
    private final List<Product> Basic_Products;
    private final List<Product> Garnish_Products;
    private final List<Product> Addition_Products;

    @Autowired
    public Directory(IDatabase db)
    {
        Basic_Products = new ArrayList<>(db.GetData("select * from products where basic = true"));
        Garnish_Products = new ArrayList<>(db.GetData("select * from products where garnish = true"));
        Addition_Products = new ArrayList<>(db.GetData("select * from products where adition = true"));
    }

    public List<Product> getBasic_Products() {
        return Basic_Products;
    }

    public List<Product> getGarnish_Products() {
        return Garnish_Products;
    }

    public List<Product> getAddition_Products() {
        return Addition_Products;
    }
}
