package javacore.ZZIjdbc.model;

import java.util.Objects;

public class Producer {
	private Integer id;
	private String name;
	
	

	private Producer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static final class ProducerBuilder {

		private Integer id;
		private String name;

		public static ProducerBuilder builder() {
			return new ProducerBuilder();
		}

		public ProducerBuilder id(Integer id) {
			this.id = id;
			return this;
		}

		public ProducerBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public Producer build() {
			return new Producer(id,name);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producer other = (Producer) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Producer [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
