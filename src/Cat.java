
public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String Mood() {

        if (this.getStatus() > 75) {

            return "Puur... (" + this.getName() + " feels happy!), mood: " + this.getStatus();

        } else if (this.getStatus() < 25) {

            return "Meow... (" + this.getName() + " feels sad), mood: " + this.getStatus();

        } else {

            return "Meow (" + this.getName() + " feels neutral), mood: " + this.getStatus();

        }

    }

}
