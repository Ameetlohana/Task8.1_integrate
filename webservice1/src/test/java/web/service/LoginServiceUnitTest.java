package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("ameet", "ameet_pass", "1997-12-23"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("invalid_user", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("ahsan", "invalid_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidDOB() {
        assertFalse(LoginService.login("ahsan", "ahsan_pass", "invalid_dob"));
    }

    @Test
    public void testNullInputs() {
        assertFalse(LoginService.login(null, "ahsan_pass", "1990-01-01"));
        assertFalse(LoginService.login("ahsan", null, "1990-01-01"));
        assertFalse(LoginService.login("ahsan", "ahsan_pass", null));
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyInputs() {
        assertFalse(LoginService.login("", "ahsan_pass", "1990-01-01"));
        assertFalse(LoginService.login("ahsan", "", "1990-01-01"));
        assertFalse(LoginService.login("ahsan", "ahsan_pass", ""));
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testInvalidLoginCombination() {
        assertFalse(LoginService.login("invalid_user", "invalid_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        assertFalse(LoginService.login("invalid_user", "invalid_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidPasswordAndDOB() {
        assertFalse(LoginService.login("ahsan", "invalid_pass", "invalid_dob"));
    }

    @Test
    public void testInvalidUsernameAndDOB() {
        assertFalse(LoginService.login("invalid_user", "ahsan_pass", "invalid_dob"));
    }

    @Test
    public void testInvalidUsernameAndPasswordAndDOB() {
        assertFalse(LoginService.login("invalid_user", "invalid_pass", "invalid_dob"));
    }

    @Test
    public void testInvalidUsernameAndNullPassword() {
        assertFalse(LoginService.login("invalid_user", null, "1990-01-01"));
    }

    @Test
    public void testInvalidPasswordAndNullUsername() {
        assertFalse(LoginService.login(null, "invalid_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidUsernameAndNullDOB() {
        assertFalse(LoginService.login("invalid_user", "ahsan_pass", null));
    }

    @Test
    public void testNullUsernameAndNullPasswordAndNullDOB() {
        assertFalse(LoginService.login(null, null, null));
    }
}
