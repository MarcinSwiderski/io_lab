import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

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


}
