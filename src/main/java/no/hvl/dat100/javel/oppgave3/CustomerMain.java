package no.hvl.dat100.javel.oppgave3;

public class CustomerMain {

    public static void main(String[] args) {

        // Opprett et Customer-objekt
        Customer customer1 = new Customer(1001, "Alice Smith", "alice@example.com", PowerAgreementType.SPOTPRICE);

        // Skriv ut objektet med toString
        System.out.println("Initial customer info:");
        System.out.println(customer1);
        System.out.println();

        // Test get-metoder
        System.out.println("Testing getters:");
        System.out.println("Name: " + customer1.getName());
        System.out.println("Email: " + customer1.getEmail());
        System.out.println("Customer ID: " + customer1.getCustomer_id());
        System.out.println("Agreement: " + customer1.getAgreement());
        System.out.println();

        // Test set-metoder
        customer1.setName("Alice Johnson");
        customer1.setEmail("alice.johnson@example.com");
        customer1.setCustomer_id(1002);
        customer1.setAgreement(PowerAgreementType.NORGESPRICE);

        // Skriv ut oppdatert info
        System.out.println("Updated customer info:");
        System.out.println(customer1);
    }
}
