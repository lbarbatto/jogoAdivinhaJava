
public class ComparaResposta {
	
	private static int totalTentativas = 0;
	
	public String compara(int chute, int resposta) {
		totalTentativas++;
		if (chute == resposta) {
			return "Parabéns! Você acertou!";
		} else if (chute > resposta) {
			return "Errou! O número misterioso é menor.";
		} else {
			return "Errou! O número misterioso é maior.";
		}		
	}

	public int getTotalTentativas() {
		return totalTentativas;
	}

}
