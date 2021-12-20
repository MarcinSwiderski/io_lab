public class Customer extends User implements ITaxable{

    public Customer(String name, AccountType typeOfUser) {
        super(name, typeOfUser);
    }

    @Override
    public void startTaxingSequence() {
        TaxesController.archiveTransaction(null);
    }

    public void addTransaction() {
//        TaxesController.taxClientWithSpecificRate();
        TaxesController.archiveTransaction(null);
    }

    @Override
    public void showStatusOfTransaction() {

    }
}
