
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String Mood() {

        if (this.getStatus() > 75) {

            return "Woof woof! (" + this.getName() + " feels happy!), mood: " + this.getStatus();

        } else if (this.getStatus() < 25) {

            return "Woof... (" + this.getName() + " feels sad), mood: " + this.getStatus();

        } else {

            return "Woof (" + this.getName() + " feels neutral), mood: " + this.getStatus();

        }

    }

}
