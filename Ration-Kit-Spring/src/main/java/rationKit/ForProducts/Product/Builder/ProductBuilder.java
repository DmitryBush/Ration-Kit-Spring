package rationKit.ForProducts.Product.Builder;

import rationKit.ForProducts.Product.Original;
import rationKit.ForProducts.Product.Product;
import rationKit.ForProducts.Product.TypeProduct;

public interface ProductBuilder
{
    BuilderProductClass SetName(String name);
    BuilderProductClass SetOriginal(Original original);
    BuilderProductClass SetTypeProduct(TypeProduct typeProduct);
    BuilderProductClass SetProtein(float protein);
    BuilderProductClass SetFats(float fats);
    BuilderProductClass SetCarbohydrates(float carbohydrates);
    BuilderProductClass SetMaxGramm(float max_gramm);
    Product BuildProduct();
}
