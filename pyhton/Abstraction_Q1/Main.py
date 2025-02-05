import FullTimeEmployee

def main():
    full_time_employee = FullTimeEmployee.FullTimeEmployee("John Doe", "J001", 5000)
    print(f"""Name: {full_time_employee.get_name()}
Employee ID: {full_time_employee.get_employee_id()}""")
    print("Salary:", full_time_employee.get_salary())
    print(full_time_employee.calculate_pay())

main()