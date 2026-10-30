package classes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import classes.request.*;

public class Main {
		public static void main(String[] args) {
		System.out.println("CS_3330 Assignment 2");
		System.out.println();
		final int basePoints = 5; // immutable base points to standardize support request rewards
		HelpDesk helpDesk = new HelpDesk();
		
		// Create at least 3 technicians, including two technicians with the same name to demonstrate HashSet<Technician> behavior.
		Technician technician_1 = new Technician("Elrond");
		Technician technician_2 = new Technician("Beorn");
		Technician duplicate_technician_1 = new Technician("Elrond");
		Set<Technician> technicianSet = new HashSet<>();
		technicianSet.add(technician_1);
		technicianSet.add(technician_2);
		technicianSet.add(duplicate_technician_1); // hash and equals should reject
		System.out.println("Number of technicians: " + technicianSet.size());
		System.out.println();
		
		// Create at least 6 support requests total, including at least 2 of each required request type.
		SupportRequest request_1 = new NetworkIssueRequest(1, "Network Issue 1", basePoints, 1);
		SupportRequest request_2 = new NetworkIssueRequest(2, "Network Issue 2", basePoints, 2);
		SupportRequest request_3 = new DeviceSetupRequest(3, "Device Setup 1", basePoints, 1);
		SupportRequest request_4 = new DeviceSetupRequest(4, "Device Setup 2", basePoints, 2);
		SupportRequest request_5 = new PasswordResetRequest(5, "Password Reset 1", basePoints, "Smaug");
		SupportRequest request_6 = new PasswordResetRequest(6, "Password Reset 2", basePoints, "Thorin");
		
		// Add requests to the help desk.
		helpDesk.addRequest(request_1);
		helpDesk.addRequest(request_2);
		helpDesk.addRequest(request_3);
		helpDesk.addRequest(request_4);
		helpDesk.addRequest(request_5);
		helpDesk.addRequest(request_6);
		
		// Assign at least 4 requests across at least 2 technicians.
		helpDesk.assignRequest(technician_1, 1);
		helpDesk.assignRequest(technician_2, 3);
		helpDesk.assignRequest(technician_2, 5);
		helpDesk.assignRequest(technician_1, 6);
		
		// Resolve at least 3 requests across different request types.
		helpDesk.resolveRequest(technician_1, 1);
		helpDesk.resolveRequest(technician_2, 5);
		helpDesk.resolveRequest(technician_2, 3);
		
		// Print all requests.
		System.out.println("Printing all requests");
		helpDesk.printAllRequests();
		System.out.println();
		
		// Print assignments for each technician.
		System.out.println("Printing assignments for each technician");
		for (Technician technician : technicianSet) {
			System.out.println(technician.getName() + ":");
            helpDesk.printAssignmentsFor(technician);
		}
		System.out.println();

		// Print final technician service point totals.
			// Use HelpDeskUtil.sumPoints to print the total service points across technicians.
		List<Technician>  technicians = new ArrayList<>(technicianSet);
		System.out.println("Final technician service point totals");
		HelpDeskUtil.printAll(technicians);
		System.out.println();
		System.out.println("Cumulative total points");
		System.out.println(HelpDeskUtil.sumPoints(technicians));
		System.out.println();
		
		// Fail-fast demonstration
		System.out.println("Trying to resolve a request that has already been resolved:");
		try {
		    helpDesk.resolveRequest(technician_1, 1);
		} catch (IllegalStateException e) {
		    System.out.println("Caught expected fail-fast exception: " + e.getMessage());
		}
		
		}
}