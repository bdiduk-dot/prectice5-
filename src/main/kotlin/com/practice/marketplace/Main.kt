package com.practice.marketplace

fun main() {
    // Define test products
    val products = listOf<Product>(
        Product(1, "Laptop", 999.99),
        Product(2, "Mouse", 25.50),
        Product(3, "Keyboard", 75.0),
        Product(4, "Monitor", 200.0),
        Product(5, "Tablet", 299.99)
    )

    val cart = Cart()
    val addAction = AddProductAction()
    val removeAction = RemoveProductAction()
    val viewAction = ViewCartAction()

    while (true) {
        println("\n=== Marketplace ===")
        println("+----+-----------+--------+")
        println("| ID | Product   | Price  |")
        println("+----+-----------+--------+")
        for (p in products) {
            println("| %-2d | %-9s | $%-5.2f |".format(p.id, p.name, p.price))
        }
        println("+----+-----------+--------+")
        println("Choose action: add <id>, remove <id>, view, exit")

        val input = readLine()?.trim() ?: continue
        if (input == "exit") break

        when {
            input.startsWith("add") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                val product = products.find { it.id == id }
                if (product != null) {
                    addAction.execute(cart, product)
                } else {
                    println("Invalid product ID")
                }
            }

            input.startsWith("remove") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                val product = products.find { it.id == id }
                if (product != null) {
                    removeAction.execute(cart, product)
                } else {
                    println("Invalid product ID")
                }
            }

            input == "view" -> {
                viewAction.execute(cart)
            }
            else -> println("Invalid command. Use: add <id>, remove <id>, view, exit")
        }
    }
    
    println("Thank you for using Marketplace!")
}