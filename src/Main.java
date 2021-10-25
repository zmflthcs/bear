import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(1);
        Cashbin cashbin = new Cashbin(100000, 300000);
        Atm atm = new Atm(cashbin, 1000, 1000);
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("press 1 to insert a card");
            int getCard = sc.nextInt();
            if(getCard==1){
                atm.insertCard(card);
                System.out.println("Enter your PIN number");
                String pinNumber = sc.next();
                if(atm.getPin(pinNumber)){
                    //when pin number is right
                    Account[] accountList = atm.getAccountList(); // call account list from that card
                    int accountNumber = 0;
                    while(accountNumber != -1) {
                        System.out.println("Insert number of account you want to select (-1 for exit)");
                        for(int i=0;i<accountList.length;i++){
                            System.out.println(i+". "+ accountList[i].getName());
                        }
                        accountNumber = sc.nextInt();
                        if(accountNumber>=0 && accountNumber<accountList.length){
                            System.out.println("Select option you want. 1.check balance 2.deposit 3. withdraw");
                            int option=sc.nextInt();
                            if(option==1){
                                System.out.println("you have "+ accountList[accountNumber].getBalance());
                            }else if(option==2){
                                System.out.println("Enter amount you want to deposit");
                                int amount = sc.nextInt();
                                Boolean depositSuccess=atm.deposit(accountList[accountNumber], amount);
                                if(depositSuccess){
                                    System.out.println("Deposit succeed");
                                    atm.displayBalance(accountList[accountNumber]);
                                }else{
                                    System.out.println("Deposit failed");
                                }
                            }else if(option==3){
                                System.out.println("Enter amount you want to withdraw");
                                int amount = sc.nextInt();
                                Boolean withdrawSuccess=atm.withdraw(accountList[accountNumber], amount);
                                if(withdrawSuccess){
                                    System.out.println("take your money "+amount);
                                    atm.displayBalance(accountList[accountNumber]);
                                }else{
                                    System.out.println("Withdraw failed");
                                }
                            }
                        }else if(accountNumber==-1){
                            System.out.println("Please take your card");
                            atm.removeCard();
                            break;
                        }else{
                            System.out.println("Wrong input!");
                        }
                    }
                }else {
                    //when pin number is wrong;
                    System.out.println("Please take your card");
                    atm.removeCard();
                }
            }else{
                //when user didn't insert a card;
                System.out.println("wrong input!");
            }
        }


    }
}
