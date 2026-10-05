import java.math.BigDecimal;
import java.math.RoundingMode;

public interface WithdrawalOperations {
    public BigDecimal withdraw(Account account, BigDecimal withdrawSum, BankType bankType);

    public default BigDecimal applyCommission(BigDecimal withdrawSum, BankType bankType){
        if ((withdrawSum == null) || (bankType == null)){
            return new BigDecimal("0.00");
        }
        return withdrawSum.multiply(bankType.getComission()).setScale(2, RoundingMode.HALF_UP);
    }
}