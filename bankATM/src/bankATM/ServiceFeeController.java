package bankATM;

public interface ServiceFeeController {

	public abstract boolean setWithdrawServiceFee(Money fee);

	public abstract boolean setTranserServiceFee(Money fee);

	public abstract boolean setDepositServiceFee(Money fee);

}
