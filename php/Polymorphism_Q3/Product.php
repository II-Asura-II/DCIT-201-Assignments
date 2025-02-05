<?php
abstract class Product
{
    private $productId;
    private $productName;
    private $basePrice;
    public function getBasePrice()
    {
        return $this->basePrice;
    }

    public function __construct($productId, $productName, $basePrice)
    {
        $this->productId = $productId;
        $this->productName = $productName;
        $this->basePrice = $basePrice;
    }

    public function applyDiscount($percentage)
    {
        if ($percentage < 1 && $percentage > 0) {
            $this->basePrice -= $this->basePrice * $percentage;
        } elseif ($percentage > 1) {
            $percentage /= 100;
            $this->basePrice -= $this->basePrice * $percentage;
        }
    }

    public abstract function calculateFinalPrice();
}
?>