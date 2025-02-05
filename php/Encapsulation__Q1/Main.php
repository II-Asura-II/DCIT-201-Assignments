<?php
include("Encapsulation__Q1/CommissionEmployee.php");

$a = new CommissionEmployee('Aziz', 'Basit', 123456, 345688, 0.2);
echo "Original Values\n";
echo $a->earnings() . "\n";

$a->setCommissionRate(0.4);
$a->setGrossSales(123470);

echo "\nUpdated Values\n";
echo $a->earnings();
?>