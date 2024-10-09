import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 100x100 크기의 도화지를 표현하는 2차원 배열
        int[][] paper = new int[100][100];

        // 색종이의 수를 입력받음
        int paperNumber = sc.nextInt();

        for (int i = 0; i < paperNumber; i++) {
            // 색종이의 위치를 입력받음
            int xPosition = sc.nextInt();
            int yPosition = sc.nextInt();

            // 색종이가 덮는 영역을 2차원 배열에 표시
            for (int x = xPosition; x < xPosition + 10; x++) {
                for (int y = yPosition; y < yPosition + 10; y++) {
                    paper[x][y] = 1;
                }
            }
        }

        int totalBlackArea = 0;
        // 2차원 배열을 순회하며 색종이가 덮은 영역의 넓이를 계산
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    totalBlackArea++;
                }
            }
        }

        // 색종이가 덮은 영역의 넓이를 출력
        System.out.println(totalBlackArea);
    }
}
