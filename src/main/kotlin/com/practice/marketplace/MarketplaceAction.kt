package com.practice.marketplace

// Дія додавання продукту
class AddProductAction {
    fun execute(cart: Cart, product: Product) {
        cart.addProduct(product)
    }
}

// Дія видалення продукту
class RemoveProductAction {
    fun execute(cart: Cart, product: Product) {
        cart.removeProduct(product)
    }
}

// Дія перегляду корзини
class ViewCartAction {
    fun execute(cart: Cart) {
        println("\n=== Your Cart ===")
        if (cart.products.isEmpty()) {
            println("Cart is empty")
        } else {
            println("+----+-----------+--------+")
            println("| ID | Product   | Price  |")
            println("+----+-----------+--------+")
            for (product in cart.products) {
                println("| %-2d | %-9s | $%-5.2f |".format(product.id, product.name, product.price))
            }
            println("+----+-----------+--------+")
            println("Total: $${cart.totalPrice()}")
        }
    }
}