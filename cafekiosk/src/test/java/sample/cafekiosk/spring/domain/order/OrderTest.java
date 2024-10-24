package sample.cafekiosk.spring.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sample.cafekiosk.spring.domain.product.Product;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    void calculateTotalPrice () {
        // given
        List<Product> products =List.of(
                createProduct("OO1", 1000),
        )

        // when

        // then
    }

}