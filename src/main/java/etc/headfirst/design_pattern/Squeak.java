package etc.headfirst.design_pattern;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("삑!");
    }
}
