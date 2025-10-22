package no.hvl.dat100.javel.oppgave4;

import no.hvl.dat100.javel.oppgave3.Customer;

public class Customers {

    private Customer[] customers;

    // a) Konstruktør
    public Customers(int size) {
        customers = new Customer[size];
    }

    // b) Telle antall kunder som ikke er null
    public int countNonNull() {
        int count = 0;
        for (Customer c : customers) {
            if (c != null) {
                count++;
            }
        }
        return count;
    }

    // c) Hente kunde etter customer_id
    public Customer getCustomer(int customer_id) {
        for (Customer c : customers) {
            if (c != null && c.getCustomer_id() == customer_id) {
                return c;
            }
        }
        return null;
    }

    // d) Sette inn kunde på første ledige plass
    public boolean addCustomer(Customer c) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] == null) {
                customers[i] = c;
                return true;
            }
        }
        return false; // ingen ledige plasser
    }

    // e) Slette kunde etter customer_id
    public Customer removeCustomer(int customer_id) {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getCustomer_id() == customer_id) {
                Customer temp = customers[i];
                customers[i] = null;
                return temp;
            }
        }
        return null; // kunde ikke finnes
    }

    // f) Hente en tabell med alle kunder (ikke-null)
    public Customer[] getCustomers() {
        int count = countNonNull();
        Customer[] activeCustomers = new Customer[count];
        int index = 0;
        for (Customer c : customers) {
            if (c != null) {
                activeCustomers[index++] = c;
            }
        }
        return activeCustomers;
    }
}
