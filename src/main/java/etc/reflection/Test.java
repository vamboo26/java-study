package etc.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static etc.reflection.Person.getFieldNames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void givenObject_whenGetsFieldNamesAtRuntime_thenCorrect() {
        Object person = new Person();
        Field[] fields = person.getClass().getDeclaredFields();

        List<String> actualFieldNames = getFieldNames(fields);

        assertTrue(Arrays.asList("name", "age")
                .containsAll(actualFieldNames));
    }

    @org.junit.Test
    public void givenClass_whenGetsAllConstructors_thenCorrect() throws ClassNotFoundException {
        Class<?> birdClass = Class.forName("etc.reflection.Bird");
        Constructor<?>[] constructors = birdClass.getConstructors();

        assertEquals(3, constructors.length);
    }

}
