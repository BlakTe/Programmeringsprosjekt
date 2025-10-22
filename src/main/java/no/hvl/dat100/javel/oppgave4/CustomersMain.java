package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;
import no.hvl.dat100.javel.oppgave3.PowerAgreementType;

public class CustomersMain {

    public static void main(String[] args) {

        System.out.println("==============");
        System.out.println("OPPGAVE 4 - TEST AV CUSTOMERS");
        System.out.println("==============\n");

        // Opprett Customers tabell med plass til 5 kunder
        Customers customers = new Customers(5);

        // Opprett Customer-objekter
        Customer c1 = new Customer(1001, "Alice Smith", "alice@example.com", PowerAgreementType.SPOTPRICE);
        Customer c2 = new Customer(1002, "Bob Johnson", "bob@example.com", PowerAgreementType.NORGESPRICE);
        Customer c3 = new Customer(1003, "Charlie Rose", "charlie@example.com", PowerAgreementType.POWERSUPPORT);
        Customer c4 = new Customer(1004, "Diana Prince", "diana@example.com", PowerAgreementType.NORGESPRICE);
        Customer c5 = new Customer(1005, "Ethan Hunt", "ethan@example.com", PowerAgreementType.POWERSUPPORT);

        // Legg til kunder
        customers.addCustomer(c1);
        customers.addCustomer(c2);
        customers.addCustomer(c3);
        customers.addCustomer(c4);
        customers.addCustomer(c5);

        System.out.println("Totalt antall kunder: " + customers.countNonNull() + "\n");

        // Hent og skriv ut en kunde
        Customer hentet = customers.getCustomer(1003);
        System.out.println("Hentet kunde med ID 1003:");
        System.out.println(hentet + "\n");

        // Slett en kunde
        Customer fjernet = customers.removeCustomer(1002);
        System.out.println("Fjernet kunde med ID 1002:");
        System.out.println(fjernet + "\n");

        // Antall kunder etter sletting
        System.out.println("Totalt antall kunder etter sletting: " + customers.countNonNull() + "\n");

        // Hent tabell med alle aktive kunder
        Customer[] aktiveKunder = customers.getCustomers();
        System.out.println("Liste over aktive kunder:");
        for (Customer c : aktiveKunder) {
            System.out.println(c);
            System.out.println();
        }

        // Test legg til kunde etter sletting
        Customer c6 = new Customer(1006, "Fiona Gallagher", "fiona@example.com", PowerAgreementType.SPOTPRICE);
        boolean lagtTil = customers.addCustomer(c6);
        System.out.println("Lagt til ny kunde (ID 1006)? " + lagtTil + "\n");

        // Skriv ut alle kunder igjen
        aktiveKunder = customers.getCustomers();
        System.out.println("Oppdatert liste over aktive kunder:");
        for (Customer c : aktiveKunder) {
            System.out.println(c);
            System.out.println();
        }
    }
}
