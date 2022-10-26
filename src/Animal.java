public abstract class Animal {

    private String name;
    private int age, status;

    public Animal(String name) {
        this.name = name;
        this.age = 0;

        this.status = 50;
    }

    public Animal() {
        this.name = "temp";
        this.age = 0;
        this.status = 50;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public abstract void Mood(); // abstract method to print mood of animal

    public void Play() {
  
        this.status += 10;

        if (this.status > 100) {
            this.status = 100;
            System.out.println(name + " is at max status");
        } else {
            System.out.println("Status +10");
        }

    }

    
}
