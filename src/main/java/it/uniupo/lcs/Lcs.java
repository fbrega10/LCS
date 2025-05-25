package it.uniupo.lcs;

import it.uniupo.enums.Arrow;

/**
 * This class provides a constructor (of two strings) and a method Lcs
 * that provides the longest common string, using two matrixes and applying an iterative
 * function to find the lcs.
 */
public class Lcs {

    private final String s1;
    private final String s2;

    /**
     * @param s1 first string
     * @param s2 second string
     * @throws UnsupportedOperationException in case of null strings, checks on both.
     */
    public Lcs(String s1, String s2) throws UnsupportedOperationException {
        if (s1 == null || s2 == null)
            throw new UnsupportedOperationException("Cannot calculate LCS on a null String, please construct a new valid LCS object");
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * @return the LCS, longest common subsequence
     */
    public String LCS() {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int m = a.length + 1;
        int n = b.length + 1;
        Arrow[][] arrows = new Arrow[m][n];
        int[][] l = new int[m][n];
        for (int i = 0; i < m; ++i)
            l[i][0] = 0;
        for (int j = 0; j < n; ++j)
            l[0][j] = 0;
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (a[i - 1] == b[j - 1]) {
                    arrows[i][j] = Arrow.DIAGONAL;
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else if (l[i - 1][j] > l[i][j - 1]) {
                    arrows[i][j] = Arrow.UP;
                    l[i][j] = l[i - 1][j];
                } else {
                    arrows[i][j] = Arrow.LEFT;
                    l[i][j] = l[i][j - 1];
                }
            }
        }
        return recoverStringRic(a, m-1, n-1, arrows, "");
    }

    /**
     * @param a the string
     * @param m the first string length
     * @param n the second string length
     * @param arrows the first string representation as char []
     * @param s a string accumulator
     * @return the string, using recursion it fills each char in the correct place
     */
    protected String recoverStringRic(char[] a, int m, int n, Arrow[][] arrows, String s) {
        if (arrows[m][n] == null)
            return s;
        if (arrows[m][n].equals(Arrow.DIAGONAL))
            return recoverStringRic(a, m - 1, n - 1, arrows, s ) + a[m - 1];
        else if (arrows[m][n].equals(Arrow.UP))
            return recoverStringRic(a, m - 1, n, arrows, s);
        else
            return recoverStringRic(a, m, n - 1, arrows, s);
    }
}
