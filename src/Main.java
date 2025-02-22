import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        // after each 100 000 object, garbage collector is recommended manually
        for (int i = 0; i <= 1000000; i++){
            new Human("Eko", "Taghiyev", 1995);
            if(i % 100000 == 0){
                System.gc();
            }
        }

        System.gc();


//        String[][] annaSchedule = {
//                {DayOfWeek.MONDAY.name(), "cry"} ,
//                {DayOfWeek.TUESDAY.name(), "cheat on your husband"},
//                {DayOfWeek.WEDNESDAY.name(), "throw yourself under a train"}};
//
//        String[][] annaSchedule2 = {
//                {DayOfWeek.THURSDAY.name(), "cry"} ,
//                {DayOfWeek.FRIDAY.name(), "cheat on your husband"},
//                {DayOfWeek.SUNDAY.name(), "throw yourself under a train"}};
//
//        Human mother = new Human("Anna", "Karenina", 1849, 105, annaSchedule);
//        Human father = new Human("Alexei", "Karenin", 1829);
//
//        Family family = new Family(mother, father);
//
//        Human son = new Human("Sergei", "Karenin", 1869);
//        Human daughter = new Human("Annie", "Karenina", 1876);
//        family.addChild(son);
//        family.addChild(daughter);
//        System.out.println(family.toString());
//        family.deleteChild(son);
//        System.out.println(family.toString());
//        family.deleteChild(family.getChildren(), 0);
//        System.out.println(family.toString());

//        String[] habits2 = {"bark to the postman", "eat whatever you see", "broke the window"};
//        String[] habits = {"bark to the postman", "eat whatever you see", "broke the vase"};
//        Pet pet = new Pet(Species.CAT, "Qəzənfər", 13, 31, habits);
//        Pet petCpy = new Pet(Species.CAT, "Qəzənfər", 18, 30, habits2);
//        Pet pet2 = new Pet(Species.DOG, "Namiq", 13, 69, habits2);
//        Pet pet3 = new Pet(Species.TARANTULA, "Peter Parker");
//
//        System.out.println(pet);
//        System.out.println(pet2);
//        System.out.println(pet3);
//        System.out.println(pet.equals(petCpy));
//
//        pet.foul();
//        pet.respond();
//
//        System.out.println(Species.CAT.getClass());
//        System.out.println(Species.CAT.name());
//        System.out.println(Species.DOG.toString());
//        System.out.println(Species.DOG.ordinal());
//
//
//        System.gc();

    }
}
