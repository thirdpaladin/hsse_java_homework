import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static Account account = new Account(12345, 999, new BigDecimal("10000.00"), BankType.AUM);
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Здравствуйте!\nВведите номер карты и пин через пробел: ");
        try {
            if (!(scan.hasNextInt() && (scan.nextInt() == account.getCardId()) &&
                    scan.hasNextInt() && (scan.nextInt() == account.getPin()))) {
                System.out.println("Ошибка");
                return;
            }

            CashMachine cashMachine = new CashMachine();
            System.out.println("Текущий баланс: " + account.getBalance());
            System.out.print("Введите через пробел название операции и сумму в формате [снять/внести] [сумма]: ");
            if (!scan.hasNext()){
                System.out.println("Ошибка");
                return;
            }
            switch (scan.next()){
                case "снять":
                    if (scan.hasNextBigDecimal()){
                        ;
                        System.out.println("Новый баланс: " + cashMachine.withdraw(account, scan.nextBigDecimal(), account.getBankType()));
                    } else{
                        System.out.println("Ошибка");
                    }
                    break;
                case "внести":
                    if (scan.hasNextBigDecimal()){
                        System.out.println("Новый баланс: " + cashMachine.deposit(account, scan.nextBigDecimal()));
                    } else {
                        System.out.println("Ошибка");
                    }
                    break;
                default:
                    System.out.println("Ошибка");
            }

        } catch (Exception e){
            System.out.println("Ошибка");
        }
    }
}