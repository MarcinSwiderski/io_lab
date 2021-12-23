import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaxesControllerTest {

    //Happy Paths
    @Test
    public void newTaxCreation() {

        TaxesController.createNewTaxWithSpecificTaxRate("new_tax", 0.23f);

        TaxesController.showTaxList();

        assertFalse(TaxesController.createNewTaxWithSpecificTaxRate("new_tax2", 0.51f));

        TaxesController.deleteTaxList();
    }

    @Test
    public void getTaxByName() {

        TaxesController.createNewTaxWithSpecificTaxRate("new_tax", 0.31f);

        TaxesController.showTaxList();

        assertTrue(TaxesController.doesTaxExistInTheBase("new_tax"));
        assertFalse(TaxesController.doesTaxExistInTheBase("new_tax2"));

        TaxesController.deleteTaxList();
    }

    @Test
    public void checkingArciveTransaction() {
        assertTrue(TaxesController
                .archiveTransaction(
                        new ArchiveData(
                                "tom",
                                AccountType.client,
                                "tax_example1",
                                null,
                                0.50f,
                                TaxationType.TAX_ADDITION,
                                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())
                        )
                ));
        assertTrue(TaxesController
                .archiveTransaction(
                        new ArchiveData(
                                "bob",
                                AccountType.client,
                                "tax_example2",
                                0f,
                                0.01f,
                                TaxationType.TAX_ADDITION,
                                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())
                        )
                ));
        assertTrue(TaxesController
                .archiveTransaction(
                        new ArchiveData(
                                "caroline",
                                AccountType.employee,
                                "tax_example3",
                                0f,
                                0.22f,
                                TaxationType.TAX_ADDITION,
                                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())
                        )
                ));
        assertTrue(TaxesController
                .archiveTransaction(
                        new ArchiveData(
                                "caroline",
                                AccountType.client,
                                "tax_example4",
                                23f,
                                0.22f,
                                TaxationType.TAX_ADDITION,
                                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())
                        )
                ));
        System.out.println("All stored data:");
        Archive.showArchiveData();
        System.out.println("Registers Found By tom:");
        System.out.println(Archive.getAllLogsOfSpecificUser("tom"));
        System.out.println("Registers Found By bob:");
        System.out.println(Archive.getAllLogsOfSpecificUser("bob"));
        System.out.println("Registers Found By caroline:");
        System.out.println(Archive.getAllLogsOfSpecificUser("caroline"));

    }
}