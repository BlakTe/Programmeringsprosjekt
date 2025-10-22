package no.hvl.dat100.javel.oppgave1;

public class DayMain {

    public static void main(String[] args) {

        // test data fra DayPowerData
        double[] powerusage_day = DayPowerData.powerusage_day;

        double[] powerprices_day = DayPowerData.powerprices_day;

        System.out.println("OPPGAVE 1 - TEST AV DAILYPOWER");

        // a) print strømpriser
        System.out.println("a) Strømpriser per time:");
        DailyPower.printPowerPrices(powerprices_day);
        System.out.println();

        // b) print strømforbruk
        System.out.println("b) Strømforbruk per time:");
        DailyPower.printPowerUsage(powerusage_day);
        System.out.println();

        // c) totalt strømforbruk
        double totalUsage = DailyPower.computePowerUsage(powerusage_day);
        System.out.printf("c) Totalt strømforbruk (kWh): %.2f\n\n", totalUsage);

        // d) total spotpris uten støtte
        double spotPris = DailyPower.computeSpotPrice(powerusage_day, powerprices_day);
        System.out.printf("d) Total spotpris (NOK): %.2f\n\n", spotPris);

        // e+f) strømstøtte
        double support = DailyPower.computePowerSupport(powerusage_day, powerprices_day);
        System.out.printf("e+f) Strømstøtte for dagen (NOK): %.2f\n\n", support);

        // g) Norgespris (fastpris)
        double norgespris = DailyPower.computeNorgesPrice(powerusage_day);
        System.out.printf("g) Norgespris (NOK): %.2f\n\n", norgespris);

        // h) største timeforbruk
        double peakUsage = DailyPower.findPeakUsage(powerusage_day);
        System.out.printf("h) Største timeforbruk (kWh): %.2f\n\n", peakUsage);

        // i) gjennomsnittlig strømforbruk
        double avgUsage = DailyPower.findAvgPower(powerusage_day);
        System.out.printf("i) Gjennomsnittlig forbruk per time (kWh): %.2f\n", avgUsage);

        System.out.println("TEST FERDIG");
    }
}
