package etc.headfirst.design_pattern;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("날수없어요");
    }
}
