public class Cat extends Animal{


    public Cat(String name) {
        super(name);
    }

    @Override
    public void Mood() {

        if (this.getStatus() > 75) {
            
            System.out.println("Puur... (" + this.getName() + " feels happy!)");


        } else if (this.getStatus() < 25) {

            System.out.println("Meow... (" + this.getName() + " feels sad)");

        } else {

            System.out.println("Meow (" + this.getName() + " feels neutral)");

        }
        
    }


}
