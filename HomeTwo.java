public class HomeTwo {
    public static void main(String[] args) {
        int[] a  = new int[] {1, 5, 7, 19, 21, 3, 6, 8, 91, 19};
        // mergeSort(a[], 0, a.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right) {  
        if (right <= left) return;
        int mid = (left+right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }

    void merge(int[] array, int left, int mid, int right) {
        // вычисляем длину
        int lengthLeft = mid - left + 1;
        int lengthRight = right - mid;

        // создаем временные подмассивы
        int leftArray[] = new int [lengthLeft];
        int rightArray[] = new int [lengthRight];

        // копируем отсортированные массивы во временные
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = array[left+i];
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = array[mid+i+1];

        // итераторы содержат текущий индекс временного подмассива
        int leftIndex = 0;
        int rightIndex = 0;

        // копируем из leftArray и rightArray обратно в массив  
        for (int i = left; i < right + 1; i++) {
            // если остаются нескопированные элементы в R и L, копируем минимальный
            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            // если все элементы были скопированы из rightArray, скопировать остальные из leftArray
            else if (leftIndex < lengthLeft) {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }
            // если все элементы были скопированы из leftArray, скопировать остальные из rightArray
            else if (rightIndex < lengthRight) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }


// public static List<List<Integer>> kombination(int n, int k) {
//     List<List<Integer>> result = new ArrayList<>();
//     if(n < k) return result;
//     int[] arr = new int[n];
//     for(int i = 1; i <= n; i++)
//         arr[i - 1] = i;
//     backback(k, 0, arr, new ArrayList<Integer>(), result);
//     return result;
// }

// private static void backback(int k, int start, int[] arr, List<Integer> list, List<List<Integer>> result){
//     if(k == 0) result.add(new ArrayList<Integer>(list));
//     else{
//         for(int i = start; i <= arr.length - k; i++){
//             list.add(arr[i]);
//             backback(k - 1, i + 1, arr, list, result);
//             list.remove(list.size() - 1);
//         }
//     }
// }


}
