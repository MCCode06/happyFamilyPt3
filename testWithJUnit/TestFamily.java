import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TestFamily {
    static private Human mother;
    static private Human father;
    static private Family family;
    static private Human child1;
    static private Human child2;
    static private Human child3;

    @BeforeEach
    void setUp() {
        mother = new Human("X", "X", 1983);
        father = new Human("X", "Y", 1977);
        family = new Family(mother, father);
        String[][] schedule1 = new String[][]{
                {DayOfWeek.MONDAY.name(), "sleep"},
                {DayOfWeek.TUESDAY.name(), "drink beer"},
                {DayOfWeek.THURSDAY.name(), "do drugs"},
                {DayOfWeek.FRIDAY.name(), "party"}};
        child1 = new Human("Sanka", "Zeynalli", 2006, 120, schedule1);
        child2 = new Human("Xaqan", "Zeynalli", 2005, 115, schedule1);
        child3 = new Human("Nigga", "Zeynalli", 2010);


    }

    @Test
    void testToString() {
        family.addChild(child1);
        family.setPet(new Pet(Species.DOG, "Qazo"));
        String expected = "Family: { mother = {Human: name = 'X', surname = 'X', year = 1983, iq = 0, schedule = null},\n" +
                "father = {Human: name = 'X', surname = 'Y', year = 1977, iq = 0, schedule = null}, \n" +
                "children = [{Human: name = 'Sanka', surname = 'Zeynalli', year = 2006, iq = 120, schedule = [[MONDAY, sleep], [TUESDAY, drink beer], [THURSDAY, do drugs], [FRIDAY, party]]}], \n" +
                "pet = {Pet: DOG, nickname = 'Qazo', age = 0, trickLevel = 0, habits = null, canFly = false, numberOfLegs = 4, hasFur = true}}";
        assertEquals(expected, family.toString());
    }

    @Test
    void testAddChild() {
        family.addChild(child3);
        int size = family.getChildren().length;
        family.addChild(child1);
        assertEquals(size + 1, family.getChildren().length);
        assertEquals(child1, family.getChildren()[1]);
        assertEquals(family, child1.getFamily());
    }

    @Test
    void testDeleteChildByObject_Positive() {
        family.addChild(child1);
        assertTrue(family.deleteChild(child1));
        assertEquals(0, family.getChildren().length);
    }

    @Test
    void testDeleteChildByObject_Negative() {
        family.addChild(child3);
        assertFalse(family.deleteChild(child1));
        assertEquals(1, family.getChildren().length);
    }

    @Test
    void testDeleteChildByIndex_Positive() {
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        assertTrue(family.deleteChild(family.getChildren(), 1));
        assertEquals(2, family.getChildren().length);
        assertEquals(child3, family.getChildren()[1]);
    }

    @Test
    void testDeleteChildByIndex_Negative() {
        family.addChild(child1);
        assertFalse(family.deleteChild(family.getChildren(), 3));
        assertEquals(1, family.getChildren().length);
    }

    @Test
    void testCountFamily() {
        assertEquals(2, family.countFamily());
        family.addChild(child1);
        assertEquals(3, family.countFamily());
    }

    @Test
    void testEqualsAndHashCode() {
        Human mother2 = new Human("A", "B", 1983);
        Human father2 = new Human("C", "D", 1977);
        Family family2 = new Family(mother, father);
        Family family3 = new Family(mother, father);
        Family family4 = new Family(mother2, father2);


        // Reflexivity
        assertEquals(family, family);

        // Symmetry
        assertEquals(family, family2);
        assertEquals(family2, family);

        // Transitivity
        assertEquals(family, family2);
        assertEquals(family2, family3);
        assertEquals(family, family3);

        // Consistency
        assertEquals(family, family2);
        assertEquals(family, family2);

        // Non-nullity
        assertNotEquals(null, family);

        // Different objects
        assertNotEquals(family, family4);

        // HashCode
        assertEquals(family.hashCode(), family2.hashCode());
        assertNotEquals(family.hashCode(), family4.hashCode());
    }

    @Test
    void hashCodeChange() {
        int hscd1 = family.hashCode();
        int hscd2 = family.hashCode();
        assertEquals(hscd1, hscd2);
        assertEquals(hscd2, hscd1);
        family.setFather(new Human("Y", "Z", 1977));
        int hscd4 = family.hashCode();
        assertNotEquals(hscd1, hscd4);

    }
}
