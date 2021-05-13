public class Client {
    private String name;
    private int age;

    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        if (age < 16) {
            age = 18;
        }
        return age;
    }

    public boolean isElderly() {
        return (age >= 60);
    }

}