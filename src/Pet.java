import java.util.Arrays;
import java.util.Objects;

public class Pet {

    static {
        System.out.println("Pet class is loaded");
    }

    {
        System.out.println("Pet object is crated");
    }

    private String species;
    private String nickname;
    private String[] habits;
    private int age;
    private int trickLevel;

    public Pet() {}

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }


    public void eat(){
        System.out.println("I am eating...");
    }

    public void respond() {
        System.out.println("Hello, owner. I am " + this.species + ". I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }

    // Setters
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }
    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    // Getters
    public String getSpecies() {
        return species;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }
    public String[] getHabits() {
        return habits;
    }


    @Override
    public String toString() {
        String habitsStr = Arrays.toString(habits);
        return String.format("{Pet: %s, nickname = '%s', age = %d, trickLevel = %d, habits = %s}",
                species, nickname, age, trickLevel, habitsStr);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        if (!Objects.equals(species, pet.species)) return false;
        if (age != pet.age) return false;
        return (Objects.equals(nickname, pet.nickname));
    }

    @Override
    public int hashCode() {
        int result = species.hashCode();
        result = 31 * result + nickname.hashCode();
        result = 31 * result + age;
        return result;
    }
}

