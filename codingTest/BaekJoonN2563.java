import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoonN2563 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paperNumber = sc.nextInt();
        sc.nextLine();

        List<Coordinate> coordinates = new ArrayList<>();

        //하나씩 입력받는 좌표들
        for (int i = 0; i < paperNumber; i++) {
            String[] inputCoordinates = sc.nextLine().split(" ");
            int xCoordinates = Integer.parseInt(inputCoordinates[0]);
            int yCoordinates = Integer.parseInt(inputCoordinates[1]);

            coordinates.add(new Coordinate(xCoordinates, yCoordinates));

        }

        long totalSquareArea = 0;

        for (int i = 0; i < coordinates.size(); i++) {
            //좌표들을 하나씩 꺼내서 넓이를 구해주기
            Coordinate currentCoordinate = coordinates.get(i);
            Coordinate nextCoordinate = coordinates.get(i + 1);

            if (coordinates.size() == 1) {
                totalSquareArea += 100;
                continue;
            }

            if (nextCoordinate.x - currentCoordinate.x > 0) {
            }
        }
    }

    //좌표 비교하기
    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
