public class Solution187 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        int n = gas.length;
        if(n==0) {
            return -1;
        }
        boolean isCircuit = false;
        int i=0;
        while(i<n) {
            int leftGas = 0;
            int j=n,k=i;
            while( j>0) {
                leftGas += gas[k];
                if(leftGas<cost[k]) {
                    break;
                }
                leftGas -= cost[k];
                k = (k+1)%n;
                j--;
            }
            if(j==0 && leftGas>=0){
                isCircuit = true;
                break;
            }
            i++;
        }
        return isCircuit? i :-1;
    }

    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;
        if(n==0) {
            return -1;
        }
        int sumGas = 0, sumCost = 0,sum = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            sum += gas[i];
            sum -= cost[i];
            sumGas += gas[i];
            sumCost += cost[i];

            if(sum<0) {
                start = i+1;
                sum = 0;
            }
        }

        return sumGas<sumCost ? -1 : start;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        if(n==0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        int leftGas = 0;
        for(int i=0; i<n; i++) {
            leftGas += gas[i];
            leftGas -= cost[i];
            if(leftGas<min){
                min = leftGas;
                res = i;
            }
        }
        if(leftGas>=0){
            return (res+1)%n;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,1,3,1};
        int[] cost = {2,2,1,1};
        int[] cost1 = {2,2,10,1};
        System.out.println(canCompleteCircuit2(gas,cost));
        System.out.println(canCompleteCircuit2(gas,cost1));
    }
}

