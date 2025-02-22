import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPet {
    @Test
    void testToString() {
        Pet pet = new Pet(Species.DOG, "Qazo", 5, 31, new String[]{"play", "vomit"});
        String expected = "{Pet: DOG, nickname = 'Qazo', age = 5, trickLevel = 31, habits = [play, vomit], canFly = false, numberOfLegs = 4, hasFur = true}";
        assertEquals(expected, pet.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Pet pet1 = new Pet(Species.CAT, "Messi", 36, 99, null);
        Pet pet2 = new Pet(Species.CAT, "Messi", 36, 99, null);
        Pet pet3 = new Pet(Species.CAT, "Messi", 36, 99, null);
        Pet pet4 = new Pet(Species.DOG, "Penaldo", 38, 98, null);

        // Reflexivity
        assertEquals(pet1, pet1);

        // Symmetry
        assertEquals(pet1, pet2);
        assertEquals(pet2, pet1);

        // Transitivity
        assertEquals(pet1, pet2);
        assertEquals(pet2, pet3);
        assertEquals(pet1, pet3);

        // Consistency
        assertEquals(pet1, pet2);
        assertEquals(pet1, pet2);

        // Non-nullity
        assertNotEquals(null, pet1);

        // Different values
        assertNotEquals(pet1, pet4);

        // HashCode test
        assertEquals(pet1.hashCode(), pet2.hashCode());
        assertNotEquals(pet1.hashCode(), pet4.hashCode());
    }
}

