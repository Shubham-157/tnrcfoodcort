package in.TNRC.foodcourt.exception;

public class ProductNotExistsException extends IllegalArgumentException {
	public ProductNotExistsException(String msg) {
        super(msg);
    }
		
}
