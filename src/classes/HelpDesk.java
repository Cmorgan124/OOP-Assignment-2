package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HelpDesk {
	private Map<Integer, SupportRequest> requestsById = new HashMap<>();
    private Map<Technician, List<SupportRequest>> assignments = new HashMap<>();
    
  //adds a request to the help desk, throws exception if request is null or if the request ID already exists
    public void addRequest(SupportRequest request)
    {
        if(request == null)
        {
            throw new IllegalArgumentException("Cannot add a null request.");
        }
        
        if(requestsById.containsKey(request.getId()))
        {
            throw new IllegalArgumentException("Request ID " + request.getId() + " already exists. No Duplicate IDs allowed.");
        }

        requestsById.put(request.getId(), request);

    }
}
