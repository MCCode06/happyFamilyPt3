
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.lang.ref.Cleaner;

public class Human {

    private static final Cleaner CLEANER = Cleaner.create();
    private final Cleaner.Cleanable cleanable;

    public Runnable finalizer() {
        return () -> {
            try {
                System.out.println("Finalizer initiated...");
            } catch (Throwable e) {
                System.out.println("Exception in finalizer: " + e.getMessage());
                throw e;
            } finally {
                System.out.println("Human is finalized.");
            }
        };
    }

    static {
        System.out.println("Human class is loaded");
    }

    {
        System.out.println("Human object is created");
    }

    public static int count = 0;
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;


    public Human() {
        cleanable = CLEANER.register(this, this.finalizer());
        count++;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        cleanable = CLEANER.register(this, this.finalizer());
    }


    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        cleanable = CLEANER.register(this, this.finalizer());
    }



    public void greetPet() {
        if (family != null && family.getPet() != null) {
            Pet pet = family.getPet();
            System.out.println("Hello, " + pet.getNickname());
        } else System.out.println("I dont own a pet :(");
    }

    public void describePet() {
        if (family != null && family.getPet() != null) {
            Pet pet = family.getPet();
            String slyness = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.println("I have a " + pet.getSpecies() + ". He is " + pet.getAge() + " years old, he is " + slyness);
        } else System.out.println("I dont own a pet :(");
    }

    public boolean feedPet(boolean isTimeForFeeding) {
        if (family != null && family.getPet() != null) {
            Pet pet = family.getPet();

            if (isTimeForFeeding) {
                System.out.println("Hm... I will feed " + name + "'s " + pet.getSpecies());
                return true;
            }
            else {
                Random random = new Random();
                int randomNumber = random.nextInt(101);
                System.out.println("trick level is " + pet.getTrickLevel() + " / random number is " + randomNumber);
                if (pet.getTrickLevel() > randomNumber) {
                    System.out.println("Hm... I will feed " + name + "'s " + pet.getSpecies()   );
                    return true;
                }
                else {
                    System.out.println("I think " + name + "'s " + pet.getSpecies()  + " is not hungry.");
                    return false;
                }

            }
        } else {
            System.out.println("I dont own a pet :(");
            return false;
        }
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }
    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    //Getters
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getYear() {
        return year;
    }
    public int getIq() {
        return iq;
    }
    public String[][] getSchedule() {
        return schedule;
    }
    public Family getFamily() {
        return family;
    }

    @Override
    public String toString() {
        String scheduleStr = Arrays.deepToString(schedule);
        return String.format("{Human: name = '%s', surname = '%s', year = %d, iq = %d, schedule = %s}",
                name, surname, year, iq, scheduleStr);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        if (year != human.year) return false;
        if (iq != human.iq) return false;
        if (!Objects.equals(name, human.name)) return false;
        return  (Objects.equals(surname, human.surname));
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 31 * result + name.hashCode();
        }
        if (surname != null) {
            result = 31 * result + surname.hashCode();
        }
        result = 31 * result + year;
        result = 31 * result + iq;
        return result;
    }

}





