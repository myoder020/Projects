package board;

import java.util.ArrayList;
import java.util.List;

import unit.Unit;

public class Tile {
	private List<Unit> units;
	
	public Tile() {
		units = new ArrayList<Unit>();
	}
	
	public void setUnits(Unit units) {
		this.units.add(units);
	}
	
	public List<Unit> getUnits() {
		return this.units;
	}
	
}
