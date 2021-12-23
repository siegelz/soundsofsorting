/******************************************************************************
 *  Compilation:  javac SelectionSound.java
 *  Execution:    java  SelectionSound < input.txt
 *  Dependencies: StdOut.java StdIn.java
 *  Data files:   https://algs4.cs.princeton.edu/21elementary/tiny.txt
 *                https://algs4.cs.princeton.edu/21elementary/words3.txt
 *
 *  Sorts a sequence of strings from standard input using selection sort.
 *
 *  % more tiny.txt
 *  S O R T E X A M P L E
 *
 *  % java SelectionSound < tiny.txt
 *  A E E L M O P R S T X                 [ one string per line ]
 *
 *  % more words3.txt
 *  bed bug dad yes zoo ... all bad yet
 *
 *  % java SelectionSound < words3.txt
 *  all bad bed bug dad ... yes yet zoo    [ one string per line ]
 *
 ******************************************************************************/

/**
 * The {@code SelectionSound} class provides static methods for sorting an
 * array using <em>selection sort</em>.
 * This implementation makes ~ &frac12; <em>n</em><sup>2</sup> compares to sort
 * any array of length <em>n</em>, so it is not suitable for sorting large arrays.
 * It performs exactly <em>n</em> exchanges.
 * <p>
 * This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 * (not including the input array).
 * <p>
 * For additional documentation, see
 * <a href="https://algs4.cs.princeton.edu/21elementary">Section 2.1</a>
 * of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class SelectionSound {

    // This class should not be instantiated.
    private SelectionSound() {
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(SoundArray a) {
        int n = a.length();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a.get(j), a.get(min))) min = j;
            }
            exch(a, i, min);
        }
    }

    /**
     * /***************************************************************************
     * Helper sorting functions.
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
