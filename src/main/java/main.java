public class main {
    public static void main(String[] args) {
        FixerLatestRatesParser latestRatesParser = new FixerLatestRatesParser();
        System.out.println(latestRatesParser.getAllRates());
    }
}
