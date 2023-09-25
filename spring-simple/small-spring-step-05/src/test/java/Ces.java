/**
 * @author zhp
 * @date 2023/9/22 14:59
 **/
public class Ces {
    public static void main(String[] args) {
        String envName = System.getenv("TEST_ENV_NAME");
        String userDir = System.getProperty("user.dir");
        String osName = System.getProperty("os.name");
        System.out.println(envName);
        System.out.println(userDir);
        System.out.println(osName);
    }
}
