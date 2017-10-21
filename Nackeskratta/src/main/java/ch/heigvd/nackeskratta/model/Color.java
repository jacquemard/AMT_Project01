package ch.heigvd.nackeskratta.model;

public enum Color {
	BLACK("Black"), BROWN("Brown"), RED("Red");

	private final String name;

	Color(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
