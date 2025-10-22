package no.hvl.dat100.javel.oppgave5;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;
import no.hvl.dat100.javel.oppgave2.MonthPowerData;

public class InvoiceMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 5 - TEST AV FAKTURAER");
        System.out.println("==============\n");

        // Opprett noen Customer-objekter
        Customer c1 = new Customer(1003, "Charlie Rose", "charlie@example.com", PowerAgreementType.POWERSUPPORT);
        Customer c2 = new Customer(1004, "Diana Prince", "diana@example.com", PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer(1005, "Ethan Hunt", "ethan@example.com", PowerAgreementType.SPOTPRICE);

        // Hent testdata for strømbruk og priser for måneden
        double[][] usage_month = MonthPowerData.powerusage_month;
        double[][] prices_month = MonthPowerData.powerprices_month;

        // Opprett Invoice-objekter for hver kunde
        Invoice inv1 = new Invoice(c1, "January", usage_month, prices_month);
        Invoice inv2 = new Invoice(c2, "January", usage_month, prices_month);
        Invoice inv3 = new Invoice(c3, "January", usage_month, prices_month);

        // Lag en tabell med fakturaene
        Invoice[] invoices = {inv1, inv2, inv3};

        // Prosesser og skriv ut alle fakturaer
        Invoices.processInvoices(invoices);
    }
}
