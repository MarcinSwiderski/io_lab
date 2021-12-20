import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Customer extends User implements ITaxable, TaxesController {

    private float salary;

    private List<Float> choosenTaxes = new ArrayList<>();

    public Customer(String name, AccountType typeOfUser) {
        super(name, typeOfUser);
    }
    public Customer(String name, AccountType typeOfUser, Float salary) {
        super(name, typeOfUser);
        this.salary = salary;
    }

    public static void main(String[] args) {
        Customer customer = new Customer(
                "jasiek",
                AccountType.client
        );
        customer
                .menu();
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public void startTaxingSequence() {
        TaxesController.archiveTransaction(null);
    }

    public void addTransaction() {
        TaxesController.archiveTransaction(null);
    }

    @Override
    public void showStatusOfTransaction() {

    }

    public boolean addTaxToInvoice(String taxName) {
        if(TaxesController.doesTaxExistInTheBase(taxName))
        return choosenTaxes
                .add(
                        TaxesController
                                .getSpecificTaxRateByName(taxName).get(taxName)
                );
        else
            System.out.println("Tax doesn't exist in the scope");
            return false;
    }

    public Float salaryAfterTaxes() {
        Float var = this.salary;
        for (Float choosenTax : choosenTaxes) {
                       var -=  choosenTax*this.salary;
        }
        return var;
    }

    public void menu() {
        Scanner inp = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "Enter your selection:\n1 Wpisz swoje wynagrodzenie\n2 Wyswietl Podatki \n3 Wyświetl Wynik");


            System.out.println("\n\n" + "Wpisana przez ciebie kwota: " + salary + "\n\n");
            System.out.println("Wybrane podatki:\n"+ choosenTaxes);
            System.out.println("Kwota po opodatkowaniu: "+ salaryAfterTaxes());
            int choose = inp.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(
                            "Podaj swoje wynagrodzenie:"
                    );
                    Float yourSalary = inp.nextFloat();
                    setSalary(yourSalary);
                    break;
                case 2:
                    TaxesController.showTaxList();
                    break;
                case 3:
                    System.out.println(
                            "Podaj nazwe podatku który ciebie interesuje:"
                    );
                    String taxToDeleteTaxName = inp.next();
                    addTaxToInvoice(taxToDeleteTaxName);
                    break;

                default:
                    return;

            }
        }
    }


}
