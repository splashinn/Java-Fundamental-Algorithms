// Insertion sort
// Insertion.java
// Copyright (C) 2014 Kyle Maune

import java.util.Comparator;

public class Insertion {

  // this class should not be instantiated
  private Insertion() { }

  // rearranges the array in ascending order, using the natural order
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
        exch(a, j, j - 1);
      }
      assert isSorted(a, 0, i);
    }
    assert isSorted(a);
  }

  // rearranges the array in ascending order, using a comparator
  public static void sort(Object[] a, Comparator c) {
    int N = a.length;
    for (int i = 0; i < N; i++) {
      for (int j = i; j > 0 && less(c, a[j], a[j - 1]); j--) {
        exch(a, j, j - 1);
      }
      assert isSorted(a, c, 0, i);
    }
    assert isSorted(a, c);
  }
  // return a permutation that gives the elements in a[] in ascending order
    public static int[] indexSort(Comparable[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i++)
            index[i] = i;

        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j-1]]); j--)
                exch(index, j, j-1);

        return index;
    }

   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // is v < w ?
    private static boolean less(Comparator c, Object v, Object w) {
        return (c.compare(v, w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }

   // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

      // Reads in a sequence of strings from standard input; insertion sorts them;
     // and prints them to standard output in ascending order.
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Insertion.sort(a);
        show(a);
    }
}
