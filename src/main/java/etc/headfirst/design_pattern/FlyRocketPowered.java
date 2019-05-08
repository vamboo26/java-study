package etc.headfirst.design_pattern;

public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("로켓추진으로날아가!");
    }
}
