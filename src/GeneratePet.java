public class GeneratePet {
    
    public Animal generatePet(int type, String name) { // Class to make an animal object from either pet creation or from reading file

        switch (type) {
            case 1:

                return new Dog(name);
        
            case 2:

                return new Cat(name);

            default:
            
                return null;

        }


    }

}
