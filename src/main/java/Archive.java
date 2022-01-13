import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Archive {
    static List<ArchiveData> archiveDataList = new LinkedList<>();

    static boolean addRegisterToArchiveData(ArchiveData archiveData) throws IllegalArgumentException {
        try {
            return archiveDataList.add(archiveData);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Nie udalo sie dodac rejestru do listy w archiwum");
        }
    }

    static void showArchiveData() {
        for (ArchiveData archiveLog : archiveDataList
        ) {
            System.out.println(archiveLog);
        }
    }


    public static List<ArchiveData> getAllLogsOfSpecificUser(String clientName) {
        return archiveDataList
                .stream()
                .filter((x) -> x.getClientName().equals(clientName))
                .collect(
                        Collectors.toList()
                );
    }
}
