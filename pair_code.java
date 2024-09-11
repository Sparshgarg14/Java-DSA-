import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class CodeForces {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        FastReader fr = new FastReader();
        int nmax = (int) (1e6 + 5);
        int t = fr.nextInt();
        while (t-- > 0) {
           int n  =fr.nextInt();
            Pair[] ab = new Pair[n];
            for (int i = 0; i < n; i++) {
                int first  =fr.nextInt();
                ab[i] = new Pair(first, 0);
            }
            for (int i = 0; i < n; i++) {
                int second  =fr.nextInt();
                ab[i].b = second;
            }
            Arrays.sort(ab, Comparator.comparingInt(pair -> pair.a));
          for(int i =0;i<ab.length;i++){
              System.out.print(ab[i].a+" ");
          }
            System.out.println();
            for(int i =0;i<ab.length;i++){
                System.out.print(ab[i].b+" ");
            }
            System.out.println();

        }
    }








    public static class Pair {
        public int a;
        public int b;
        public int hashCode;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.hashCode = Objects.hash(a, b);
        }


        @Override
        public String toString() {
            return a + " -> " + b;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Pair that = (Pair) o;
            return a == that.a && b == that.b;
        }

        @Override
        public int hashCode() {
            return this.hashCode;
        }
    }

}



class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                // Read the next line
                String line = br.readLine();

                // Check if the line is null
                if (line == null) {
                    return null;  // Handle end of input or unexpected input issues
                }

                // Initialize the StringTokenizer with the read line
                st = new StringTokenizer(line);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            if (st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}



//        // Method to calculate GCD using Euclidean algorithm
//        public static int gcd(int a, int b) {
//            if (b == 0) {
//                return a;
//            }
//            return gcd(b, a % b);
//        }
// Custom implementation of upper_bound to mimic C++ behavior
//    private static int upperBound(List<Integer> list, int key) {
//        int low = 0, high = list.size();
//        while (low < high) {
//            int mid = (low + high) / 2;
//            if (list.get(mid) <= key) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low;
//    }
//static long pow(long x, long q) {
//    if (q == 0) {
//        return 1;
//    }
//    long i = pow(x, q / 2);
//    if (q % 2 == 0) {
//        return (i * i) % p;
//    }
//    return (i * i * x) % p;
//}