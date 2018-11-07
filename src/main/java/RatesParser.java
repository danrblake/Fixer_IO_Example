import org.json.simple.JSONObject;
    public class RatesParser {

        JSONObject ratesFile;
        JSONObject rateValues;

        public RatesParser(String filePath) {
            RateFileReader rateFileReader = new RateFileReader(filePath);
            ratesFile = rateFileReader.getFullJSONFile();
        }

        public JSONObject getFile() {
            return ratesFile;
        }

        private Object getJSONValue(String key) {
            return ratesFile.get(key);
        }

        public String getJSONSuccess() {
            return getJSONValue("success").toString();
        }

        public Double getSpecificRate(String countryCode) {
            rateValues = (JSONObject) getJSONValue("rates");
            return (Double) (rateValues.get(countryCode));
        }

        public JSONObject getAllRates() {
            rateValues = (JSONObject) getJSONValue("rates");
            return rateValues;
        }

        public String getRatesDate() {
            return getJSONValue("date").toString();
        }

        public String getBaseCurrency() {
            return getJSONValue("base").toString();
        }

        public double getTimeStamp() {
            return Double.parseDouble(getJSONValue("timestamp").toString());
        }
    }

