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
public class ManagementGeneral {

    BITS pr;

    @Before
    public void setUp() {
        pr = new ITProject("Olenka",1000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void checkAccountAtStart() {
        //Checks that account is set to the parameter in setUp() above
        assertEquals(1000.0, pr.getAccount(), 0.5);
    }

    @Test
    public void checkTeamAtStart() {
        //Checks that team is empty at the start
        assertTrue((pr.getTeam().contains("No staff hired")));
    } 

    @Test
    public void isNotOverdrawnAtStart() {
        assertTrue(!pr.isOverdrawn());
    }

    @Test
    public void isInJobRange() {
       // Checks that jobs have been loaded and can retrieve a job
       boolean actual = true;
       for (int x=100; x<=106; x++){
           actual = actual && pr.isJob(x);
       }
       assertTrue(actual);
    }

    @Test
    public void isNotInJobRange() {
       // Checks correct response to out of range job numbers
       boolean actual = true;
       int x = 99;
       int y = 108;
       actual = !pr.isJob(x) && !pr.isJob(y);
       assertTrue(actual);
    }

    @Test
    public void Job100InAllJobs() {
        String str = pr.getAllJobs();
        boolean result = containsText2(str,"Design","3","10");
        assertTrue(result);
    }

    private boolean containsText2(String text, String s1, String s2, String s3) {
        boolean result = false;
        result = text.contains(s1) && text.contains(s2) && text.contains(s3) ;
        return result;
    }
}
