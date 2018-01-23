package entities;

public enum Cell {
EMPTY("empty"), SHIP("ship") , SUNKEN_SHIP("sunken_ship") , ALREADY_TAKEN("already_taken");

	private String value;
	Cell(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
