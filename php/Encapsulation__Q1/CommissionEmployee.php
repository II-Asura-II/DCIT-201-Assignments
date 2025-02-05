<?php
class CommissionEmployee
{
    private $firstName;
    private $lastName;
    private $socialSecurityNumber;
    private $grossSales;
    private $commissionRate;

    public function setGrossSales($grossSales)
    {
        try {
            $this->grossSales = $grossSales;
            if ($grossSales < 0) {
                throw new Exception("Gross Sales must be greater than or equal to zero.");
            }
        } catch (Exception $e) {
            throw new Exception($e->getMessage());
        }
    }
    public function setCommissionRate($commissionRate)
    {
        try {
            $this->commissionRate = $commissionRate;
            if ($commissionRate < 0 || $commissionRate > 1) {
                throw new Exception("Commission Rate must be between zero and one.");
            }
        } catch (Exception $e) {
            throw new Exception($e->getMessage());
        }
    }

    public function __construct($firstName, $lastName, $socialSecurityNumber, $grossSales, $commissionRate)
    {
        $this->firstName = $firstName;
        $this->lastName = $lastName;
        $this->socialSecurityNumber = $socialSecurityNumber;
        $this->setCommissionRate($commissionRate);
        $this->setGrossSales($grossSales);
    }

    protected function getFirstName()
    {
        return $this->firstName;
    }

    protected function getLastName()
    {
        return $this->lastName;
    }

    protected function getSocialSecurityNumber()
    {
        return $this->socialSecurityNumber;
    }

    protected function getGrossSales()
    {
        return $this->grossSales;
    }

    protected function getCommissionRate()
    {
        return $this->commissionRate;
    }

    public function earnings()
    {
        return "GHS " . number_format($this->grossSales * $this->commissionRate, 2, ".", ",");
    }
}
?>