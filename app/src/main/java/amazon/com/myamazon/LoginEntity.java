package amazon.com.myamazon;

/**
 * Created by saurabh goyal on 11/23/2015.
 */
public class LoginEntity {
String Username;
    String Password;
    String method;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
