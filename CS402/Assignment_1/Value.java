import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {
    private double curr_value = 0;

    double getValue() {
    	return this.curr_value;
    }
    
    void setValue(double value) {
    	this.curr_value = value;
    }
    
    double add(double value_to_add) {
    	double calc_value = this.curr_value + value_to_add;
    	setValue(calc_value);
    	
        return calc_value;
    }

   double subtract(double value_to_subtract) {
   	double calc_value = this.curr_value - value_to_subtract;
   	setValue(calc_value);
   	
       return calc_value;
    }
    
    double multiply(double value_to_multiply) {
    	double calc_value = this.curr_value * value_to_multiply;
    	setValue(calc_value);
    	
        return calc_value;
    }
    
    double divide(double value_to_divide) {
    	double calc_value = this.curr_value / value_to_divide;
    	setValue(calc_value);
    	
        return calc_value;
    }
    
    double power(double power_value) {
    	double calc_value = Math.pow(this.curr_value, power_value);
    	setValue(calc_value);
    	
        return calc_value;
    }
    
    double sqrt() {
    	double calc_value = Math.sqrt(this.curr_value);
    	setValue(calc_value);
    	
        return calc_value;
    }
    
    double n_root(int n_root_value) {
    	double calc_value = Math.round(Math.pow(this.curr_value, (1 / n_root_value)));
    	setValue(calc_value);
    	
        return calc_value;
    }
    
    double reset() {
    	setValue(0);
        return getValue();
    }
    
}
