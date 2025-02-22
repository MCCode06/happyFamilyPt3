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
        Human mother;
        Human father;
        Family family;
        String[][] schedule1;
        Human child1;
        Human child2;
        Human child3;

        mother = new Human("X","X",1983);
        father = new Human("X","Y",1977);
        family = new Family(mother,father);
        schedule1 = new String[][]{
                {DayOfWeek.MONDAY.name(),"sleep"},
                {DayOfWeek.TUESDAY.name(),"drink beer"},
                {DayOfWeek.THURSDAY.name(),"do drugs"},
                {DayOfWeek.FRIDAY.name(),"party"}};
        child1 = new Human("Sanka","Zeynalli",2006,120,schedule1);
        child2 = new Human("Xaqan","Zeynalli",2005, 115,schedule1);
        child3 = new Human("Nigga","Zeynalli",2010);
        System.out.println(child1.toString());

        family.addChild(child1);
        family.setPet(new Pet(Species.DOG, "Qazo"));
        System.out.println(family.toString());



    }
}
