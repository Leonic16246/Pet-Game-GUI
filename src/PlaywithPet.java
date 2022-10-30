
public class PlaywithPet {

    public PlaywithPet() {

    }

    public void playwith(Animal Pet) {
        if (Pet != null) {
            Pet.Play();
            //Pet.Mood();
        } else {
            System.out.println("No pet loaded");
        }

    }

}
