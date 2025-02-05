<?php
include("Abstraction_Q1/FullTimeEmployee.php");

$a = new FullTimeEmployee("Aziz3", 123456, 345688);
echo "Original Salary\n" . $a->display();
echo "\n" . $a->calculatePay() . "\n";
$a->setSalary(2435756);
echo "\nModified Salary\n" . $a->display();
echo "\n" . $a->calculatePay();
?>