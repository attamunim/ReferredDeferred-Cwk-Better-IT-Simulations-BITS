package RefDefCwkTests;

import RefDefCwk.ITProject;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import RefDefCwk.BITS;

/**
 * The test class GeneralTest, to test setup and some general 
 * functionality.
 */
public class GeneralTest {
    BITS pr;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        // Create the ITProject object used before each test method
        pr = new ITProject("Olenka", 1000);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test hiring a staff member.
     */
    @Test
    public void testHireStaff() {
        // Hire staff member Amir
        boolean result = pr.hireStaff("Amir");
        assertTrue("Hiring Amir should be successful", result);

        // Check if Amir is in the team
        List<String> team = pr.getTeam();
        assertTrue("Amir should be in the team", team.contains("Amir"));

        // Check account balance
        int accountBalance = pr.getAccount();
        assertEquals("Account balance should be 800 after hiring Amir", 800, accountBalance);
    }

    // Additional test cases for other scenarios
}
