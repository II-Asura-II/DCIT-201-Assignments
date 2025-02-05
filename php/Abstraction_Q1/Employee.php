<?php
abstract class Employee
{
    private $name;
    private $employeeId;

    public function __construct($name, $employeeId)
    {
        $this->name = $name;
        $this->employeeId = $employeeId;
    }

    protected function getName()
    {
        return $this->name;
    }

    protected function getEmployeeId()
    {
        return $this->employeeId;
    }

    public abstract function calculatePay();
}
?>