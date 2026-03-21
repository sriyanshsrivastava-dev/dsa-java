package dsa.recursion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionConceptTest {

    @Test
    void testFact(){
        assertEquals(24, RecursionConcept.fact(4));
        assertEquals(1, RecursionConcept.fact(1));
        assertEquals(1, RecursionConcept.fact(0));
        assertEquals(120, RecursionConcept.fact(5));
        assertEquals(6, RecursionConcept.fact(3));
    }
}
