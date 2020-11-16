package A;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class UIMap implements Externalizable {

	private int id;
	private String locator;
	private String value;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		out.writeObject(locator + "$$");
		out.writeObject("##" + value);
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		id = in.readInt();
		// Retrieve data in the same sequence as written
		locator = (String) in.readObject();
		if (!locator.endsWith("$$"))
			throw new IOException("data integrity failed.");
		locator = locator.substring(0, locator.length() - 2);
		value = (String) in.readObject();
		if (!value.startsWith("##"))
			throw new IOException("data integrity failed.");
		value = value.substring(2);
	}

	@Override
	public String toString() {
		return "UIMap[ id=" + id + ",locator=" + locator + ",value=" + value + " ]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}


