package classes;
import java.util.ArrayList;
import java.util.List;

import classes.request.*;

public class Main {
		public static void main(String[] args) {
		System.out.println("CS_3330 Assignment 2");
		System.out.println();
		final int basePoints = 5; // immutable base points to standardize support request rewards
		HelpDesk helpDesk = new HelpDesk();
		
		// Create at least 3 technicians, including two technicians with the same name to demonstrate HashSet<Technician> behavior.
		Technician network_technician = new Technician("Elrond");
		Technician device_technician = new Technician("Beorn");
		Technician password_technician = new Technician("Elrond");
		
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
		helpDesk.assignRequest(network_technician, 1);
		helpDesk.assignRequest(device_technician, 3);
		helpDesk.assignRequest(password_technician, 5);
		helpDesk.assignRequest(network_technician, 6);
		
		// Resolve at least 3 requests across different request types.
		helpDesk.resolveRequest(network_technician, 1);
		helpDesk.resolveRequest(password_technician, 5);
		helpDesk.resolveRequest(device_technician, 3);
		
		// Print all requests.
		System.out.println("Printing all requests");
		helpDesk.printAllRequests();
		System.out.println();
		
		// Print assignments for each technician.
		System.out.println("Printing assignments for each technician");
		System.out.println(network_technician.getName());
		helpDesk.printAssignmentsFor(network_technician);
		System.out.println(device_technician.getName());
		helpDesk.printAssignmentsFor(device_technician);
		System.out.println(password_technician.getName() + "(2)"); // even though it is saved as technician 3, 
		helpDesk.printAssignmentsFor(password_technician);
		System.out.println();

		// Print final technician service point totals.
			// Use HelpDeskUtil.sumPoints to print the total service points across technicians.
		System.out.println("Final technician service point totals");
		network_technician.toString();
		device_technician.toString();
		password_technician.toString();
		System.out.println("Cumulative total points");
		List<Technician>  technicians = new ArrayList<>();
		technicians.add(network_technician);
		technicians.add(password_technician);
		technicians.add(device_technician);
		System.out.println(HelpDeskUtil.sumPoints(technicians));
		System.out.println();
		
		// Fail-fast demonstration
		System.out.println("Trying to resolve a request that has already been resolved");
		helpDesk.resolveRequest(network_technician, 1);
		}
}