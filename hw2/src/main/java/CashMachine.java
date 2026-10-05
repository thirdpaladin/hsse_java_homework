import java.math.BigDecimal;
import java.math.RoundingMode;

public class CashMachine implements WithdrawalOperations, DepositOperations {

    @Override
    public BigDecimal deposit(Account account, BigDecimal depositSum) {
        if ((depositSum==null) || (depositSum.compareTo(new BigDecimal("0.00")) < 0)){
            System.out.println("Нельзя внести отрицательную сумму");
            return account.getBalance();
        }
        return account.balance.add(depositSum).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal withdraw(Account account, BigDecimal withdrawSum, BankType bankType) {
        if(withdrawSum.compareTo(new BigDecimal("0.00"))<0){
            System.out.println("Нельзя снять отрицательную сумму");
            return account.getBalance();
        }
        BigDecimal fullWithdrawSum = withdrawSum.add(applyCommission(withdrawSum, bankType));
        if (account.getBalance().compareTo(fullWithdrawSum)<0){
            System.out.println("Недостаточно средств");
            return account.getBalance();
        }
        return account.balance.subtract(fullWithdrawSum).setScale(2, RoundingMode.HALF_UP);
    }

}