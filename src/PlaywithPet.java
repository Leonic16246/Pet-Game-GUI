
public class PlaywithPet {

    public PlaywithPet() {

    }

    //play with pet
    public void playwith(Animal Pet) {
        if (Pet != null) {
            Pet.Play();
            //Pet.Mood();
        } else {
            System.out.println("No pet loaded");
        }

    }

}
