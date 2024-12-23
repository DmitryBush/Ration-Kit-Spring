package rationKit.ForProducts.Meal;

import rationKit.Database.IDirectory;
import rationKit.ForProducts.Meal.Visitor.MealVisitor;
import rationKit.ForProducts.Product.Product;
import rationKit.ForProducts.Product.TypeProduct;
import rationKit.ForProducts.Product.TypeOfDiet;
import rationKit.Human.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public abstract class One_Meal implements Iterable<Product>
{
    protected AnnotationConfigApplicationContext context;
    @Autowired
    private IDirectory directory;
    @Autowired
    protected Human person;
    private float kilocalories, protein, fats, carbohydrates;
    private float max_protein, max_fats, max_carbohydrates, max_kilocalories;
    protected List<Product> products = new ArrayList<>();

    public abstract One_Meal Create_Meal(List<One_Meal> meals_in_day, MealVisitor mealVisitor);

    protected void CreatePlan(List<One_Meal> meals_in_day)
    {
        AddProduct(Check_On_New_Product(directory.getGarnishProducts(),  meals_in_day));
        AddProduct(Check_On_New_Product(directory.getBasicProducts(),  meals_in_day));
        AddProduct(Check_On_New_Product(directory.getAdditionProducts(), meals_in_day));
        Balance_Products_In_Meal();
        Calculate_PFC();
    }

    void Calculate_PFC(){
        protein =0;
        fats=0;
        carbohydrates=0;

        for (int i=0; i<products.size(); i++){
            protein += products.get(i).getProtein() /100  * products.get(i).getCur_count_gramm();
            fats +=  products.get(i).getFats() /100 * products.get(i).getCur_count_gramm();
            carbohydrates +=  products.get(i).getCarbohydrates() /100 * products.get(i).getCur_count_gramm();
        }

        kilocalories = protein*4 + carbohydrates*4+ fats*4;
    }

    void Balance_Products_In_Meal(){
        Random rand  = new Random();
        float product_gramm = 0;
        protein =0;
        fats=0;
        carbohydrates=0;
        kilocalories =0;

        if(!Check_on_Special_Diet(person.getTypeDiet())){
            for (int i=0; i<products.size();i++){
                if (products.get(i).getType_product() == TypeProduct.Garnish){
                    product_gramm =(rand.nextFloat(max_carbohydrates*0.7f,
                            max_carbohydrates*0.8f)/(products.get(i).getCarbohydrates() /100));
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }
                else if (products.get(i).getType_product() == TypeProduct.Basic){
                    product_gramm = (max_protein - protein) / (products.get(i).getProtein() /100);
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }
                else if (products.get(i).getType_product() == TypeProduct.Addition){
                    product_gramm = (max_kilocalories-kilocalories) /
                            ((products.get(2).getProtein() *4 /100)
                                    + (products.get(i).getCarbohydrates() *4 /100)
                                    + (products.get(i).getFats() *9 /100));
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }
            }
        }
        else {
            for (int i=0; i<products.size();i++){
                if (products.get(i).getType_product() == TypeProduct.Basic){
                    product_gramm =(rand.nextFloat(max_protein*0.9f,
                            max_protein*0.95f)/(products.get(i).getProtein() /100));
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }

                else if (products.get(i).getType_product() == TypeProduct.Garnish){
                    product_gramm =(rand.nextFloat(max_carbohydrates*0.7f, max_carbohydrates*0.8f)
                            /(products.get(i).getCarbohydrates() /100));
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }

                else if (products.get(i).getType_product() == TypeProduct.Addition){
                    product_gramm = (max_kilocalories-kilocalories) / ((products.get(2).getProtein() *4 /100)
                            + (products.get(i).getCarbohydrates() *4 /100) + (products.get(i).getFats() *9 /100));
                    if(product_gramm > products.get(i).getMax_gramm()){
                        product_gramm = products.get(i).getMax_gramm();
                    }
                    products.get(i).setCur_count_gramm(product_gramm);
                    Calculate_PFC();
                }
            }
        }
    }
    public void AddProduct(Product product)
    {
        products.add(product);
    }

    public void RemoveProduct(Product product)
    {
        products.remove(product);
    }

    Product Check_On_New_Product(List<Product> list_product, List<One_Meal> meals_in_day){
        boolean new_product = true;
        Random rand = new Random();
        Product product;
        int Rand;

        while (true){
            Rand = rand.nextInt(list_product.size());
            product = list_product.get(Rand);

            for(int i =0; i<meals_in_day.size(); i++){
                for (int j=0; j < meals_in_day.get(i).products.size(); j++){
                    if (Objects.equals(product, meals_in_day.get(i).products.get(j))){
                        new_product = false;
                        Rand = rand.nextInt(list_product.size());
                        product = list_product.get(Rand);
                        i = 0;
                        j = 0;
                    }
                    else{
                        new_product = true;
                    }
                }
            }
            if(new_product){
                break;
            }
        }
        return product;
    }

    Boolean Check_on_Special_Diet(TypeOfDiet diet)
    {
        return diet != TypeOfDiet.diet_regular && diet != TypeOfDiet.diet_16_8;
    }

    @Override
    public Iterator<Product> iterator()
    {
        return new Iterator<>()
        {
            private Iterator<Product> iter = products.iterator();

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public Product next() {
                return iter.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public float getKilocalories() {
        return kilocalories;
    }

    public float getProtein() {
        return protein;
    }

    public float getFats() {
        return fats;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setMax_protein(float max_protein) {
        this.max_protein = max_protein;
    }

    public void setMax_fats(float max_fats) {
        this.max_fats = max_fats;
    }

    public void setMax_carbohydrates(float max_carbohydrates) {
        this.max_carbohydrates = max_carbohydrates;
    }

    public void setMax_kilocalories(float max_kilocalories) {
        this.max_kilocalories = max_kilocalories;
    }

    @Autowired
    public void setDirectory(IDirectory directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return  "Общее количество белка за приём пищи: " + protein + "\n" +
                "Общее количество Жиров за приём пищи: " + fats + "\n" +
                "Общее количество Углеводов за приём пищи: " + carbohydrates + "\n" +
                "Общее количество ккал за приём пищи: " + kilocalories + "\n\n\n";
    }
}
