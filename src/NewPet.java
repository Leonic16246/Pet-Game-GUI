
public class NewPet extends GeneratePet { // Class to create a new pet from user input

    public NewPet() {

    }

    // creates a pet object
    public Animal newPet(int type, String name) {

        // if no input is given
        if (name.equals("")) {

            return null;

        }

        // if type is not selected
        if (type == 0) {

            return null;

        }

        return generatePet(type, name);
    }

}
