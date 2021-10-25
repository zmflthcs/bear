import java.util.Scanner;

public class Atm {
    private Card card;
    private Cashbin cashbin;
    private int maxWithdrawPerTime;
    private int maxDepositPerTime;

    public Atm(Cashbin cashbin, int maxWithdrawPerTime, int maxDepositPerTime){
        this.cashbin = cashbin;
        this.maxWithdrawPerTime = maxWithdrawPerTime;
        this.maxDepositPerTime = maxDepositPerTime;
    }

    public void insertCard(Card card){
        this.card = card;
    }

    public void removeCard(){
        this.card = null;
    }


    public Boolean withdraw(Account account,int amount) {
        if(this.maxWithdrawPerTime<=amount){
            System.out.println("Cannot withdraw more than "+this.maxWithdrawPerTime);
            return false;
        }else if(this.cashbin.getBalance()<amount){
            System.out.println("ATM doesn't have enough money");
            return false;
        }else if(account.getBalance()<amount){
            System.out.println("not enough balance");
            System.out.println("you have $"+account.getBalance());
            return false;
        }else if(amount<=0){
            System.out.println("Amount should be bigger than 0");
            return false;
        } else{
            account.withdraw(amount);
            this.cashbin.withdraw(amount);
            return true;
        }
    }

    public Boolean deposit(Account account, int amount){
        if(this.maxDepositPerTime<amount){
            System.out.println("Cannot deposit more than "+this.maxDepositPerTime);
            return false;
        }else if(this.cashbin.getMaxBalance()<this.cashbin.getBalance()+amount){
            System.out.println("ATM is full");
            return false;
        }else if(amount<=0){
            System.out.println("Amount should be bigger than 0");
            return false;
        } else{
            account.deposit(amount);
            this.cashbin.deposit(amount);
            return true;
        }
    }

    public Boolean getPin(String pinNumber){
        if(pinNumber.length()!=4){
            System.out.println("PIN number should be 4 digit");
            return false;
        }
        // if typed pin isn't number, then
        for (int i = 0; i < pinNumber.length(); i++) {
            if (!Character.isDigit(pinNumber.charAt(i))) {
                System.out.println("PIN suppose to be all number");
                return false;
            }
        }
        return true;
    }
    public void displayBalance(Account account){
        System.out.println("Your account has "+account.getBalance());
    }


    //fetch account list by using PIN  and card id
    public Account[] getAccountList(){
        Account[] accountList = new Account[3];
        accountList[0] = new Account(0,"NH",1000000 );
        accountList[1] = new Account(1, "KM",1000);
        accountList[2] = new Account(2, "SH",200000);
        return accountList;
    }




}