package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave1.DailyPower;
import no.hvl.dat100.javel.oppgave2.MonthlyPower;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class Invoice {

    private Customer c;          // kunde tilknyttet faktura
    private String month;        // måned fakturaen gjelder for
    private double[][] usage;    // strømforbruk per dag og time
    private double[][] prices;   // strømpriser per dag og time
    private double amount;       // total beløp

    // a) Konstruktør
    public Invoice(Customer c, String month, double[][] usage, double[][] prices) {
        this.c = c;
        this.month = month;
        this.usage = usage;
        this.prices = prices;
        this.amount = 0; // startverdi
    }

    // b) Beregne strømpris basert på avtale
    public void computeAmount() {
        if (c.getAgreement() == PowerAgreementType.SPOTPRICE) {
            this.amount = MonthlyPower.computeSpotPrice(usage, prices);
        } else if (c.getAgreement() == PowerAgreementType.POWERSUPPORT) {
            this.amount = MonthlyPower.computePowerSupport(usage, prices);
        } else if (c.getAgreement() == PowerAgreementType.NORGESPRICE) {
            this.amount = MonthlyPower.computeNorgesPrice(usage);
        } else {
            this.amount = 0;
        }
    }

    // c) Generere faktura
    public void printInvoice() {
        double totalUsage = MonthlyPower.computePowerUsage(usage);
        System.out.println("========================");
        System.out.println("Customer number " + c.getCustomer_id());
        System.out.println("Name  " + c.getName());
        System.out.println("Email " + c.getEmail());
        System.out.println("Agreement " + c.getAgreement());
        System.out.println("\nMonth: " + month);
        System.out.printf("Usage:      %.2f kWh\n", totalUsage);
        System.out.printf("Amount:    %.2f NOK\n", amount);
        System.out.println("========================\n");
    }
}
