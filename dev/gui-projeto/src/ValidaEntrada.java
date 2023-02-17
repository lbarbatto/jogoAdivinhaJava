
public class ValidaEntrada {

	public boolean valida(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
