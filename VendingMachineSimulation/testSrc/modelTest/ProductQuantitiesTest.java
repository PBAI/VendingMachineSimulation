package modelTest;

import junit.framework.TestCase;
import model.ProductQuantities;
import model.ProductQuantitiesInterface;

public class ProductQuantitiesTest extends TestCase {

	public void testImplementsProductQuantitiesInterface() throws Exception {
		assertEquals(1, ProductQuantities.class.getInterfaces().length);
		assertSame(ProductQuantitiesInterface.class, ProductQuantities.class.getInterfaces()[0]);
	}

	public void testGetProductAQuantity() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		assertEquals(3, productQuantities.getProductAQuantity());
	}

	public void testGetProductBQuantity() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		assertEquals(2, productQuantities.getProductBQuantity());
	}

	public void testGetProductCQuantity() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		assertEquals(4, productQuantities.getProductCQuantity());
	}

	public void testSubtractProductAQuantityByOne() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		productQuantities.subtractProductAQuantityByOne();
		assertEquals(2, productQuantities.getProductAQuantity());
	}

	public void testSubtractProductBQuantityByOne() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		productQuantities.subtractProductBQuantityByOne();
		assertEquals(1, productQuantities.getProductBQuantity());
	}

	public void testSubtractProductCQuantityByOne() throws Exception {
		ProductQuantitiesInterface productQuantities = new ProductQuantities();
		productQuantities.subtractProductCQuantityByOne();
		assertEquals(3, productQuantities.getProductCQuantity());
	}

}
