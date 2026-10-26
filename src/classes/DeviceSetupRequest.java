package classes;

public class DeviceSetupRequest extends AbstractSupportRequest{
	private int deviceCount;
	
	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints); //handles shared request logic
		
		//deviceCount invariant
		if(deviceCount <= 0) {
			throw new IllegalArgumentException("Device count must be positive.");
		}
		this.deviceCount = deviceCount;
	}
	
	//optional getter
	public int getDeviceCount() {
        return deviceCount;
    }
	
	@Override
	public int calculatePoints() {
		return getBasePoints() * deviceCount; //resolution rule
	}
}
