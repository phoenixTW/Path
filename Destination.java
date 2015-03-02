public class Destination {
	private String place;

	Destination(String placeName) {
		this.place = placeName;
	}

	public String getName () {
		return this.place;
	}

	public boolean equals (Object o) {
		if(o==null) return false;
		if(getClass() != o.getClass()) return false;
		if(place == null) return false;
		return place.equals(((Destination) o).place);
	}
}