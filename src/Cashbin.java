public class Cashbin {
    private int balance;
    private int maxBalance;

    public Cashbin(int balance, int maxBalance){
        this.balance = balance;
        this.maxBalance=maxBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public long getMaxBalance() {
        return maxBalance;
    }



    public int withdraw(int amount){
        if(balance>=amount){
            balance = balance-amount;
            return amount;
        }else{
            return 0;
        }
    }

    public int deposit(int amount){
        if(amount+balance>maxBalance){
            return amount;
        }else{
            balance+=amount;
            return 0;
        }
    }


}
