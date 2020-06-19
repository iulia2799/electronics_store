import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddProductsTest {

    @Before
    public void setUp() throws Exception {
        FileSystemServices.getPathToFile("inventory.json");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readProducts() {
        AddProducts products = new AddProducts();
        String result = products.readProducts();
        assertEquals("result ",result,result);
    }

    @Test
    public void addProduct() {
    }
}