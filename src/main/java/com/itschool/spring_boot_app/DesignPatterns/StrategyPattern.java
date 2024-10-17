package com.itschool.spring_boot_app.DesignPatterns;


import java.util.HashMap;
import java.util.Map;

interface PricingStrategy {

    double calculateTotal(Map<String, Integer> items, Map<String, Double> prices);

}

// Implementarea strategiei de preț normal

class RegularPricing implements PricingStrategy {

    @Override
    public double calculateTotal(Map<String, Integer> items, Map<String, Double> prices) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            total += entry.getValue() * prices.getOrDefault(entry.getKey(), 0.0);
        }
        return total;
    }

}

// Implementarea strategiei de preț cu reducere

class DiscountPricing implements PricingStrategy {

    private double discount;

    public DiscountPricing(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculateTotal(Map<String, Integer> items, Map<String, Double> prices) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            total += entry.getValue() * prices.getOrDefault(entry.getKey(), 0.0);
        }
        return total * (1 - discount);
    }

}

// Implementarea strategiei de preț pentru sărbători
class HolidayPricing implements PricingStrategy {

    private double holiday;

    public HolidayPricing(double holiday) {
        this.holiday = holiday;
    }

    @Override
    public double calculateTotal(Map<String, Integer> items, Map<String, Double> prices) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            total += entry.getValue() * prices.getOrDefault(entry.getKey(), 0.0);
        }
        return total * holiday;
    }

}

// Clasa ShoppingCart care gestionează articolele și strategiile de calcul al prețului
class ShoppingCart {

    private Map<String, Integer> items = new HashMap<>();
    private PricingStrategy pricingStrategy;
    private Map<String, Double> prices;

    public ShoppingCart(Map<String, Double> prices) {
        this.prices = prices;
    }

    public void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    public void setPricingStrategy(PricingStrategy strategy) {
        this.pricingStrategy = strategy;
    }


    public double calculateTotal() {
        if (pricingStrategy == null) {
            throw new IllegalStateException("Strategia de preț nu a fost setată.");
        }
        return pricingStrategy.calculateTotal(items, prices);
    }

}

public class StrategyPattern {

    public static void main(String[] args) {

        Map<String, Double> prices = new HashMap<>();
        prices.put("Globuri", 5.0);
        prices.put("Betea", 2.5);
        prices.put("Stea", 3.0);

        ShoppingCart cart = new ShoppingCart(prices);

        cart.addItem("Globuri", 20);
        cart.addItem("Betea", 10);

        // Preț normal
        cart.setPricingStrategy(new RegularPricing());
        System.out.println("Preț normal: $" + cart.calculateTotal());

        // Preț cu reducere
        cart.setPricingStrategy(new DiscountPricing(0.20));  // Reducere 20%
        System.out.println("Preț cu reducere : $" + cart.calculateTotal());

        // Preț pentru sărbători
        cart.setPricingStrategy(new HolidayPricing(0.5));  // Reducere 50% de sărbători
        System.out.println("Preț pentru sărbători : $" + cart.calculateTotal());
    }

}
