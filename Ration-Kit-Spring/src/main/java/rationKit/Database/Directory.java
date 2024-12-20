package rationKit.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import rationKit.ForProducts.Product.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DirectoryBean")
@Scope("singleton")
public class Directory implements IDirectory
{
    private final List<Product> basicProducts;
    private final List<Product> garnishProducts;
    private final List<Product> additionProducts;

    public Directory(@Autowired IDatabase db,
                     @Value("${ration-kit.sql.basicProducts}") String basicProduct,
                     @Value("${ration-kit.sql.garnishProducts}") String garnishProduct,
                     @Value("${ration-kit.sql.additionProducts}") String additionProduct)
    {
        basicProducts = new ArrayList<>(db.GetData(basicProduct));
        garnishProducts = new ArrayList<>(db.GetData(garnishProduct));
        additionProducts = new ArrayList<>(db.GetData(additionProduct));
    }

    public List<Product> getBasicProducts() {
        return basicProducts;
    }

    public List<Product> getGarnishProducts() {
        return garnishProducts;
    }

    public List<Product> getAdditionProducts() {
        return additionProducts;
    }
}
