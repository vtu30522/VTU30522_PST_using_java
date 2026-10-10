class Authentication {

    private final String validUsername = "admin";
    private final String validPassword = "admin123";

    public boolean login(String username, String password) {

        try {
            // Edge-case validation
            if (username == null || password == null) {
                return false;
            }

            // Boundary value testing
            if (username.length() < 3 || username.length() > 20) {
                return false;
            }

            if (password.length() < 6 || password.length() > 20) {
                return false;
            }

            // Credential validation
            return username.equals(validUsername)
                    && password.equals(validPassword);

        } catch (Exception e) {
            return false;
        }
    }
}

public class Syllabus_Task10_SecureAuthenticationStressTesting {

    public static void main(String[] args) {

        Authentication auth = new Authentication();

        // Parameterized test cases
        String[][] testCases = {
            {"admin", "admin123"},
            {"ab", "123"},
            {"user", "pass"}
        };

        // Automated testing
        for (String[] test : testCases) {

            boolean result = auth.login(test[0], test[1]);

            if (result) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILURE");
            }
        }
    }
}