import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JSONFactory {

    private JSONObject latestRates;

    public JSONObject getLatestRates() {
        return latestRates;
    }
    public void setLatestRates(String latestRatesJSONString) {
        JSONParser jsonParser = new JSONParser();
        try {
           this.latestRates = (JSONObject) jsonParser.parse(latestRatesJSONString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
