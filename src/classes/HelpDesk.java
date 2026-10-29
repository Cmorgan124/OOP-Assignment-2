package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelpDesk {
	private Map<Integer, SupportRequest> requestsById = new HashMap<>();
    private Map<Technician, List<SupportRequest>> assignments = new HashMap<>();
}
