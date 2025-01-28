package rationKit.Database;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rationKit.ForProducts.Product.Builder.BuilderProductClass;
import rationKit.ForProducts.Product.Original;
import rationKit.ForProducts.Product.Product;
import rationKit.ForProducts.Product.TypeProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Component("db")
public class Database implements IDatabase
{
    @Value("${ration-kit.database.database-url}")
    private String url;
    @Value("${ration-kit.database.user}")
    private String user;
    @Value("${ration-kit.database.password}")
    private String password;

    @Value("${ration-kit.database.poolSize}")
    private int poolSize;
    private BlockingQueue<Connection> pool;


    @PostConstruct
    public void init()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            initConnectionPool();
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void initConnectionPool()
    {
        pool = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            var proxyConnection = Proxy.newProxyInstance(Database.class.getClassLoader(),
                    new Class[]{Connection.class},
                    ((proxy, method, args) -> method.getName().equals("close") ? pool.add((Connection) proxy)
                            : method.invoke(Connect(), args)));
            pool.add((Connection) proxyConnection);
        }
    }

    private Connection Connect() {
        var authorization = new Properties();
        authorization.put("user", user);
        authorization.put("password", password);

        try {
            return DriverManager.getConnection(url, authorization);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Connection getConnection()
    {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> GetData(String sql)
    {
        List<Product> list = new LinkedList<>();
        try (Connection connect = getConnection();
             Statement _statement = connect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
             var table = _statement.executeQuery(sql))
        {
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
