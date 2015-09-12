package unit;

import java.util.Map;

public class Unit {
	
	private String type;
	private Map properties;
	
	public Unit(String type, Map properties) {
		this.type = type;
		this.properties = properties;
	}
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public Map getProperties() {
		return properties;
	}
	
	public void setProperties(Map properties) {
		this.properties = properties;
	}

	
	
	
}
