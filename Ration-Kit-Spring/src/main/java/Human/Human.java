package Human;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ForProducts.Product.TypeofDiet;

@Scope ("singleton")
@Component ("human")
public class Human
{

    // Calculated ration values
    private float kilocalories, protein, fats, carbohydrates;
    private TypeofDiet _Type_Diet;

    public Human(){
        kilocalories=0;
        protein=0;
        fats=0;
        carbohydrates=0;
        TypeofDiet dietType = null; // Пользователь укажет тип диеты


    }

    @Override
    public String toString() {
        return "Human{" +
                "kilocalories=" + kilocalories +
                ", protein=" + protein +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", _Type_Diet=" + _Type_Diet +
                '}';
    }

    public Human SetHumanParametres(int age, float height, float weight,
                                    float activityCoefficient, Gender gender, TypeofDiet _Type_Diet)
    {
        this._Type_Diet = _Type_Diet;
        kilocalories = CalculateKilocalories(age, height, weight, activityCoefficient, gender);
        CalculateSFC();
        return this;
    }


    private float CalculateKilocalories(int age, float height, float weight,
                                        float activityCoefficient, Gender gender)  // подсчёт ккал необходимый для конкретного человека
    {
        try
        {
            switch (gender)
            {
                case Male ->
                {

                    return (float) ((weight * 10 + height * 6.25 - age * 5 + 5) * activityCoefficient);

                }
                case Female ->
                {
                    return (float) ((weight * 10 + height * 6.25 - age * 5 - 161) * activityCoefficient);
                }
                default -> throw new GenderException("Unknown gender");
            }
        }
        catch (GenderException e)
        {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    private void CalculateSFC()       // расчёт БЖУ на день
    {
        protein = (kilocalories * 0.25f) / 4;
        fats = (kilocalories * 0.25f) / 9;
        carbohydrates = (kilocalories * 0.5f) / 4;
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

    public TypeofDiet getTypeDiet() {
        return _Type_Diet;
    }
}
