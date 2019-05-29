package etc.reflection;

import org.junit.Test;

import java.lang.reflect.Modifier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Goat extends Animal implements Locomotion {

    public Goat(String name) {
        super(name);
    }

    @Override
    protected String getSound() {
        return "bleat";
    }

    @Override
    public String getLocomotion() {
        return "walks";
    }

    @Override
    public String eats() {
        return "grass";
    }

    @Test
    public void givenClassName_whenCreatesObject_thenCorrect() throws ClassNotFoundException {
        String className = "etc.reflection.Goat";
        Class<?> clazz = Class.forName(className);

        System.out.println(clazz);

        assertEquals("Goat", clazz.getSimpleName());
        assertEquals(className, clazz.getName());
        assertEquals(className, clazz.getCanonicalName());
    }

    @Test
    public void givenClass_whenRecognisesModifiers_thenCorrect() throws ClassNotFoundException {
        Class<?> goatClass = Class.forName("etc.reflection.Goat");
        Class<?> animalClass = Class.forName("etc.reflection.Animal");

        int goatMods = goatClass.getModifiers();
        int animalMods = animalClass.getModifiers();

        assertTrue(Modifier.isPublic(goatMods));
        assertTrue(Modifier.isAbstract(animalMods));
        assertTrue(Modifier.isPublic(animalMods));
    }

}
