import java.util.ArrayList;

class ProductOfNumbers {
    ArrayList<int[]> mul;
    
    public ProductOfNumbers() {
        mul = new ArrayList<>();
        mul.add(new int[]{1, 0});
    }
    
    public void add(int num) {
        int[] top = mul.get(mul.size() - 1); // Fixed: replaced length() with size()
        int multiply = top[0];
        int zeroes = top[1];
        
        if (num == 0) {
            zeroes++;
            multiply = 1; // Reset multiplication because of zero
        } else {
            multiply *= num;
        }
        
        mul.add(new int[]{multiply, zeroes});
    }
    
    public int getProduct(int k) {
        int size = mul.size();
        if (k >= size) return 0; // Edge case: if k is larger than stored elements

        int[] last = mul.get(size - 1);
        int[] last_k = mul.get(size - k - 1);
        
        if (last[1] - last_k[1] > 0) return 0; // If zero encountered in range
        
        return last[0] / last_k[0];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
