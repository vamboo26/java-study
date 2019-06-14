package etc.effectivejava.item2.hierarchicalbuilder;

import java.util.Objects;

public class NyPizza extends Pizza {

    public enum Size { SMALL, MEDIUM, LARGE }

    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        //반환타입은 하위타입인 NyPizza
        //TODO
        // Pizza가 디폴드 제어자인데 public으로 변경해주는 이유는 뭘까?
        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    //Builder의 제네릭 <?> 사라짐
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NyPizza{");
        sb.append("size=").append(size);
        sb.append(", toppings=").append(toppings);
        sb.append('}');
        return sb.toString();
    }

}
