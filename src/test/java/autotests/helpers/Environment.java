package autotests.helpers;

public class Environment {
    public static final String
            baseUrl = System.getProperty("BASE_URL","https://github.com"),
            repository = System.getProperty("REPOSITORY","KatjaShcherbakova/Autotests-examples");
     public static int
            correctIssueNumber = System.getProperty("CORRECT_ISSUE", 1),
            incorrecIssueNumber = System.getProperty("INCORRECT_ISSUE", 3),
    ;
}
