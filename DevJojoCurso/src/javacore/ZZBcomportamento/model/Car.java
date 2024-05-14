package javacore.ZZBcomportamento.model;

public class Car {
	private String name = "Audi";
	private String color;
	private Integer year;

	public Car(String color, Integer year) {
		super();
		this.color = color;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", year=" + year + "]";
	}
	
	

}
