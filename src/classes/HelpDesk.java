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
    
  //finds a request by its ID, returns null if not found
    public SupportRequest findRequest(int id)
    {
        return requestsById.get(id);
    }
    
  //assigns a request to a technician, throws exception if technician is null, request ID does not exist
    // Design Choice: request cannot be reassigned to the same technician
    public void assignRequest(Technician technician, int requestId)
    {
        if(technician == null)
        {
            throw new IllegalArgumentException("Must provide a valid technician.");
        }

        if(requestsById.containsKey(requestId) == false)
        {
            throw new IllegalArgumentException("Request " + requestId + " does not exist.");
        }

        List<SupportRequest> requests = assignments.get(technician);

        for(SupportRequest request : requestsById.values())
        {
            if(request.getId() == requestId)
            {
                if(requests != null && requests.contains(request))
                {
                    throw new IllegalArgumentException("Request " + requestId + " is already assigned to Technician " + technician.getName() + ".");
                }
            }
        }

        if(requests == null)
        {
            requests = new ArrayList<>();
            assignments.put(technician, requests);
        }

        requests.add(requestsById.get(requestId));
    }
    
  //resolves a request for a technician, throws exception if technician is null, request ID does not exist, or request is not assigned to the technician
    public int resolveRequest(Technician technician, int requestId)
    {
        if(technician == null)
        {
            throw new IllegalArgumentException("Must provide a valid technician.");
        }

        List<SupportRequest> requests = assignments.get(technician);

        if(requests == null)
        {
            throw new IllegalArgumentException("Request " + requestId + " is not assigned to Technician " + technician.getName() + ".");
        }

        for(SupportRequest request : requests)
        {
            if(request.getId() == requestId)
            {
                return request.resolveFor(technician);
            }
        }

        throw new IllegalArgumentException("Request " + requestId + " is not assigned to Technician " + technician.getName() + ".");

    }
}
