package sample.cafekiosk.unit;

import sample.cafekiosk.unit.beverage.Americano;
import sample.cafekiosk.unit.beverage.Latte;

public class CafeKioskRunner {
    public static void main(String[] args) {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println("카페 키오스크에 아메리카노 추가 완료");

        cafeKiosk.add(new Latte());
        System.out.println("카페 키오스크에 라떼 추가 완료");

        cafeKiosk.calculateTotalPrice();
        System.out.println("총 가격은 " + cafeKiosk.calculateTotalPrice() + "원 입니다.");
    }
}
