class CommissionEmployee:
    def __init__(self, first_name, last_name, social_security_number, commission_rate, gross_sales):
        self.first_name = first_name
        self.last_name = last_name
        self.social_security_number = social_security_number
        self.set_gross_sales(gross_sales)
        self.set_commission_rate(commission_rate)
        
    def get_first_name(self):
        return self.first_name
    
    def get_last_name(self):
        return self.last_name
    
    def get_social_security_number(self):
        return self.social_security_number
    
    def get_commission_rate(self):
        return self.commission_rate
    
    def get_gross_sales(self):
        return self.gross_sales
    
    def set_first_name(self, first_name):
        self.first_name = first_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def set_social_security_number(self, social_security_number):
        self.social_security_number = social_security_number

    def set_commission_rate(self, commission_rate):
        try:
            self.commission_rate = commission_rate
            if commission_rate < 0 or commission_rate > 1:
                raise ValueError
        except ValueError:
            print("Commission rate must be between 0 and 1")

    def set_gross_sales(self, gross_sales):
        try:
            self.gross_sales = gross_sales
            if gross_sales < 0:
                raise ValueError
        except ValueError:
            print("Gross sales must be greater than 0")

    def earnings(self):
        return self.commission_rate*self.gross_sales