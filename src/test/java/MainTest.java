import org.example.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.example.Main.*;

public class MainTest {

    @Test
    public void testreadString() {
        System.out.println("Running Test 1");
        String fileName = "new_data2.json";
        String expectid = "Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}\n";
        String result = readString(fileName);
        Assertions.assertEquals(expectid, result);
    }

    @Test
    public void testListToJson() {
        System.out.println("Running Test 2");
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", "Smith", "USA", 25));
        String expectid = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Smith\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"age\": 25\n" +
                "  }\n" +
                "]";
        String result = listToJson(list);
        Assertions.assertEquals(expectid, result);
    }

    @Test
    public void testAdd() {
        System.out.println("Running Test 3");
        Assertions.assertTimeout(Duration.ofSeconds(10), () -> new Employee(1, "John", "Smith", "USA", 25).toString());
    }
}
