import java.util.*;
public class Main
{
    public static int recUtil(int i, int s, int sum , int arr[] , int n){
        if(i == n){
            if(s == sum ) return 1;
            else return 0;
        }
        s+=arr[i];
        int l = recUtil(i+1, s,sum, arr, n );
        s-=arr[i];
        int r = recUtil(i+1, s,sum, arr, n );
        return l + r;
    }
	public static void main(String[] args) {
	    int arr[] = new int[]{1,2,1};
	    int sum = 2;
	    int n = 3;
	    System.out.println(recUtil(0,0,2,arr,n));
	}
}
