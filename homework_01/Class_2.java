// 2. Вывести все простые числа от 1 до 1000

public class Class_2
{
    public static void main(String[] args) {
        
        int n = 1000;

        for (int i = 2; i <= n; i++) {
            for (int k = 2; k <= i; k++) {
                if (i % k == 0) {
                    if (i == k) System.out.printf("Число %d простое\n", i);
                    else break;
                }
            }
        }
    }
}
