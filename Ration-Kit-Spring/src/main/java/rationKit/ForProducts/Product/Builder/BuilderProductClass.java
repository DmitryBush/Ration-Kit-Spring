package rationKit.ForProducts.Product.Builder;

import rationKit.ForProducts.Product.Original;
import rationKit.ForProducts.Product.Product;
import rationKit.ForProducts.Product.TypeProduct;

public class BuilderProductClass implements ProductBuilder
{
    private Product _product = new Product();
    @Override
    public BuilderProductClass SetName(String name)
    {
        _product.setName(name);
        return this;
    }

    @Override
    public BuilderProductClass SetOriginal(Original original)
    {
        _product.setOriginal(original);
        return this;
    }

    @Override
    public BuilderProductClass SetTypeProduct(TypeProduct typeProduct)
    {
        _product.setType_product(typeProduct);
        return this;
    }

    @Override
    public BuilderProductClass SetProtein(float protein)
    {
        _product.setProtein(protein);
        return this;
    }

    @Override
    public BuilderProductClass SetFats(float fats)
    {
        _product.setFats(fats);
        return this;
    }

    @Override
    public BuilderProductClass SetCarbohydrates(float carbohydrates)
    {
        _product.setCarbohydrates(carbohydrates);
        return this;
    }

    @Override
    public BuilderProductClass SetMaxGramm(float max_gramm)
    {
        _product.setMax_gramm(max_gramm);
        return this;
    }

    @Override
    public Product BuildProduct()
    {
        _product.setKilocalories();
        return _product;
    }
}
