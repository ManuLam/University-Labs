import javax.ejb.*;
import javax.jws.WebService;

@Stateless
@WebService
public class AdvanceCalculator {
    public static Value value = new Value();
    
    public double add(double value_to_add) {
    	double pre_value = value.getValue();
    	double post_value = value.add(value_to_add);
    	
    	System.out.printf("### Service is being called ###\n %.3f + %.3f = %.3f\n", pre_value, value_to_add, post_value);
    	
    	return post_value;
    }
    
    public double subtract(double value_to_subtract) {
    	double pre_value = value.getValue();
    	double post_value = value.subtract(value_to_subtract);
    	
    	System.out.printf("### Service is being called ###\n %.3f - %.3f = %.3f\n", pre_value, value_to_subtract, post_value);
    	
    	return post_value;
    }
    
    
    public double multiply(double value_to_multiply) {
    	double pre_value = value.getValue();
    	double post_value = value.multiply(value_to_multiply);
    	
    	System.out.printf("### Service is being called ###\n %.3f * %.3f = %.3f\n", pre_value, value_to_multiply, post_value);
    	
    	return post_value;
    }
    
    public double divide(double value_to_divide) {
    	if (value_to_divide <= 0) {
    		return 0;
    	}
    	
    	double pre_value = value.getValue();
    	double post_value = value.divide(value_to_divide);
    	
    	System.out.printf("### Service is being called ###\n %.3f / %.3f = %.3f\n", pre_value, value_to_divide, post_value);
    	
    	return post_value;
    }
    
    
    public double power(int power_value) {
    	double pre_value = value.getValue();
    	double post_value = value.power(power_value);
    	
    	System.out.printf("### Service is being called ###\n %.3f ^ %d = %.3f\n", pre_value, power_value, post_value);
    	
    	return post_value;
    }
    
    public double square_root() {
    	double pre_value = value.getValue();
    	double post_value = value.sqrt();
    	
    	System.out.printf("### Service is being called ###\n sqrt(%.3f) = %.3f\n", pre_value, post_value);
    	
    	return post_value;
    }
    
    public double n_root(int n_root_value) {
    	double pre_value = value.getValue();
    	double post_value = value.divide(n_root_value);
    	
    	System.out.printf("### Service is being called ###\n %d_root(%.3f) = %.3f\n", n_root_value , pre_value, post_value);
    	
    	return post_value;
    }
    
    public double fraction(double numerator) {
    	double pre_value = value.getValue();
    	double post_value = value.divide(numerator);
    	
    	System.out.printf("### Service is being called ###\n Fraction form = %.3f/%.3f\n", numerator , pre_value);
    	
    	return post_value;
    }
    
    public double get_current_value() {
    	double get_value = value.getValue();
    	System.out.printf("### Service is being called ###\n Current value is %.3f\n", get_value);
    	
        return get_value;
    }
    
    
    public double resetCalculator() {
    	System.out.printf("### Service is being called ###\n Calculator has been reset.\n");
    	
    	return value.reset();
    }
    
}
    