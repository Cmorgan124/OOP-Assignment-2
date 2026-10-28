package classes;

public abstract class AbstractSupportRequest implements SupportRequest {
	private final int id;
	private final String title;
	private final int basePoints;
	private boolean resolved;
	
	public AbstractSupportRequest(int id, String title, int basePoints) {
		// Checks for invariant violations
		if (id <= 0) throw new IllegalArgumentException("Invalid Request ID; must be greater than 0");
		if (title == null || title.isBlank()) throw new IllegalArgumentException("Invalid Request Name; cannot be blank or null");
		if (basePoints <= 0) throw new IllegalArgumentException("Invalid base points; must be greater than 0");
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = false;
	}
	
	// DESIGN CHOICE: A request cannot be resolved more than once, throws an error
	protected void markResolved() {
		if (isResolved()) throw new IllegalStateException("Invalid operation; request has already been resolved");
		resolved = true;
	}
	
	// Common getters
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public int getBasePoints() {
		return basePoints;
	}
	
	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	// Useful toString
	@Override
	public String toString() {
		return "Support Request ID: " + id + ", Title: " + title + ", Base Points: " + basePoints + ", Resolved: " + resolved;
	}
}
