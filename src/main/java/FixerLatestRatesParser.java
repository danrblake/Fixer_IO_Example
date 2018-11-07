import org.json.simple.JSONObject;
    public class FixerLatestRatesParser {

        JSONObject latestRates;
        JSONObject rateValues;

        public FixerLatestRatesParser() {
            FixerHTTPManager fixerHTTPManager = new FixerHTTPManager();
            fixerHTTPManager.setLatestRates();
            JSONFactory jsonFactory = new JSONFactory();
            jsonFactory.setLatestRates(fixerHTTPManager.getLatestRates());
            this.latestRates = jsonFactory.getLatestRates();
        }

        private Object getJSONValue(String key) {
            return latestRates.get(key);
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

