import BasePlusCommmissionEmployee as BPC

def main():
    base_plus_commission_employee = BPC.BasePlusCommissionEmployee("Bob", "Lewis", 123456789, 0.1, 10000, 300)
    print("Original Values")
    print("Gross sales:", base_plus_commission_employee.get_gross_sales())
    print("Commission rate:", base_plus_commission_employee.get_commission_rate())
    print("Base salary:", base_plus_commission_employee.get_base_salary())
    print("Earnings:", base_plus_commission_employee.earnings())

    base_plus_commission_employee.set_gross_sales(20000)
    base_plus_commission_employee.set_commission_rate(0.2)
    base_plus_commission_employee.set_base_salary(500)
    
    print("\nNew Values")
    print("Gross sales:", base_plus_commission_employee.get_gross_sales())
    print("Commission rate:", base_plus_commission_employee.get_commission_rate())
    print("Base salary:", base_plus_commission_employee.get_base_salary())
    print("Earnings:", base_plus_commission_employee.earnings())

main()