public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void Mood() {

        if (this.getStatus() > 75) {
            
            System.out.println("Woof woof! (" + this.getName() + " feels happy!)");


        } else if (this.getStatus() < 25) {

            System.out.println("Woof... (" + this.getName() + " feels sad)");

        } else {

            System.out.println("Woof (" + this.getName() + " feels neutral)");

        }

    
    }
    
    
}
