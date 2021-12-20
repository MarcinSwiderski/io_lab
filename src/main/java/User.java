public abstract class User {
    protected String name;
    protected AccountType accountType;
    protected String mailAddress;

    public User(String name, AccountType typeOfUser){
        this.name = name;
        this.accountType = typeOfUser;
    }

    public void showArchiveMaps() {
        for (ArchiveData archiveData : Archive.archiveDataList) {
            System.out.println(archiveData);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", accountType=" + accountType +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }
}
