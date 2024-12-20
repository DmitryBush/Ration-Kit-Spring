package rationKit.Database;

import jakarta.annotation.PostConstruct;
import rationKit.ForProducts.Product.Builder.BuilderProductClass;
import rationKit.ForProducts.Product.Original;
import rationKit.ForProducts.Product.Product;
import rationKit.ForProducts.Product.TypeProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component("db")
public class Database implements IDatabase
{
    @Value("${ration-kit.database.database-url}")
    private String url;
    @Value("${ration-kit.database.user}")
    private String user;
    @Value("${ration-kit.database.password}")
    private String password;

    Properties authorization;
    Connection connection;

    @PostConstruct
    public void init()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connect();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    private void Connect() throws SQLException
    {
        authorization = new Properties();
        authorization.put("user", user);
        authorization.put("password", password);

        connection = DriverManager.getConnection(url, authorization);
    }
    public List<Product> GetData(String sql)
    {
        try (Statement _statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE))
        {
            var table = _statement.executeQuery(sql);
            List<Product> list = new LinkedList<>();
            table.beforeFirst();
            while (table.next())
            {
                list.add(new BuilderProductClass().SetName(table.getString("name_products"))
                        .SetOriginal(table.getBoolean("vegetable") ? Original.Vegetable : Original.Animal)
                        .SetTypeProduct(table.getBoolean("garnish") ? TypeProduct.Garnish
                                : table.getBoolean("adition") ? TypeProduct.Addition
                                : table.getBoolean("basic") ? TypeProduct.Basic : null)
                        .SetProtein(table.getFloat("protein"))
                        .SetFats(table.getFloat("fat"))
                        .SetCarbohydrates(table.getFloat("carbonohydrates"))
                        .SetMaxGramm(table.getInt("max_count")).BuildProduct());
            }
            table.close();
            _statement.close();
            return list;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Database{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
