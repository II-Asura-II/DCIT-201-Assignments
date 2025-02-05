import CommissionEmployee

def main():
    commission_employee = CommissionEmployee.CommissionEmployee("John", "Smith", 123456789, 0.1, 10000)
    print("Original Values")
    print("Gross sales:", commission_employee.get_gross_sales())
    print("Commission rate:", commission_employee.get_commission_rate())
    print("Earnings:", commission_employee.earnings())

    commission_employee.set_gross_sales(20000)
    commission_employee.set_commission_rate(0.2)
    
    print("\nNew Values")
    print("Gross sales:", commission_employee.get_gross_sales())
    print("Commission rate:", commission_employee.get_commission_rate())
    print("Earnings:", commission_employee.earnings())

main()