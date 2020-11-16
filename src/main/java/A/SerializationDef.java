package A;

import java.io.Serializable;

public class  SerializationDef implements Serializable{
	private	String Product;
	private	String Feature;
	transient private int FeatureCount;
	
    @Override
    public String toString(){
        return "Summary[Product("+Product+"),Feature("+Feature+"),FeatureCount("+FeatureCount+")]";
    }
	
	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		this.Product = product;
	}

	public String getFeature() {
		return Feature;
	}

	public void setFeature(String feature) {
		this.Feature = feature;
	}

	public int getFeatureCount() {
		return FeatureCount;
	}

	public void setFeatureCount(int count) {
		this.FeatureCount = count;
	}
}

