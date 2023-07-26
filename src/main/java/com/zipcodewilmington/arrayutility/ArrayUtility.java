package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T>{


    private T[] array;

    public ArrayUtility(T[] inputArray) {
        this.array = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] updatedArray = (T[]) Array.newInstance(valueToEvaluate.getClass(), array.length + arrayToMerge.length);
        int count = 0;

        for (int i = 0; i < updatedArray.length; i++){
            if (i < array.length){
                updatedArray[i] = array[i];
            }
            else {
                updatedArray[i] = arrayToMerge[i - array.length];
            }
        }

        array = updatedArray;

        count = getNumberOfOccurrences(valueToEvaluate);

        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T filler = arrayToMerge[0];
        T[] updatedArray = (T[]) Array.newInstance(filler.getClass(), array.length + arrayToMerge.length);

        for (int i = 0; i < updatedArray.length; i++){
            if (i < array.length){
                updatedArray[i] = array[i];
            }
            else {
                updatedArray[i] = arrayToMerge[i - array.length];
            }
        }

        T mostCommon = null;
        int commonCount = 0;

        for (int i = 0; i < updatedArray.length; i++){
            int tempCount;

            tempCount = getNumberOfOccurrences(updatedArray[i]);

            if (tempCount > commonCount){
                mostCommon = updatedArray[i];
                commonCount = tempCount;
            }
        }
        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;

        for (int i = 0; i < array.length; i++){
            if (array[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    

    public T[] removeValue(T valueToRemove) {
        int length = array.length - getNumberOfOccurrences(valueToRemove);
        T[] updatedArray = (T[]) Array.newInstance(valueToRemove.getClass(), length);
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)){
                updatedArray[index] = array[i];
                index++;
            }

        }

        return updatedArray;
    }
    
}
