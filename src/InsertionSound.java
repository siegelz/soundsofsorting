/******************************************************************************
 *  Compilation:  javac InsertionSound.java
 *  Execution:    java InsertionSound < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *
 *  Sorts a sequence of strings from standard input using insertion sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java InsertionSound < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java InsertionSound < words3.txt
 *  all bad bed bug dad ... yes yet zoo   [ one string per line ]
 *
 ******************************************************************************/

/**
 * The {@code InsertionSound} class provides static methods for sorting an
 * array using insertion sort.
 * <p>
 * In the worst case, this implementation makes ~ &frac12; <em>n</em><sup>2</sup>
 * compares and ~ &frac12; <em>n</em><sup>2</sup> exchanges to sort an array
 * of length <em>n</em>. So, it is not suitable for sorting large arbitrary
 * arrays. More precisely, the number of exchanges is exactly equal to the
 * number of inversions. So, for example, it sorts a partially-sorted array
 * in linear time.
 * <p>
 * This sorting algorithm is stable.
 * It uses &Theta;(1) extra memory (not including the input array).
 * <p>
 * See <a href="https://algs4.cs.princeton.edu/21elementary/InsertionPedantic.java.html">InsertionPedantic.java</a>
 * for a version that eliminates the compiler warning.
 * <p>
 * For additional documentation, see <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class InsertionSound {

    // This class should not be instantiated.
    private InsertionSound() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(SoundArray a) {
        int n = a.length();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a.get(j), a.get(j - 1)); j--) {
                exch(a, j, j - 1);
            }
            // assert isSorted(a, 0, i);
        }
        // assert isSorted(a);
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(SoundArray a, int i, int j) {
        int swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
}
