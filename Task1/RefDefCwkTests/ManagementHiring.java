package RefDefCwkTests;

import RefDefCwk.ITProject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import RefDefCwk.BITS;

public class ManagementHiring {
    BITS pr;

    @Before
    public void setUp() {
        pr = new ITProject("Olenka",1000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hireStaff(){
        int expected = 800;
        pr.hireStaff("Amir");
        assertEquals(expected, pr.getAccount());
    }

    @Test
    public void hiredStaffInTeam() {
        int expected = 600;
        pr.hireStaff("Amir");
        pr.hireStaff("Lisa");
        boolean budgetOK = (expected == pr.getAccount());
        assertTrue(pr.isInTeam("Amir") && pr.isInTeam("Lisa") && budgetOK);
    }

    @Test
    public void hiredStaffNotAvailable() {
        boolean result = true;
        pr.hireStaff("Amir");
        pr.hireStaff("Lisa");
        String actual = pr.getAllAvailableStaff();
        result = !(actual.contains("Amir") || actual.contains("Lisa"));
        assertTrue(result);
    }

    @Test 
    public void notEnoughMoney() {
        pr.hireStaff("Amir");
        pr.hireStaff("Dana");
        pr.hireStaff("John");
        boolean result = (pr.getAccount() == 50);
        result = result && !pr.isInTeam("John");
        assertTrue(result);
    }

    @Test 
    public void notSuchStaff() {
        pr.hireStaff("John");
        boolean result = (pr.getAccount() == 1000);
        result = result && !pr.isInTeam("John");
        assertTrue(result);
    }
}
