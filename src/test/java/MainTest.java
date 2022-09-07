import org.example.Employee;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.Main.*;

public class MainTest {


//    @ParameterizedTest
//    @MethodSource("source")
//    public void testreadString(String a, String expectid) {
//        System.out.println("Running Test 1");
//        final String result = readString(a);
//        Assertions.assertEquals(expectid, result);
//    }

//
//    private static Stream<Arguments> source() {
//        return Stream.of(Arguments.of("new_data2.json", "Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}\n"));
//    }

    @Test
    public void testreadString(){
        System.out.println("Running Test 1");
        final String a= "new_data2.json";
        final String expectid="Employee{id=1, firstName='John', lastName='Smith', country='USA', age=25}\n";
        final String result=readString(a);
        Assertions.assertEquals(expectid,result);
    }

    @Test
    public void testListToJson() {
        System.out.println("Running Test 2");
        List<Employee> a = new ArrayList<>();
        a.add(new Employee(1, "John", "Smith", "USA", 25));
        final String expectid = "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Smith\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"age\": 25\n" +
                "  }\n" +
                "]";
        final String result = listToJson(a);
        Assertions.assertEquals(expectid, result);
    }

    @Test
    public void testAdd() {
        System.out.println("Running Test 3");
        Assertions.assertTimeout(Duration.ofSeconds(10), () -> new Employee(1, "John", "Smith", "USA", 25).toString());
    }
}
