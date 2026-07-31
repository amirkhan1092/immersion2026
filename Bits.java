public class Bits {
    public static void main(String[] args) {
        int n = 12;
        int n = longestConsecutiveOnes(n);

        
    }

    private static int longestConsecutiveOnes(int i) {
        // logic here 
        int count=0;
        int maxCount=0;
        while(i != 0){
            if(i%2 == 1){
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else
            {
                count = 0;
            }
            i /= 2;
        }
        return maxCount;
    }

    private static int bitsSum(int i) {
        int count=0;
        while(i != 0){
            count += i%2;
            i /= 2;
        }
        return count;
        
    }

    private static int digitSum(int i) {
        if(i == 0) return 0;
        return i%10 + digitSum(i/10);
        
    }
}


/*
DigitSum 
120 ==> 3
123 ==> 6


bitsSum
12(1100) ==> 2
13(1101) ==> 2
15(1111) ==> 4


*/