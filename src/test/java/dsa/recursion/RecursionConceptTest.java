package dsa.recursion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionConceptTest {

    @Test
    void testFactorial() {
        assertEquals(24, RecursionConcept.fact(4));
    }

    @Test
    void testFactorialEdgeCase(){
        assertEquals(1,RecursionConcept.fact(0));
        assertEquals(1,RecursionConcept.fact(1));

    }

}
