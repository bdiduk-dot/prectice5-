package com.practice.marketplace

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CartTest {

    @Test
    fun testAddProduct() {
        val cart = Cart()
        val product = Product(1, "Test Product", 10.0)
        
        cart.addProduct(product)
        
        assertEquals(1, cart.products.size)
        assertEquals(product, cart.products[0])
    }

    @Test
    fun testRemoveProduct() {
        val cart = Cart()
        val product = Product(1, "Test Product", 10.0)
        
        cart.addProduct(product)
        assertEquals(1, cart.products.size)
        
        cart.removeProduct(product)
        assertEquals(0, cart.products.size)
    }

    @Test
    fun testTotalPrice() {
        val cart = Cart()
        val product1 = Product(1, "Product 1", 10.0)
        val product2 = Product(2, "Product 2", 15.0)
        
        cart.addProduct(product1)
        cart.addProduct(product2)
        
        assertEquals(25.0, cart.totalPrice())
    }
}