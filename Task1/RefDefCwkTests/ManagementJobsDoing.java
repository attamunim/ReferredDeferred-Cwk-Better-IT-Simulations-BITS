package RefDefCwkTests;

import RefDefCwk.ITProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import RefDefCwk.BITS;

/**
 * Provides tests for the basic BITS setup
 */
public class ManagementJobsDoing {

    BITS pr;

    @Before
    public void setUp() {
        pr = new ITProject("Olenka",1000);
    }

    @After
    public void tearDown() {
    }

    // Check if staff can do Jobs
    @Test
    public void technicianDoingSoftware() {
        pr.hireStaff("Bela");
        String done = pr.doJob(102).toLowerCase();
        boolean result = containsText(done,new ArrayList<>(Arrays.asList(
                       "no","staff","available" )));
        int expected = 800;
        assertTrue(expected == pr.getAccount() && result);      
    }

    private boolean containsText(String text, List<String> str) {
        boolean result = true;
        for (String s : str) {
            result = result && text.toLowerCase().contains(s.toLowerCase());
        }
        return result;
    }
}
