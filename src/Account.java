public class Account{
    private int id;
    private String name;
    private int balance;

    Account(int id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public String getName(){
        return name;
    }

    public int withdraw(int amount){
        if(amount>balance || amount<0){
            return 0;
        }else{
            balance -= amount;
            return amount;
        }
    }

    public void deposit(int amount) {
        if(amount<0){
            return;
        }
        balance = balance+amount;
    }
}
