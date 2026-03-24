package org.example.service;

import org.example.model.Sale;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SaleService {

    private static SaleService instance;
    private Map<Long, Sale> sales = new ConcurrentHashMap<>();
    private AtomicLong idCounter = new AtomicLong(1);

    private SaleService() {
    }

    public static synchronized SaleService getInstance() {
        if (instance == null) {
            instance = new SaleService();
        }
        return instance;
    }

    public List<Sale> getAllSales() {
        return new ArrayList<>(sales.values());
    }

    public Sale getSaleById(Long id) {
        return sales.get(id);
    }

    public Sale addSale(Sale sale) {
        if (sale.getId() == null) {
            sale.setId(idCounter.getAndIncrement());
        }
        sale.setTotal(sale.getPrice() * sale.getQuantity());
        sales.put(sale.getId(), sale);
        return sale;
    }

    public Sale updateSale(Long id, Sale sale) {
        if (!sales.containsKey(id)) {
            return null;
        }
        sale.setId(id);
        sale.setTotal(sale.getPrice() * sale.getQuantity());
        sales.put(id, sale);
        return sale;
    }

    public boolean deleteSale(Long id) {
        return sales.remove(id) != null;
    }

    public int countSales() {
        return sales.size();
    }
}