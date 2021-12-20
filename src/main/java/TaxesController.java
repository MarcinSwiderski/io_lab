import java.util.*;
import java.util.stream.Collectors;

public class TaxesController {
    private static List<Map<String, Float>> taxList = new ArrayList<>();

    static boolean taxWithSpecificTax(String taxName) {
        if(getSpecificTaxRateByName(taxName) != null)
            return !getSpecificTaxRateByName(taxName).isEmpty();
        return false;
    }

//    private static List<Map<String, Integer>> findMatchingTaxByTaxName(String taxName) {
//        return taxList
//                .stream()
//                .filter((x) -> x.containsKey(taxName))
//                .findFirst()
//                .stream()
//                .collect(
//                        Collectors.toList()
//                );
//    }

    public static Map<String, Float> getSpecificTaxRateByName(String taxName) {
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
        if (isThereSameNameInList == true)
            return false;
        else
            return taxList.add(temporaryMap);
    }

    static void showTaxList() {
        System.out.println(taxList);
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
