package com.example.electronicgadgets

object ProductRepository {
    val products = ArrayList<Product>()

    init {
        products.add(Product("prod1","ipad","iPad", "iPad Pro 11-inch", 400.0, "apple"))
        products.add(Product("prod2","macbook","MacBook M3 Pro", "12-core CPU\n18-core GPU", 2500.0, "apple"))
        products.add(Product("prod3","dell_laptop","Dell Inspiron", "13th Gen Intel® Core™ i7", 1499.0, "dell"))
        products.add(Product("prod4","keyboard","Logitech Keyboard", "Logitech - PRO X\nTKL LIGHTSPEED Wireless", 199.0, "logitech"))
        products.add(Product("prod5","mouse","Logitech mouse", "Logitech Mouse- PRO X\nTKL Wireless", 99.0, "logitech"))
    }
}

