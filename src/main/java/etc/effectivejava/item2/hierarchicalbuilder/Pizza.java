package etc.effectivejava.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        //TODO
        // Set, EnumSet 가져 올 차이는? 용도가 명확하다면 그냥 EnumSet타입이 나을까?
        // 아래에서 차이가 발생했음
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            //TODO
            // Objects.requireNonNull <- 널처리 유용?
            // Optional API와 차이는? 옵셔널이 최신이고 예전에 주로 쓰이던 걸까?
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    //TODO
    // 제네릭의 ? 표기는 어떤 의미?
    Pizza(Builder<?> builder) {
        //TODO
        // toppings를 Set으로 선언하면 .clone() 실행하고 형변환 필요해짐
        // clone()이 어떻게 작동하고 무엇을 반환하기에 명시적으로 업캐스팅이 필요할까?
        // + 업캐스팅, 다운캐스팅 다시 정리하기
        toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pizza{");
        sb.append("toppings=").append(toppings);
        sb.append('}');
        return sb.toString();
    }

}
