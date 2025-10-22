package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {
        for (int i = 0; i < prices.length; i++) {
            System.out.printf("%.2f NOK ", prices[i]);
        }
        System.out.println();
    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {
        for (int i = 0; i < usage.length; i++) {
            System.out.printf("%.2f kWh ", usage[i]);
        }
        System.out.println();
    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {
        double sum = 0;
        for (int i = 0; i < usage.length; i++) {
            sum += usage[i];
        }
        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {
        double price = 0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * prices[i];
        }
        return price;
    }

    // e) constants for power support calculation
    private static final double THRESHOLD = 0.9375; // 93.75 øre
    private static final double PERCENTAGE = 0.9;   // 90%

    // e) compute power support for a given usage and price
    private static double getSupport(double usage, double price) {
        double support = 0;
        if (price > THRESHOLD) {
            // Pris over terskelverdi → får støtte for det overskytende beløpet
            double diff = price - THRESHOLD;
            support = diff * PERCENTAGE * usage;
        }
        return support;
    }

    // f) compute power support for a single day
    public static double computePowerSupport(double[] usage, double[] prices) {
        double support = 0;
        for (int i = 0; i < usage.length; i++) {
            support += getSupport(usage[i], prices[i]);
        }
        return support;
    }

    // g) constant for Norgespris (fastpris)
    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {
        double price = 0;
        for (int i = 0; i < usage.length; i++) {
            price += usage[i] * NORGESPRIS_KWH;
        }
        return price;
    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {
        double temp_max = usage[0];
        for (int i = 1; i < usage.length; i++) {
            if (usage[i] > temp_max) {
                temp_max = usage[i];
            }
        }
        return temp_max;
    }

    // i) compute average power usage for a day
    public static double findAvgPower(double[] usage) {
        double sum = computePowerUsage(usage);
        double average = sum / usage.length;
        return average;
    }
}
