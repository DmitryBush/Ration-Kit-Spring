package Database;

import ForProducts.Product.Builder.BuilderProductClass;
import ForProducts.Product.Original;
import ForProducts.Product.Product;
import ForProducts.Product.TypeProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.*;

@Component("db")
public class Database implements IDatabase
{
    String url, sql;
    private int size = 0;
    Properties authorization;
    Connection connection;

    public Database(@Value("jdbc:postgresql://localhost:5432/postgres") String url)
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            Connect(url);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    private void Connect(String url) throws SQLException
    {
        this.url = url;
        authorization = new Properties();
        authorization.put("user", "postgres");
        authorization.put("password", "postgres");

        connection = DriverManager.getConnection(url, authorization);
    }
    public List<Product> GetData(String sql)
    {
        try (Statement _statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE))
        {
            this.sql = sql;
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
    public int GetSize()
    {
        if (size == 0)
        {
            try (Statement _statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE))
            {
                var table = _statement.executeQuery(sql);
                table.last();
                size = table.getRow();
                table.beforeFirst();
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        return size;
    }

    @Override
    public String toString() {
        return "Database{" +
                "url='" + url + '\'' +
                ", sql='" + sql + '\'' +
                ", size=" + size +
                '}';
    }
}
