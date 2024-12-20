import Database.Database;
import Database.Directory;
import ForProducts.Meal.Breakfast;
import ForProducts.Meal.One_Meal;
import ForProducts.Meal.Visitor.MealVisitor;
import ForProducts.Meal.Visitor.MealVisitorClass;
import ForProducts.Product.DietPlan;
import ForProducts.Product.TypeOfDiet;
import Human.Gender;
import Human.GenderException;
import Human.Human;
import Human.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main
{
    static Scanner _scanner = new Scanner(System.in);
    public static Human mainHuman;    // создаём параметры пользователя для которого нужна диета
    public static DietPlan _diet_plan;    // план питания на день

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        mainHuman = context.getBean(Human.class);
        Enter_Data_For_Person();

        _diet_plan = context.getBean(DietPlan.class);

        _diet_plan.Create_Day_Diet();

        _diet_plan.Show_Ration_OnDay();
        context.close();
    }

    private static void Enter_Data_For_Person()   // ввод всех необходимых данных о человеке
    {
        Integer age = 0, Opredelitel_Mode_Life = 0;
        Float height = 0.f, weight = 0.f;
        float activityCoefficient;
        Gender gender = Gender.Male;
        TypeOfDiet dietplane = TypeOfDiet.diet_regular;

        age = (Integer) EnterFromKeyboard("Сколько тебе лет:", age.getClass().getSimpleName());
        height = (Float) EnterFromKeyboard("Введи рост", height.getClass().getSimpleName());
        weight = (Float) EnterFromKeyboard("Введи вес", weight.getClass().getSimpleName());
        Opredelitel_Mode_Life = (Integer) EnterFromKeyboard("Какой образ жизни ты ведёшь:\n" +
                "1) Минимальная физическая нагрузка \n" +
                "2) Тренировки средней тяжести 2-3 раза в неделю\n" +
                "3) Интенсивные тренировки более 3 раз в неделю\n" +
                "4) Ежедневная физическая нагрузка\n" +
                "(Введите номер)\n", Opredelitel_Mode_Life.getClass().getSimpleName());
        gender = (Gender) EnterFromKeyboard("Определите свой пол:\n" +
                "1) Мужчина\n" +
                "2) Женщина", gender.getClass().getSimpleName());


        dietplane = (TypeOfDiet) EnterFromKeyboard("Определите нужный вам план диеты:\n" +
                "1) Обычный режим питания\n" + "2) Диета 15/9 \n" + "3) Диета 20/4\n" + "4) Диета 24/0\n"
                , dietplane.getClass().getSimpleName());

        switch (Opredelitel_Mode_Life)
        {
            default:
            case 1:
                activityCoefficient = 1.2f;
                break;
            case 2:
                activityCoefficient = 1.4f;
                break;
            case 3:
                activityCoefficient = 1.6f;
                break;
            case 4:
                activityCoefficient = 1.8f;
                break;
        }
        mainHuman.SetHumanParametres(age,height,weight,activityCoefficient,gender,dietplane);
    }

    private static Object EnterFromKeyboard(String message, String datatype)
    {
        System.out.println(message);
        while (true)
        {
            switch (datatype)
            {
                case "Integer":
                {
                    if (_scanner.hasNextInt())
                        return _scanner.nextInt();
                    else
                        System.out.println(message);
                    break;
                }
                case "Float":
                {
                    if (_scanner.hasNextFloat())
                        return _scanner.nextFloat();
                    else
                        System.out.println(message);
                    break;
                }

                case "TypeOfDiet":
                {
                    if (_scanner.hasNextInt())
                    {
                        try
                        {
                            switch (_scanner.nextInt())
                            {
                                case 1 ->
                                {
                                    return TypeOfDiet.diet_regular;
                                }
                                case 2 ->
                                {
                                    return TypeOfDiet.diet_16_8;
                                }

                                case 3 ->
                                {
                                    return TypeOfDiet.diet_20_4;
                                }
                                case 4 ->
                                {
                                    return TypeOfDiet.diet_24_0;
                                }
                                default -> throw new RuntimeException("Неизвестная интервальная диета\n" +
                                        "Попробуйте ввести еще раз");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage() + "\n" + message);
                        }
                    }
                    else
                        System.out.println(message);
                    break;
                }

                case "Gender":
                {
                    if (_scanner.hasNextInt())
                    {
                        try
                        {
                            switch (_scanner.nextInt())
                            {
                                case 1 ->
                                {
                                    return Gender.Male;
                                }
                                case 2 ->
                                {
                                    return Gender.Female;
                                }
                                default -> throw new GenderException("Неизвестный гендер\n" +
                                        "Попробуйте ввести еще раз");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e.getMessage() + "\n" + message);
                        }
                    }
                    else
                        System.out.println(message);
                    break;
                }
            }
        }
    }

}
