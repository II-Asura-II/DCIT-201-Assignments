<?php
class Cart
{
    private $products = array();

    public function addProduct(Product $product)
    {
        array_push($this->products, $product);
    }

    public function getProducts()
    {
        return $this->products;
    }

    public function calculateTotalPrice()
    {
        $totalPrice = 0;
        foreach ($this->products as $product) {
            $totalPrice += $product->getBasePrice();
        }
        return "GHS " . number_format($totalPrice, 2, ".", ",");
    }
}
?>