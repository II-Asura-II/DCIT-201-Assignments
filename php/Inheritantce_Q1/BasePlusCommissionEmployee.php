<?php
include("Encapsulation__Q1/CommissionEmployee.php");
class BasePlusCommissionEmployee extends CommissionEmployee
{
    private $baseSalary;

    public function setBaseSalary($baseSalary)
    {
        try {
            $this->baseSalary = $baseSalary;
            if ($baseSalary < 0) {
                throw new Exception("Base Salary must be greater than or equal to zero.");
            }
        } catch (Exception $e) {
            throw new Exception($e->getMessage());
        }
    }


    function __construct($firstName, $lastName, $socialSecurityNumber, $grossSales, $commissionRate, $baseSalary)
    {
        parent::__construct($firstName, $lastName, $socialSecurityNumber, $grossSales, $commissionRate);
        $this->setBaseSalary($baseSalary);
    }

    public function earnings()
    {
        return "GHS " . number_format($this->baseSalary + ($this->getGrossSales() * $this->getCommissionRate()), 2, ".", ",");
    }

    public function format($num)
    {
        return "GHS " . number_format($num, 2, ".", ",");
    }

    public function display()
    {
        return "\nName: " . $this->getFirstName() . " " . $this->getLastName() . "\nSocial Security: " . $this->getSocialSecurityNumber() . "\nBase Salary: " . $this->format($this->baseSalary) . "\nGross Sales: " . $this->format($this->getGrossSales()) . "\nCommission Rate: " . $this->getCommissionRate() . "\nTotal Earnings: " . $this->earnings();
    }
}
?>