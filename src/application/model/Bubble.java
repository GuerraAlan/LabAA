package application.model;

public class Bubble extends Ordenacao {
	@Override
	public int[] executar(int[] numeros) {
		return bubbleSort(numeros);
	}

	public int[] bubbleSort(int[] numeros) {
		var output = numeros.clone();

		for (int i = 0; i < output.length - 1; i++) {
			for (int j = 0; j < output.length - 1 - i; j++) {
				if (output[j] > output[j + 1]) {
					int aux = output[j];
					output[j] = output[j + 1];
					output[j + 1] = aux;
				}
			}
		}
		return output;
	}

}
