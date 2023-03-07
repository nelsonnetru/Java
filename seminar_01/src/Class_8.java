public class Class_8
{
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        checkArray(nums);
    }

    public static void checkArray (int[] nums) {
        int leftSumm = 0;
        int rightSumm = 0;
        boolean flag = false;

        for (int i = 1; i < nums.length; i++) {
            rightSumm += nums[i];
        }

        for (int i = 1; i < nums.length-1; i++) {
            rightSumm -= nums[i];
            leftSumm += nums[i-1];

            if (leftSumm == rightSumm) {
                System.out.printf("Элемент [%d]: сумма элементов слева: %d, сумма элементов справа: %d\n", i, leftSumm, rightSumm);
                flag = true;
            }
         }

        if (!flag) System.out.println("Нет элементов, удовлетворяющих условию");
    }
}
