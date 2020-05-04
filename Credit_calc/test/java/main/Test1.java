package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test() {
		/**
	   	  * создание экземпл€ра класса Credit_Calc
	   	  */
	   	 Credit_Calculator test = new Credit_Calculator();
	   	 /**
	   	  * вызов метода расчета кредита с введенными данными
	   	  */
	   	 test.calculate_anuity(10000, 12, 5, 1, 1);
	   	 /**
	   	  * присвоение переменной summa результатов вычислени€ общей суммы аннуитетных платежей по кредиту		
	   	  */
	   	 double summa = test.getSumm_anuity();
	   	 /**
	   	  * сравнение значени€ переменной summa с верным значением		         
	   	  */
	   	 assertEquals(summa, 10286.9);
		}
	}


