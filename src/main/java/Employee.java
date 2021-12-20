import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Employee extends User implements IManagable {
    public Employee(String name, AccountType typeOfUser) {
        super(name, typeOfUser);
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Mark", AccountType.employee);
        employee
                .manageTaxList();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void addTaxInvoice() {
        TaxesController.taxWithSpecificTax("XD");
    }

    public boolean addTax(String taxName, Float taxPercentage) {
        return (TaxesController.createNewTaxWithSpecificTaxRate(taxName, taxPercentage))
                && (
                TaxesController
                        .archiveTransaction(
                                new ArchiveData(
                                        this.name,
                                        this.accountType,
                                        taxName,
                                        null,
                                        taxPercentage,
                                        TaxationType.TAX_ADDITION,
                                        new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())

                                )
                        ));
    }

    public boolean changeExistingTax(String taxName, Float taxPercentage) {
        if(TaxesController.taxWithSpecificTax(taxName))
        return TaxesController
                        .archiveTransaction(
                                new ArchiveData(
                                        this.name,
                                        this.accountType,
                                        taxName,
                                        TaxesController.getSpecificTaxRateByName(taxName).get(taxName),
                                        taxPercentage,
                                        TaxationType.TAX_REFACTOR,
                                        new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())
                                )
                        );
        System.out.println("W bazie nie istnieje taki podatek");
        return false;
    }

    static void showAllLogsOfCurrentUser(String clientName) {
        for (ArchiveData archiveData : Archive.getAllLogsOfSpecificUser(clientName)) {
            System.out.println(archiveData);
        }
    }

    public boolean deleteExistingTax(String taxName) {
        return (TaxesController.deleteSpecificTax(taxName))
                && (
                TaxesController
                        .archiveTransaction(
                                new ArchiveData(
                                        this.name,
                                        this.accountType,
                                        taxName,
                                        null,
                                        null,
                                        TaxationType.TAX_DELTETION,
                                        new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US).format(new Date())

                                )
                        ));
    }

    @Override
    public void manageTaxList() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter your selection:\n1 Dodaj Podatek\n2 Wyswietl Podatki \n3 Usun Podatek\n4 Wyswietl wszystkie Logi\n5 Logi Aktualnego użytkownika\n6 Zamiana wartosci istniejacego podatku");

            int choose = inp.nextInt();
            String taxName;
            switch (choose) {
                case 1:
                    System.out.println(
                            "Podaj nazwe podatku:"
                    );
                    String newTaxName = inp.next();
                    System.out.println(
                            "Podaj oprocentowanie podatku:"
                    );
                    Float taxPercentage = inp.nextFloat();
                    addTax(newTaxName, taxPercentage);
                    break;
                case 2:
                    TaxesController.showTaxList();
                    break;
                case 3:
                    System.out.println(
                            "Podaj nazwe podatku do usuniecia:"
                    );
                    String taxToDeleteTaxName = inp.next();
                    deleteExistingTax(taxToDeleteTaxName);
                    break;
                case 4:
                    System.out.println(
                            "Aktualne Logi:"
                    );
                    Archive.showArchiveData();
                    break;
                case 5:
                    System.out.println(
                            "Logi po imieniu aktualnego Pracownika:"
                    );
                    showAllLogsOfCurrentUser(this.name);
                    break;
                case 6:
                    System.out.println(
                            "Nazwa zminianego podatku:"
                    );
                    String nameOfTaxToChangeValue = inp.next();
                    System.out.println(
                            "Podaj oprocentowanie podatku:"
                    );
                    Float nameOfTaxPertangeToChange = inp.nextFloat();
                    changeExistingTax(nameOfTaxToChangeValue,nameOfTaxPertangeToChange);
                    break;
                default:
                    return;

            }
        }
    }
}
