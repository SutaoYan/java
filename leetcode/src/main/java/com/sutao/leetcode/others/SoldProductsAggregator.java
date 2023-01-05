package com.sutao.leetcode.others;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

class SoldProduct {
    String name;
    BigDecimal price;
    String currency;

    public SoldProduct(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }
}


class SoldProductsAggregate {
    List<SimpleSoldProduct> products;
    BigDecimal total;

    public SoldProductsAggregate(List<SimpleSoldProduct> products, BigDecimal total) {
        this.products = products;
        this.total = total;
    }
}

class SimpleSoldProduct {
    String name;
    BigDecimal price;

    SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}


interface ExchangeService {
    default Optional<BigDecimal> rate(String currency) {
        return Optional.of(new BigDecimal(1.0));
    }

}

class EURExchangeService implements ExchangeService {

}

public class SoldProductsAggregator {

    private final ExchangeService exchangeService;

    SoldProductsAggregator(ExchangeService EURExchangeService) {
        this.exchangeService = EURExchangeService;
    }

    SoldProductsAggregate aggregate(Stream<SoldProduct> products) {

        if (null == products) return new SoldProductsAggregate(new ArrayList<>(), BigDecimal.ZERO);

        List<SimpleSoldProduct> items = new ArrayList<>();

        BigDecimal total = products
                .filter(o -> o.price.compareTo(BigDecimal.ZERO) >= 0)
                .map(p -> {
                            items.add(new SimpleSoldProduct(p.name, p.price));
                            return exchangeService.rate(p.currency).orElse(BigDecimal.ZERO).multiply(p.price);
                        }
                )
                .filter(o -> o.compareTo(BigDecimal.ZERO) >= 0)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SoldProductsAggregate(items, total);
    }


    public static void main(String[] args) {

        ArrayList<SoldProduct> products = new ArrayList<>();
        products.add(new SoldProduct("A", new BigDecimal(-2.0), "EUR"));
        products.add(new SoldProduct("A", new BigDecimal(2.0), "EUR"));
        new SoldProductsAggregator(new EURExchangeService()).aggregate(products.stream());
    }

}