import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class KeyReader {
    private String api_key;

    public KeyReader() {
        Properties appprops = new Properties();
        try {
            appprops.load(new FileReader("resources/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        api_key = appprops.getProperty("api_key");
    }

    public String getAPIKey(){
        return api_key;
    }
}
