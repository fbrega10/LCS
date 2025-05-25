# Longest Common Subsequence (LCS)

This repository contains a Java implementation of the **Longest Common Subsequence (LCS)** algorithm using **Dynamic Programming**.

## 📌 Problem Definition

The **Longest Common Subsequence (LCS)** problem is the task of finding the longest subsequence common to two sequences (typically strings). A *subsequence* is a sequence that appears in the same relative order, but not necessarily contiguous.

### Example

For the input strings:

s1 = "ABCBDAB"
s2 = "BDCAB"


A valid longest common subsequence is:

LCS = "BDAB"


> Note: There may be more than one LCS of the same maximum length.

---

## ⚙️ Algorithm

This implementation uses a **bottom-up dynamic programming** approach with a table of size `m x n` where:
- `m = s1.length() + 1`
- `n = s2.length() + 1`

It also reconstructs the LCS by tracing back through the computed table using directional arrows.

### ⏱ Time and Space Complexity

- **Time Complexity:** `O(m * n)`
- **Space Complexity:** `O(m * n)`

Where:
- `m` is the length of the first string
- `n` is the length of the second string

---

## 🧪 Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Lcs lcs = new Lcs("XMJYAUZ", "MZJAWXU");
        System.out.println("LCS: " + lcs.LCS());  // Output: MJAU
    }
}
