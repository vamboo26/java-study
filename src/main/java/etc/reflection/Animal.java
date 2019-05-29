package etc.reflection;

public abstract class Animal implements Eating {

    public String CATEGORY = "domestic";
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    protected abstract String getSound();

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
