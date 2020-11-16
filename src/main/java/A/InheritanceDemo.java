package A;

import java.io.IOException;

public class InheritanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "childclass.txt";

		ChildClass childClass = new ChildClass();
		//childClass.setProductId(21);
		childClass.setProduct("Blog");
		childClass.setBrand("TechBeamers");

		try {
			serializalib.doSerialize(childClass, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		try {
			ChildClass newChild = (ChildClass) serializalib
					.doDeserialize(fileName);
			System.out.println("ChildClass output:  \n  |\n   --" + newChild);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

}


