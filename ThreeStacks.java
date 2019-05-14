public class ThreeStacks {
    private int[] arr;
    private int[] size = new int[3];
    /*
     * @param size: An integer
     */public ThreeStacks(int size) {
        // do intialization if necessary
        arr = new int[3*size];
    }

    /*
     * @param stackNum: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void push(int stackNum, int value) {
        // Push value into stackNum stack
        if(size[stackNum]<=arr.length/3-1) {
            arr[3*size[stackNum]+stackNum] = value;
            size[stackNum]++;
        }
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int pop(int stackNum) {
        // Pop and return the top element from stackNum stack
        int top = arr[3*(size[stackNum]-1)+stackNum];
        arr[3*(size[stackNum]-1)+stackNum] = 0;
        size[stackNum]--;
        return top;
    }

    /*
     * @param stackNum: An integer
     * @return: the top element
     */
    public int peek(int stackNum) {
        // Return the top element
        return arr[3*(size[stackNum]-1)+stackNum];
    }

    /*
     * @param stackNum: An integer
     * @return: true if the stack is empty else false
     */
    public boolean isEmpty(int stackNum) {
        // write your code here
        return size[stackNum]==0;
    }
}

