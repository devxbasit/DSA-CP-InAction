class IsPalindrome{
    public static boolean expandRange(String s, int begin, int end) {
        while (begin > -1 ){
            if (s.charAt(begin) != s.charAt(end))
                return false;
            begin--;
            end++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        String s;
        // s = "madan";
        s = "madam";
        int len = s.length();

        boolean ans;
        
        if (len % 2 == 0)
            ans = expandRange(s, (len - 1) / 2, (len - 1) / 2 + 1); 
        else
            ans = expandRange(s, (len - 1) / 2, (len - 1) / 2); 
        
        System.out.println("IsPalindrome: " + ans);
    }
}