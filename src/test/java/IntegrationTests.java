import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import javax.swing.event.CaretListener;

import java.sql.ClientInfoStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntegrationTests {

    @Test
    public void test() {
        //given
        Customer client = new Customer("piotr", AccountType.client, 4500f);
        Employee employee = new Employee("Jakub", AccountType.employee);
        //when
        assertTrue(
                employee
                        .addTax(
                                "Jakub_added_tax1",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Jakub_added_tax2",
                                0.30f));
        assertTrue(
                employee
                        .addTax(
                                "Jakub_added_tax3",
                                0.45f));
        assertTrue(
                client
                        .addTaxToInvoice(
                                "Jakub_added_tax1"
                        ));
        assertTrue(
                client
                        .addTaxToInvoice(
                                "Jakub_added_tax2"
                        ));

        System.out.println(client
                .salaryAfterTaxes());
        Archive
                .showArchiveData();

    }

    @Test
    public void testowanieOpodatkowania() {
        Employee employee = new Employee(
                "Jarek",
                AccountType.employee
        );
        Customer customer = new Customer(
                "Marek",
                AccountType.client,
                4000f
        );
        assertTrue(employee.addTax(
                "randomTaxName",
                0.05f
        ));
        assertTrue(employee.addTax(
                "randomTaxName2",
                0.10f
        ));
        assertTrue(employee.addTax(
                "randomTaxName3",
                0.20f
        ));


        assertTrue(customer.addTaxToInvoice(
                "randomTaxName2"
        ));

        Assertions.assertEquals((float) customer
                        .salaryAfterTaxes(),
                3600f
        );

        customer
                .addTaxToInvoice(
                        "randomTaxName"
                );

        Assertions.assertEquals((float) customer
                        .salaryAfterTaxes(),
                3400f
        );

    }
}
