package it.uniupo.lcs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LcsTest {
    private Lcs lcs;

    @Test
    @DisplayName("Longest common subsequence - test")
    void LCS() {
        String s1 = "GACATGC";
        String s2 = "ATCGAG";
        lcs = new Lcs(s1, s2);
        Assertions.assertEquals("ACAG", lcs.LCS());
        Exception e = Assertions.assertThrows(UnsupportedOperationException.class, () -> lcs = new Lcs(null, null));
        Assertions.assertEquals("Cannot calculate LCS on a null String, please construct a new valid LCS object", e.getMessage());
        e = Assertions.assertThrows(UnsupportedOperationException.class, () -> lcs = new Lcs(null, "hello"));
        Assertions.assertEquals("Cannot calculate LCS on a null String, please construct a new valid LCS object", e.getMessage());
        e = Assertions.assertThrows(UnsupportedOperationException.class, () -> lcs = new Lcs("hello", null));
        Assertions.assertEquals("Cannot calculate LCS on a null String, please construct a new valid LCS object", e.getMessage());
        lcs = new Lcs("HELLO", "HELLO");
        Assertions.assertEquals("HELLO", lcs.LCS());

        s1 = "ABCBDAB";
        s2 = "BDCAB";
        String result = "BDAB";
        lcs = new Lcs(s1, s2);
        Assertions.assertEquals(result, lcs.LCS());

        s1 = "XMJYAUZ";
        s2 = "MZJAWXU";
        result = "MJAU";
        lcs = new Lcs(s1, s2);
        Assertions.assertEquals(result, lcs.LCS());

    }
}