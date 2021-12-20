public class ArchiveData {

    public String getClientName() {
        return clientName;
    }

    public float getAmmountBeforeInteracction() {
        return ammountBeforeInteracction;
    }

    public float getAmmountAfterInteracction() {
        return ammountAfterInteracction;
    }

    public TaxationType getTaxationType() {
        return taxationType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    private String clientName;
    private String taxName;
    private AccountType accountType;
    private Float ammountBeforeInteracction;
    private Float ammountAfterInteracction;
    private TaxationType taxationType;
    private String timestamp;

    ArchiveData(String clientName,AccountType accountType, String taxName, Float amountBeforeTaxation, Float amountAfterTaxation, TaxationType taxationType, String timestamp) {
        this.clientName = clientName;
        this.accountType = accountType;
        this.taxName = taxName;
        this.ammountBeforeInteracction = amountBeforeTaxation;
        this.ammountAfterInteracction = amountAfterTaxation;
        this.taxationType = taxationType;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ArchiveData{" +
                "clientName='" + clientName + '\'' +
                ", taxName='" + taxName + '\'' +
                ", accountType=" + accountType +
                ", amountBeforeTaxation=" + ammountBeforeInteracction +
                ", amountAfterTaxation=" + ammountAfterInteracction +
                ", taxationType=" + taxationType +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
