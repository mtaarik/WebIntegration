package org.example.service;

import org.example.model.Sale;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SaleService {
    private static Map<Long, Sale> sales = new ConcurrentHashMap<>();
    private static AtomicLong idCounter = new AtomicLong(1);

    public List<Sale> getAllSales() {
        return new ArrayList<>(sales.values());
    }

    public Sale getSaleById(Long id) {
        return sales.get(id);
    }

    public Sale addSale(Sale sale) {
        if (sale.getId() == null) {
            sale.setId(idCounter.getAndIncrement()); // Génération auto ID [cite: 93]
        }
        sale.setTotal(sale.getPrice() * sale.getQuantity()); // Calcul total [cite: 93]
        sales.put(sale.getId(), sale);
        return sale;
    }

    public boolean deleteSale(Long id) {
        return sales.remove(id) != null;
    }

    public int countSales() {
        return sales.size();
    }
}