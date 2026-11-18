class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = square(n);
            if (n==1) {
                return true;
            }
        }

        return false;
    }

    private int square(int num) {
        int op = 0;

        while (num >0) {
            int d = num % 10;
            d = d * d;
            op += d;
            num = num / 10;
        }

        return op;
    }
}
