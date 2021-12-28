/******************************************************************************
 *  Compilation:  javac Merge.java
 *  Execution:    java Merge < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/22mergesort/tiny.txt
 *                https://algs4.cs.princeton.edu/22mergesort/words3.txt
 *
 *  Sorts a sequence of strings from standard input using mergesort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java Merge < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java Merge < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

/**
 * The {@code Merge} class provides static methods for sorting an
 * array using a top-down, recursive version of <em>mergesort</em>.
 * <p>
 * This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 * to sort any array of length <em>n</em> (assuming comparisons
 * take constant time). It makes between
 * ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 * ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 * <p>
 * This sorting algorithm is stable.
 * It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/22mergesort">Section 2.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class MergeSound {
    /* @citation Adapted from: https://algs4.cs.princeton.edu/22mergesort/Merge.java
     * Accessed 12/27/21. */

    // This class should not be instantiated.
    private MergeSound() {
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(SoundArray a, SoundArray aux, int lo, int mid, int hi) {
        // precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux.set(k, a.get(k));
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a.set(k, aux.get(j++));
            else if (j > hi) a.set(k, aux.get(i++));
            else if (less(aux.get(j), aux.get(i))) a.set(k, aux.get(j++));
            else a.set(k, aux.get(i++));
        }

        // postcondition: a[lo .. hi] is sorted
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(SoundArray a, SoundArray aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(SoundArray a) {
        SoundArray aux = new SoundArray(a.length(), 300, 2, 0);
        sort(a, aux, 0, a.length() - 1);
    }


    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
