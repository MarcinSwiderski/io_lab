import java.util.*;

interface TaxesController {
    List<Map<String, Float>> taxList = new ArrayList<>();

    static boolean doesTaxExistInTheBase(String taxName) {
        if (getSpecificTaxRateByName(taxName) != null)
            return !getSpecificTaxRateByName(taxName).isEmpty();
        return false;
    }

    private static Map<String, Float> findTuppleWithSpecificKey(String taxName) {
        return taxList
                .stream()
                .filter((x) -> x.containsKey(taxName))
                .findFirst()
                .orElse(null);
    }

    static boolean changeValueOfExistingTax(String taxName, Float newTaxRate) {
        if (findTuppleWithSpecificKey(taxName) == null)
            return false;
        else
            findTuppleWithSpecificKey(taxName).computeIfPresent(taxName, (k, v) -> v = newTaxRate);
        if (getSpecificTaxRateByName(taxName).get(taxName).equals(newTaxRate))
            return true;
        return false;
    }

    static Map<String, Float> getSpecificTaxRateByName(String taxName) {
        return taxList
                .stream()
                .filter((x) -> x.containsKey(taxName))
                .findFirst()
                .orElse(null);
    }

    static boolean createNewTaxWithSpecificTaxRate(String newTaxName, float newTaxRate) {
        Map<String, Float> temporaryMap = new HashMap<String, Float>() {
            {
                put(newTaxName, newTaxRate);
            }
        };

        boolean isThereSameNameInList = taxList
                .stream()
                .anyMatch(x -> x.containsKey(newTaxName));
        if (isThereSameNameInList == true) {
            System.out.println("Tax named like that already exists");
            return false;
        } else
            return taxList.add(temporaryMap);
    }

    static void showTaxList() {
        System.out.println(taxList);
    }

    static List<Map<String, Float>> getTaxList() {
        return taxList;
    }

    static boolean deleteSpecificTax(String taxName) {
        List<Map<String, Float>> operatedList = new ArrayList<>();
        taxList.stream()
                .filter((item) -> item.containsKey(taxName))
                .forEach(item -> {
                    operatedList.add(item);
                });
        return taxList.removeAll(operatedList);
    }

    static void deleteTaxList() {
        taxList
                .clear();
    }

    static boolean archiveTransaction(ArchiveData archiveData) {
        return Archive.addRegisterToArchiveData(archiveData);
    }
}
