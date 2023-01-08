package lesson06_defining_classes.exercise.N07_Google;

class Child {
    private final String name;
    private final String birthday;

    public Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
