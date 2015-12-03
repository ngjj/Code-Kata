
public class KarateChop {

  private static final int KEY_NOT_FOUND = -1;

  public static void main(String[] args) {

    int[] array_of_int = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    System.out.println("Search result is index " + chopIterative(6, array_of_int));
  }

  /**
   * Done by NJJ
   * Thanks
   * @param target
   * @param array_of_int
   * @return
   */
  static int chopIterative(int target, int[] array_of_int) {
    int min = 0;
    int max = array_of_int.length - 1;
    while (min <= max) {
      // calculate the midpoint for roughly equal partition
      int mid = min + (max - min) / 2;
      if (target < array_of_int[mid])
        // change max index to search lower subarray
        max = mid - 1;
      else if (target > array_of_int[mid])
        // change min index to search upper subarray
        min = mid + 1;
      else {
        // key found at mid
        return mid;
      }

    }
    return KEY_NOT_FOUND;
  }

  static int chopRecursive(int target, int[] array_of_int, int min, int max) {
    if (max < min)
      return KEY_NOT_FOUND;
    else {
      // calculate midpoint to cut set in half
      int mid = min + (max - min) / 2;

      // three-way comparison
      if (array_of_int[mid] > target)
        // key is in lower subset
        return chopRecursive(target, array_of_int, min, mid - 1);
      else if (array_of_int[mid] < target)
        // key is in upper subset
        return chopRecursive(target, array_of_int, mid + 1, max);
      else
        // key has been found
        return mid;
    }
  }
}
