package classes;

public class PasswordResetRequest extends AbstractSupportRequest{
	private String accountName;
	
	public PasswordResetRequest(int id, String title, int basePoints, String accountName) {
		super(id, title, basePoints); //handles shared request logic
		
		//accountName invariant
		if(accountName == null || accountName.isBlank()) {
			throw new IllegalArgumentException("Account name cannot be null or blank.");
		}
		this.accountName = accountName;
	}
	
	//optional getter
	public String getAccountName() {
        return accountName;
    }
	
	@Override
	public int calculatePoints() {
		return getBasePoints(); //resolution rule
	}
}
