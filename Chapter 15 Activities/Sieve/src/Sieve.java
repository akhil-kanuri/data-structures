import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();


        // Your work goes here
        System.out.println(readnums(n));

        







    }


    public static Set<Integer> readnums(int n){
        Set<Integer> nums = new HashSet<>(n);
        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }
        for(int i = 2; i<=n;i++)
        {
            Iterator<Integer> iterator = nums.iterator();
            while(iterator.hasNext())
            {
                int j=iterator.next();
                if(j%i==0 && j!=i)
                {
                    // System.out.println(j+" "+i);
                    iterator.remove();
                }
            }
        }
        return nums;
    }
}
