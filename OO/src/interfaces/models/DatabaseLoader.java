package interfaces.models;

public class DatabaseLoader implements DataLoder, DataRemove {

	@Override
	public void load() {
		System.out.println("loading database...");

	}

	@Override
	public void remove() {
		System.out.println("remove database...");

	}

	@Override
	public void checkPermission() {
		DataLoder.super.checkPermission();
	}
	
}
