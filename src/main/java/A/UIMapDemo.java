package A;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UIMapDemo {

	public static void main(String[] args) {

		String fileName = "uimap.properties";
		UIMap uimap = new UIMap();
		uimap.setId(2);
		uimap.setLocator("cssSelector");
		uimap.setValue("input[id=email]");

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(uimap);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			UIMap p = (UIMap) ois.readObject();
			ois.close();
			System.out.println("UIMap Object Summary:\n  |\n   -- " + p);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
