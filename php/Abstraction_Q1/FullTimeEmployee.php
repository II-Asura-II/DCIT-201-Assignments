<?php
include("Abstraction_Q1/Employee.php");

class FullTimeEmployee extends Employee
{
    private $salary;

    public function setSalary($salary)
    {
        try {
            $this->salary = $salary;
            if ($this->salary < 0) {
                throw new Exception("Salary must be greater than 0");
            }
        } catch (Exception $e) {
            throw new Exception($e->getMessage());
        }
    }

    public function __construct($name, $employeeId, $salary)
    {
        parent::__construct($name, $employeeId);
        $this->setSalary($salary);
    }

    protected function getSalary()
    {
        return $this->salary;
    }

    public function calculatePay()
    {
        return "FullTimeEmployee Pay: GHS" . number_format($this->salary, 2, ".", ",");
    }

    public function display()
    {
        return "Employee Name: " . $this->getName() . "\nEmployee ID: " . $this->getEmployeeId();
    }
}
?>