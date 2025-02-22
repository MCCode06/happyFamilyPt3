import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestHuman {
    @Test
    void testToString() {
        String[][] schedule1 = new String[][]{
                {DayOfWeek.MONDAY.name(), "sleep"},
                {DayOfWeek.TUESDAY.name(), "drink beer"},
                {DayOfWeek.THURSDAY.name(), "do drugs"},
                {DayOfWeek.FRIDAY.name(), "party"}};
        Human human = new Human("Sanka","Zeynalli",2006,120, schedule1);
        String expected = "{Human: name = 'Sanka', surname = 'Zeynalli', year = 2006, iq = 120, schedule = [[MONDAY, sleep], [TUESDAY, drink beer], [THURSDAY, do drugs], [FRIDAY, party]]}";
        assertEquals(expected, human.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        String[][] schedule1 = new String[][]{
                {DayOfWeek.MONDAY.name(), "sleep"},
                {DayOfWeek.TUESDAY.name(), "drink beer"},
                {DayOfWeek.THURSDAY.name(), "do drugs"},
                {DayOfWeek.FRIDAY.name(), "party"}};
        Human human1 = new Human("Sanka","Zeynalli",2006);
        Human human2 = new Human("Sanka","Zeynalli",2006);
        Human human3 = new Human("Sanka","Zeynalli",2006);
        Human human4 = new Human("Nigga", "Zeynalli", 2010);

        // Reflexivity
        assertEquals(human1, human1);

        // Symmetry
        assertEquals(human1, human2);
        assertEquals(human2, human1);

        // Transitivity
        assertEquals(human1, human2);
        assertEquals(human2, human3);
        assertEquals(human1, human3);

        // Consistency
        assertEquals(human1, human2);
        assertEquals(human1, human2);

        // Non-nullity
        assertNotEquals(null, human1);

        // Different objects
        assertNotEquals(human1, human4);

        // HashCode
        assertEquals(human1.hashCode(), human2.hashCode());
        assertNotEquals(human1.hashCode(), human4.hashCode());
    }
}

