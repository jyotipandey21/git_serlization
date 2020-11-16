package A;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ChildClass extends Parent implements Serializable, ObjectInputValidation {

	private String Brand;

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		this.Brand = brand;
	}

	@Override
	public String toString() {
		return "Summary[ ProductId=" + getProductId() + ", Product=" + getProduct() + ", Brand=" + getBrand() + " ]";
	}

// adding helper method for serialization to save/initialize parent class
// state
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		ois.defaultReadObject();

// notice the order of read and write should be same
		//setProductId(ois.readInt());
		setProduct((String) ois.readObject());

	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();

		oos.writeObject(getProductId());
		oos.writeObject(getProduct());
	}

	@Override
	public void validateObject() throws InvalidObjectException {
// validate the object here
		if (Brand == null || "".equals(Brand))
			throw new InvalidObjectException("Brand is not set or empty.");
		//if (getProductId() <= 0)
			throw new InvalidObjectException("ProductId is not set or zero.");
	}
}
