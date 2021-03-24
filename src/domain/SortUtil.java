package domain;

public class SortUtil {

    public static <T> void ordenar(Precedable<T> arr[]) {

        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].precedeA(((T) arr[j + 1])) > 0) {
                    Precedable<T> temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false){
                break;
            }
        }
    }
}
