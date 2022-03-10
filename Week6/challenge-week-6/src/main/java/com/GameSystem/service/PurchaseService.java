package com.GameSystem.service;

import com.GameSystem.model.Purchase;
import com.GameSystem.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService
{
    @Autowired
    private IPurchaseRepository purchaseRepository;

    public List<Purchase>listPurchases()
    {
        return this.purchaseRepository.findAll();
    }

    public Purchase getPurchase(Integer id)
    {
        return this.purchaseRepository.findById(id).get();
    }

    public void savePurchase(Purchase purchase)
    {
        this.purchaseRepository.save(purchase);
    }

    public void deletePurchase(Integer id)
    {
        this.purchaseRepository.deleteById(id);
    }
}
