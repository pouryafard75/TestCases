public class AccountManager{
    private String name;
    private double amount;
    
    void printOwing(){
        System.out.println("Details:");
        System.out.println("*****");
        System.out.println("");
        DBManager.fetchDB();
        sleep(10);
        printDetails();
    }
    void printDetails(){
        System.out.println("name: " + name);
        System.out.println("amount: " + amount);
    }
}