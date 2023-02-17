import java.util.Random;

public class SorteiaNumero {
	
	public int getNumero() {
		Random random = new Random();
		int sorteado = random.nextInt(100)+1;
		return sorteado;
	}

}
