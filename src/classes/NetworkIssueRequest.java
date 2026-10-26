package classes;

public class NetworkIssueRequest extends AbstractSupportRequest{
	private int affectedUsers;
	
	public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
		super(id, title, basePoints); //handles shared request logic
		
		//affectedUsers invariant
		if(affectedUsers <= 0) {
			throw new IllegalArgumentException("Affected users must be positive.");
		}
		this.affectedUsers = affectedUsers;
	}
	
	//optional getter
	public int getAffectedUsers() {
        return affectedUsers;
    }
	
	@Override
	public int calculatePoints() {
		return getBasePoints() * (affectedUsers * 2); //resolution weighted rule
	}
}
