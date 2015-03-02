public class Source {
	private String place;

	Source(String placeName) {
		this.place = placeName;
	}

	public String getName () {
		return this.place;
	}

	public boolean equals (Object o) {
		if(o==null) return false;
		if(getClass() != o.getClass()) return false;
		if(place == null) return false;
		return place.equals(((Source) o).place);
	}

	public int hashCode() {
		return place.hashCode();
	}
}