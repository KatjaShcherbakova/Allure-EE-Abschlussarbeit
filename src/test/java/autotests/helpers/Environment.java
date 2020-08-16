package autotests.helpers;

public class Environment {
    public static final String
            baseUrl = System.getProperty("BASE_URL","https://github.com"),
            baseApiUrl = System.getProperty("BASE_URL","https://api.github.com"),
            fileUrl = System.getProperty("FILE_URL","https://resources.github.com/whitepapers/How-GitHub-secures-open-source-software/"),
            repository = System.getProperty("REPOSITORY","KatjaTest/Test-repository"),
            tokenGithub = System.getProperty("TOKEN", ""),
            usernameGithub = System.getProperty("USER_NAME","KatjaTest"),
            passwordGithub = System.getProperty("PASSWORD_GITHUB", ""),
            incorrectPasswordGithub = System.getProperty("INCORRECT_PASSWORD","fdfsfsfse"),
            incorrectUsernameGithub = System.getProperty("INCORRECT_USERNAME","KatjTest"),


            remoteDriverUrl = System.getProperty("remote_driver_url"),
            videoStorageUrl = System.getProperty("video_storage_url");

     public static int
            correctIssueNumber = 1,
            incorrectIssueNumber = 33333;
}
