package imc;

import java.util.Calendar;
import java.util.Date;

public class Person {
	
	public static enum _sex{
	    male, female
	}


	static public Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

	static public String printBMITable(Double weight, Double height, Person._sex sex) {
        double BMI = Person.calculateBMI(weight, height);
        String result = "";
        if(sex == _sex.male){
            
            if(BMI < 20.7){
                result = "Abaixo do peso";
            } else if(BMI < 26.4){
                result = "Peso normal";
            } else if(BMI < 27.8){
                result = "Marginalmente acima do peso";
            } else if(BMI < 31.1){
                result = "Acima do peso ideal";
            } else{
                result = "Obeso";
            }
        }else if(sex == _sex.female){
            if(BMI < 19.1){
                result = "Abaixo do peso";
            } else if(BMI < 25.1){
                result = "Peso normal";
            } else if(BMI < 27.3){
                result = "Marginalmente acima do peso";
            } else if(BMI < 32.3){
                result = "Acima do peso ideal";
            } else{
                result = "Obesa";
            }
        }

       return result;
    }


    public static Integer getAge(Date dateOfBirth) {
	    int age = 0;
	    Calendar born = Calendar.getInstance();
	    Calendar now = Calendar.getInstance();
	    if(dateOfBirth!= null) {
	        now.setTime(new Date());
	        born.setTime(dateOfBirth);  
	        if(born.after(now)) {
	            throw new IllegalArgumentException("Can't be born in the future");
	        }
	        age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);             
	        if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR))  {
	            age-=1;
	        }
	    }  
	    return age;
	}
}
