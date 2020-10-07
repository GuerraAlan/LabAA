package application.model;

import java.util.Arrays;

public class Radix extends Ordenacao{

    @Override
    public int[] executar(int[] numeros) {
        return radixsort(numeros);
    }

    static int getMax(int[] numeros)
    {
        int max = numeros[0];
        for (int i = 1; i < numeros.length; i++)
            if (numeros[i] > max)
                max = numeros[i];
        return max;
    }

    static void countSort(int[] numeros, int exp)
    {
        var output = new int[numeros.length];

        var count = new int[10];
        Arrays.fill(count, 0);

        for (int numero : numeros) {
            count[Math.abs(numero / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }


        for (int i = numeros.length - 1; i >= 0; i--) {
            output[count[Math.abs(numeros[i] / exp) % 10] - 1] = numeros[i];
            count[Math.abs(numeros[i] / exp) % 10]--;
        }

        Arrays.setAll(numeros, i -> output[i]);
    }

    static int[] sortNegatives(int[] numeros, int negativeCount){
        if (negativeCount > 0){
            var output = new int[numeros.length];
            int negativeInserted = 0;
            int positiveInserted = 0;
            for (int numero: numeros) {
                if(numero >= 0){
                    output[negativeCount+positiveInserted] = numero;
                    positiveInserted++;
                } else {
                    output[negativeCount-1 - negativeInserted] = numero;
                    negativeInserted++;
                }
            }
            return output;
        }

        return numeros;
    }

    static int negativeCount(int[] numeros){
        return (int) Arrays.stream(numeros).filter(numero -> numero < 0).count();
    }

    static int[] radixsort(int[] numeros)
    {
        var output = numeros.clone();
        int max = getMax(numeros);

        for (int exp = 1; max / exp > 0; exp *= 10){
            countSort(output, exp);
        }

        int negativeCount = negativeCount(output);
        return sortNegatives(output, negativeCount);
    }
}
