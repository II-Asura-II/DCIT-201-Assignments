<?php
include("Polymorphism_Q3/Product.php");
include("Polymorphism_Q3/Cart.php");

class Electronics extends Product
{
    public function __construct($productId, $productName, $basePrice)
    {
        parent::__construct($productId, $productName, $basePrice);
    }

    public function calculateFinalPrice()
    {
        return "GHS " . number_format($this->getBasePrice(), 2, ".", ",");
    }

}
class Clothing extends Product
{
    public function __construct($productId, $productName, $basePrice)
    {
        parent::__construct($productId, $productName, $basePrice);
    }

    public function calculateFinalPrice()
    {
        return "GHS " . number_format($this->getBasePrice(), 2, ".", ",");
    }

}

$Laptop = new Electronics("E001", 'Laptop', 1000);
$Jacket = new Clothing("C001", "Winter Jacket", 200);

echo "Original Price of laptop: " . $Laptop->calculateFinalPrice() . "\n";
$Laptop->applyDiscount(10);
echo "Discount of 10% applied to laptop: " . $Laptop->calculateFinalPrice() . "\n";
echo "Price of Winter Jacket: " . $Jacket->calculateFinalPrice() . "\n";

$cart = new Cart();

$cart->addProduct($Laptop);
$cart->addProduct($Jacket);

echo "Total Price: " . $cart->calculateTotalPrice();
?>