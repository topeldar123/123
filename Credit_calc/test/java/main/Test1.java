package main;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test1 {

	@Test
	void test() {
		/**
	   	  * �������� ���������� ������ Credit_Calc
	   	  */
	   	 Credit_Calculator test = new Credit_Calculator();
	   	 /**
	   	  * ����� ������ ������� ������� � ���������� �������
	   	  */
	   	 test.calculate_anuity(10000, 12, 5, 1, 1);
	   	 /**
	   	  * ���������� ���������� summa ����������� ���������� ����� ����� ����������� �������� �� �������		
	   	  */
	   	 double summa = test.getSumm_anuity();
	   	 /**
	   	  * ��������� �������� ���������� summa � ������ ���������		         
	   	  */
	   	 assertEquals(summa, 10286.9);
		}
	}


