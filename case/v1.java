public class AccountManager{
    private String name;
    private double amount;
    private int age;
    
    void printOwing(){
        System.out.println("Details:");
        System.out.println("-----");
        System.out.println("");
        DBManager.fetchDB();
        sleep(10);

        System.out.println("name: " + name);
        System.out.println("amount: " + amount);
    }
}