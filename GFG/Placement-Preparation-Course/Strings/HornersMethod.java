class HornersMethod{
    public static void main(String[] args) {
        // f(x) = 5x^4 - 3x^2  + x - 8
        //        5     -3       1 -8
        // x^3 is missing, add 0 at its place;
        
        int polyOrder = 4;
        
        // array length  = polyOrder + 1
        int coefficients[] = {5, 0, -3, 1, -8};
        int x = -2 ;
        
        int sum = coefficients[0];

        int n = coefficients.length;
        for (int i = 1; i < n; i++)
            sum = x * sum + coefficients[i];
        
        System.out.printf("sum %d\n", sum);
    }

    // f(x) = 5x^4 - 3x^2  + x - 8
    // f(x) = 5(-2^4) - 3(-2^2) - 2 - 8
    //      = 5.16 - 3.4 -2  - 8
    //      = 80 - 22
    //f(-2) = 58;

    // sum should be 58;   
}