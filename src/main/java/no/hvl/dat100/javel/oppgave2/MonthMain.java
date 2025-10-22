package no.hvl.dat100.javel.oppgave2;

public class MonthMain {

    public static void main(String[] args) {

        // test data fra MonthPowerData
        double[][] power_prices_month = MonthPowerData.powerprices_month;
        double[][] power_usage_month = MonthPowerData.powerusage_month;

        System.out.println("OPPGAVE 2 - TEST AV MONTHLYPOWER");

        // a) print monthly power usage
        System.out.println("a) Månedlig strømforbruk:");
        MonthlyPower.print_PowerUsage(power_usage_month);
        System.out.println();

        // b) print monthly power prices
        System.out.println("b) Månedlige strømpriser:");
        MonthlyPower.print_PowerPrices(power_prices_month);
        System.out.println();

        // c) total monthly usage
        double totalUsage = MonthlyPower.computePowerUsage(power_usage_month);
        System.out.printf("c) Totalt månedlig strømforbruk (kWh): %.2f\n\n", totalUsage);

        // d) check threshold (for eksempel 5000 kWh)
        boolean exceeded = MonthlyPower.exceedThreshold(power_usage_month, 5000);
        System.out.printf("d) Overskrider forbruk grense 5000 kWh? %b\n\n", exceeded);

        // e) total spot price
        double spotPrice = MonthlyPower.computeSpotPrice(power_usage_month, power_prices_month);
        System.out.printf("e) Total spotpris for måneden (NOK): %.2f\n\n", spotPrice);

        // f) total power support
        double support = MonthlyPower.computePowerSupport(power_usage_month, power_prices_month);
        System.out.printf("f) Total strømstøtte for måneden (NOK): %.2f\n\n", support);

        // g) Norgespris
        double norgespris = MonthlyPower.computeNorgesPrice(power_usage_month);
        System.out.printf("g) Total Norgespris for måneden (NOK): %.2f\n", norgespris);

        System.out.println("TEST FERDIG");
    }
}
