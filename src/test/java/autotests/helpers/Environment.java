package autotests.helpers;

public class Environment {
    public static final String
            baseUrl = System.getProperty("base_url","https://github.com"),
            baseApiUrl = System.getProperty("base_api_url","https://api.github.com"),
            fileUrl = System.getProperty("page_with_file","https://resources.github.com/whitepapers/How-GitHub-secures-open-source-software/"),
            repository = System.getProperty("repository","KatjaTest/Test-repository"),
            tokenGithub = System.getProperty("token", ""),
            usernameGithub = System.getProperty("user_name","KatjaTest"),
            passwordGithub = System.getProperty("password", ""),
            incorrectPasswordGithub = System.getProperty("incorrect_password","fdfsfsfse"),
            incorrectUsernameGithub = System.getProperty("incorrect_password","KatjTest"),


            remoteDriverUrl = System.getProperty("remote_driver_url","https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/"),//https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/
            videoStorageUrl = System.getProperty("video_storage_url","https://selenoid.autotests.cloud/video/");//https://selenoid.autotests.cloud/video/

    public static boolean
            isRemoteDriver = remoteDriverUrl != null,
            isVideoOn = videoStorageUrl != null;

     public static int
            correctIssueNumber = 1,
            incorrectIssueNumber = 121457;
}
