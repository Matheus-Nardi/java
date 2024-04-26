package interfaces.app;

import interfaces.models.DataLoder;
import interfaces.models.DatabaseLoader;

public class Main {

	public static void main(String[] args) {
		DatabaseLoader data = new DatabaseLoader();
		data.load();
		data.remove();
		data.checkPermission();
		DataLoder.retriveMaxDataSize();

	}

}
