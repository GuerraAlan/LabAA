package application.model;

public class Selection extends Ordenacao {
	//967,-5,0,6,8,89,5247,-697
	@Override
	public int[] executar(int[] numeros) {
		return selectionSort(numeros);
	}

	public static int[] selectionSort(int[] numeros){
		var output = numeros.clone();
		for (int i = 0; i < output.length - 1; i++)
		{
			int index = i;
			for (int j = i + 1; j < output.length; j++){
				if (output[j] < output[index]){
					index = j;
				}
			}
			int smallerNumber = output[index];
			output[index] = output[i];
			output[i] = smallerNumber;
		}
		return output;
	}

}
