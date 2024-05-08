package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * 
     * @param username
     * @param password
     * @return
     */
    public static boolean login(String username, String password, String dob) {
        if (username == null || password == null || dob == null) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
            return false;
        }

        if (!isValidDOB(dob)) {
            return false;
        }

        // Match a fixed user name, password, and date of birth.
        if ("ameet".equals(username) && "ameet_pass".equals(password) && "1997-12-23".equals(dob)) {
            return true;
        }

        return false;
    }

    /**
     * Validates the format of the date of birth (yyyy-mm-dd).
     * 
     * @param dob
     * @return true if the format is valid, false otherwise.
     */
    private static boolean isValidDOB(String dob) {
        if (dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return true;
        }
        return false;
    }
}
