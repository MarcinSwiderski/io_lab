import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    public void taxCreation() {

        Employee employee = new Employee(
                "Marcin",
                AccountType.employee
        );
        System.out.println("Adding new Taxes");
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax1",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax2",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax3",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax4",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax5",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marcin_added_tax6",
                                0.23f));
        System.out.println("Stan Listy \"Po\":");
        TaxesController
                .showTaxList();
        System.out.println("Logi:");
        Archive
                .showArchiveData();
    }

    @Test
    public void changingExistingTaxes() {
        Employee employee = new Employee(
                "Zosia",
                AccountType.employee
        );
        assertTrue(
                employee
                        .addTax(
                                "Zosia_added_tax1",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Zosia_added_tax2",
                                0.25f));
        assertTrue(
                employee
                        .addTax(
                                "Zosia_added_tax3",
                                0.28f));

        TaxesController
                .showTaxList();
        System.out.println("Changing values of recemtly added taxes");
        assertTrue(
                employee
                        .changeExistingTax(
                                "Zosia_added_tax1",
                                0.44f
                        )
        );
        assertFalse(
                employee
                        .changeExistingTax(
                                "Zosia_not_existing_tax",
                                0.44f
                        )
        );
        System.out.println("Stan Listy \"Po\":");
        TaxesController
                .showTaxList();
        System.out.println("Logi:");
        Archive
                .showArchiveData();
    }


    @Test
    public void deletingOneOfTheTaxes() {
        Employee employee = new Employee(
                "Marta",
                AccountType.employee
        );
        assertTrue(
                employee
                        .addTax(
                                "Marta_added_tax1",
                                0.23f));
        assertTrue(
                employee
                        .addTax(
                                "Marta_added_tax2",
                                0.25f));
        assertTrue(
                employee
                        .addTax(
                                "Marta_added_tax3",
                                0.28f));

        System.out.println("deleting employee_added_tax4");
        assertTrue(
                employee
                        .deleteExistingTax(
                                "Marta_added_tax2"));
        System.out.println("Stan Listy \"Po\":");
        TaxesController
                .showTaxList();
        System.out.println("Logi:");
        Archive
                .showArchiveData();
    }
    @Test
    public void deletingAllTaxes(){
        TaxesController
                .showTaxList();
        TaxesController
                .deleteTaxList();
        TaxesController
                .showTaxList();
    }
}