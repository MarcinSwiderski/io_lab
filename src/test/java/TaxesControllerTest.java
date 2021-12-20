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

        TaxesController.createNewTaxWithSpecificTaxRate("xD", 0.23f);

        TaxesController.showTaxList();

        assertFalse(TaxesController.createNewTaxWithSpecificTaxRate("xD", 0.51f));

        TaxesController.deleteTaxList();
    }

    @Test
    public void getTaxByName() {

        TaxesController.createNewTaxWithSpecificTaxRate("xDDD", 0.31f);

        TaxesController.showTaxList();

        assertTrue(TaxesController.doesTaxExistInTheBase("xDDD"));
        assertFalse(TaxesController.doesTaxExistInTheBase("xD"));

        TaxesController.deleteTaxList();
    }

    @Test
    public void checkingArciveTransaction() {
        assertTrue(TaxesController
                .archiveTransaction(
                        new ArchiveData(
                                "tom",
                                AccountType.client,
                                "tax_xd1",
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
                                "tax_xd2",
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
                                "tax_xd3",
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
                                "tax_xd4",
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