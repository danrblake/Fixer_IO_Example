import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
public class RatesTester {

    private FixerLatestRatesParser latestRatesParser = new FixerLatestRatesParser();
    private JSONObject rateValues;
    private Set<String> rateKeySet;
    private Object[] rateArray;

    @Before
    public void setUp() {
        rateValues = latestRatesParser.getAllRates();
        rateKeySet = rateValues.keySet();
        rateArray = rateKeySet.toArray();
    }

    @Test
    public void checkAllRatesPresent() {
        for (int i = 0; i < rateArray.length; i++) {
            assertTrue(rateValues.containsKey(rateArray[i]));
        }
    }

    @Test
    public void checkAllRatesHaveRateValue() {
        for (int i = 0; i < rateArray.length; i++) {
            assertNotEquals(null, rateValues.get(rateArray[i].toString()));
        }
    }
    @Test
    public void testDuplicateCountryCodes() {
        boolean checkedDuplicates = false;
        boolean duplicates = false;
        for (int i = 0; i < rateArray.length; i++) {
            for (int j = i + 1; j < rateArray.length; j++) {
                if (rateArray[i].equals(rateArray[j])) {
                    duplicates = true;
                }
            }
            checkedDuplicates = true;
        }
        assertFalse(duplicates);
        assertTrue(checkedDuplicates);
    }

    @Test
    public void testAllGetters(){

        assertEquals( "true", latestRatesParser.getJSONSuccess());
        assertEquals("EUR",latestRatesParser.getBaseCurrency());

    }

    @Test
    public void testInvalidKey(){
        assertFalse(rateValues.containsKey("AAA"));
    }


}
