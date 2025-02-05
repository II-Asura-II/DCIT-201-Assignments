<?php
include("Inheritantce_Q1/BasePlusCommissionEmployee.php");

$b = new BasePlusCommissionEmployee("Aziz2", "Basit2", 12345676, 162735, 0.2, 237367);

echo "Original Values\n";
echo $b->display() . "\n";

$b->setCommissionRate(0.6);
$b->setGrossSales(7353770);
$b->setBaseSalary(5373570);

echo "\nUpdated Values\n";
echo $b->display();
?>