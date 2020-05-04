package main;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class Credit_Calculator {
	/** �������� ����������, ��������� 
	 *  � ����� ������ ������ **/
	
	/** ���������� - ����� ������� **/
	private static double 	var_sum;
	/** ���������� - ���� ������� **/
	private static int 		var_period;
	/** ���������� - �������� �� ������� **/
	private static double 	var_percent;
	/** ���������� - ����������� �������� **/
	private static double 	var_month_com;
	/** ���������� - �������������� �������� **/
	private static double 	var_onetime_com;
	/** ���������� - ������� ��������� ����� ������� **/
	private static String 	var_box_period;
	/** ���������� - ��� �������� ������� **/
	private static String 	var_box_type;
	/** ������ �� 3 ���������� ��� ������ ���� ������ ������ **/
	private static int [] 	var_box_date = new int [3];

	/** ��������� ������ ������������� ��������� **/
	private static GregorianCalendar calendar = new GregorianCalendar();
	/** ����������, ���������� ����� ��� ������� ���� **/
	private static int day_now = calendar.get(Calendar.DAY_OF_MONTH);
	/** ����������, ���������� ����� ������ ������� ���� **/
	private static int month_now = calendar.get(Calendar.MONTH);
	/** ����������, ���������� ����� ���� ������� ���� **/
	private static int year_now = calendar.get(Calendar.YEAR);
		
	public static void main(String[] args) {

		/* ����������� ���� � ����������� ��������� */
		JFrame window = new JFrame("��������� �����������");
		/* ����� �� ��������� ��� �������� ���� */
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* ������� �������� ���� */
		window.setSize(360, 560);
		/* ������ �� ��������� �������� ���� */
		window.setResizable(false);
		/* ������������ ���� �� ������ ������ */
		window.setLocationRelativeTo(null);
		
		/* ������ ��� ������������ ����������� ��������� ���������� */
		JPanel mainPanel=new JPanel();
		/* ���������� ����������� ����������:
		 * ������������ ��������� ������������ ������� */
		mainPanel.setLayout(null);
		
		/* ����� ������ ��� ��������� ����� ����� 
		 * ����� Dialog, ���������� �������, ������ 25 */
		Font textfield_font = new Font("Dialog", Font.PLAIN, 25);
		
		/* �������� ��������� ����� �����*/
		
		/* ���� � ����� ������� */
		final JTextField SummaField = new JTextField();
		/* ���� � ���� ������� */
		final JTextField PeriodField = new JTextField();
		/* ���� � ������� �� ������� */
		final JTextField PercentField = new JTextField();
		/* ���� � ����������� �������� */
		final JTextField CommissionField = new JTextField();
		/* ���� � �������������� �������� */
		final JTextField OnetimeField = new JTextField();
		
		/* ��������� ������ CreateFields */		
		CreateFields create = new CreateFields();
		/* ����� ������ ��� ���������� �������� */
		create.addPanel(mainPanel);
		
		/* ������� ���������� ��� ��������� ����� �����
		 * �� ����� (��� ����, ���������� �, ���������� �, ������, ������, �����) */
		create.CreateTextField(SummaField, 20, 20, 300, 30, textfield_font);
		create.CreateTextField(PeriodField, 20, 80, 218, 30, textfield_font);
		create.CreateTextField(PercentField, 20, 140, 300, 30, textfield_font);
		create.CreateTextField(CommissionField, 20, 345, 300, 30, textfield_font);
		create.CreateTextField(OnetimeField, 20, 405, 300, 30, textfield_font);
		
		/* ����� ������ ��� ��������� ����� �������� 
		 * ����� Arial, ���������� ������, ������ 15 */
		Font label_font = new Font("Arial", Font.BOLD, 15);
		
		/* �������� ��������� ����� �������� */
		JLabel sum_label = new JLabel("����� �������, ���");
		JLabel period_label = new JLabel("���� �������");
		JLabel percent_label = new JLabel("���������� ������ (� ���), %");
		JLabel type_label = new JLabel("��� ��������");
		JLabel day_label = new JLabel("����");
		JLabel month_label = new JLabel("�����");
		JLabel year_label = new JLabel("���");
		JLabel date_label = new JLabel("���� ������ �������");
		JLabel comission_label = new JLabel("����������� ��������, %");
		JLabel onetime_label = new JLabel("�������������� ��������, %");
		
		/* ������� ���������� ��� ��������� ����� ��������
		 * �� ����� (��� ����, ���������� �, ���������� �, ������, ������, �����) */
		create.CreateLabel(sum_label, 20, 55, 390, 15, label_font);
		create.CreateLabel(period_label, 20, 115, 390, 15, label_font);
		create.CreateLabel(percent_label, 20, 175, 390, 15, label_font);
		create.CreateLabel(type_label, 20, 235, 390, 15, label_font);
		create.CreateLabel(day_label, 20, 295, 390, 15, label_font);
		create.CreateLabel(month_label, 100, 295, 390, 15, label_font);
		create.CreateLabel(year_label, 180, 295, 360, 15, label_font);
		create.CreateLabel(date_label, 20, 320, 390, 15, label_font);
		create.CreateLabel(comission_label, 20, 380, 390, 15, label_font);
		create.CreateLabel(onetime_label, 20, 440, 390, 15, label_font);

		/* ����� ������ ��� ���������� �������
		 * ����� Dialog, ���������� �������, ������ 20 */
		Font combobox_font = new Font("Dialog", Font.PLAIN, 20);
		
        /* ��������� ������ � ������� ��������� ����� ������� */
		String[] period = {
				"���.",
				"���"
		};
		
		/* ���������� ������ � ������� ��������� ����� ������� */
		JComboBox period_box = new JComboBox(period);		
		/* ������ ���������� �������� �� ������ � ���������� */
		var_box_period = (String)period_box.getSelectedItem();
		
		/* �������� ��������� �������� */
		ActionListener period_Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* ���������� ������� ������� */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* ������ ���������� �������� �� ������ � ���������� */
		    	var_box_period = (String)box.getSelectedItem();
		    }
		};
		/* ���������� ��������� � ������� */
		period_box.addActionListener(period_Listener);

		
		/* ��������� ������ � ���� �������� �� ������� */
		String[] type = {
				"�����������",
				"������������������"
		};
		
		/* ���������� ������ � ���� �������� �� ������� */
		JComboBox type_box = new JComboBox(type);
		/* ������ ���������� �������� �� ������ � ���������� */
		var_box_type = (String)type_box.getSelectedItem();
		
		/* �������� ��������� �������� */	
		ActionListener type_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* ���������� ������� ������� */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* ������ ���������� �������� �� ������ � ���������� */
		    	var_box_type = (String)box.getSelectedItem();
		    }
		};
		/* ���������� ��������� � ������� */
		type_box.addActionListener(type_Listener);
				
		/* ��������� ������ � ������ ���� ������ */
		String[] days = new String [31];
		/* ���������� ������� ������� �� 1 �� 31 */
		for (int i = 1; i<=31; i++) {
			days[i-1] = "" + i;
		}
		
		/* ���������� ������ � ����� ��� ���� ������ ������ */
		final JComboBox day_box = new JComboBox(days);
		/* ��������� ���������� �������� �� ������� ���� */
		day_box.setSelectedIndex(day_now-1);
		/* ������ ���������� �������� �� ������ � ���������� */
		var_box_date[0] = Integer.parseInt((String)day_box.getSelectedItem());
		
		/* �������� ��������� �������� */
		ActionListener day_Listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* ���������� ������� ������� */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* ������ ���������� �������� �� ������ � ���������� */
		    	String str = (String)box.getSelectedItem();
		    	/* ������� �� ���������� ���� � ������������� */
		    	var_box_date[0] = Integer.parseInt(str);
		    }
		};
		/* ���������� ��������� � ������� */
		day_box.addActionListener(day_Listener);
		
		/* ��������� ������ � ������ ������� */
		String[] month = new String [12];
		/* ���������� ������� ������� �� 1 �� 12 */
		for (int i = 1; i<=12; i++) {
			month[i-1] = "" + i;
		}
		
		/* ���������� ������ � ����� ������ ���� ������ ������ */
		final JComboBox month_box = new JComboBox(month);
		/* ��������� ���������� �������� �� ������� ���� */
		month_box.setSelectedIndex(month_now);
		/* ������ ���������� �������� �� ������ � ���������� */
		var_box_date[1] = Integer.parseInt((String)month_box.getSelectedItem());
		
		/* �������� ��������� ��������**/
		ActionListener month_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* ���������� ������� ������� */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* ������ ���������� �������� �� ������ � ���������� */
		    	String str = (String)box.getSelectedItem();
		    	/* ������� �� ���������� ���� � ������������� */
		    	var_box_date[1] = Integer.parseInt(str);
		    }
		};
		/* ���������� ��������� � ������� */
		month_box.addActionListener(month_Listener);
		
		/* ��������� ������ � ������ �����, 
		 * ����� ����� �������� ������ */
		String[] years = new String [10];
		/* ���������� ������� �������: 
		 * �������� ��� + 9 ����������� ��� */
		for (int i = 0; i<10; i++) {
			years[i] = "" + (i + year_now);
		}
		
		/* ���������� ������ � ����� ���� ���� ������ ������ */
		final JComboBox year_box = new JComboBox(years);
		/* ������ ���������� �������� �� ������ � ���������� */
		var_box_date[2] = Integer.parseInt((String)year_box.getSelectedItem());
		
		/* �������� ��������� �������� */
		ActionListener year_Listener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	/* �������� ������� ������� */
		    	JComboBox box = (JComboBox)e.getSource();
		    	
		    	/* ������ ���������� �������� �� ������ � ���������� */
		    	String str = (String)box.getSelectedItem();
		    	/* ������� �� ���������� ���� � ������������� */
		    	var_box_date[2] = Integer.parseInt(str);
		    }
		};
		/* ���������� ��������� � ������� */
		year_box.addActionListener(year_Listener);
		
		/* ������� ���������� ��� ���������� �������
		 * �� ����� (��� ����, ���������� �, ���������� �, ������, ������, �����) */
		create.CreateComboBox(period_box, 243, 80, 77, 30, combobox_font);
		create.CreateComboBox(type_box, 20, 200, 300, 30, combobox_font);
		create.CreateComboBox(day_box, 20, 260, 60, 30, combobox_font);
		create.CreateComboBox(month_box, 100, 260, 60, 30, combobox_font);
		create.CreateComboBox(year_box, 180, 260, 85, 30, combobox_font);	

		/* ����� ������ ��� ������
		 * ����� Arial, ���������� �������, ������ 25 */
		Font button_font = new Font("Arial", Font.PLAIN, 25);
		
		/* ������ ��� ������� � ������ ����������� */
		JButton result_button = new JButton ("���c������");
		/* ������� ���������� ��� ������ �� ����� 
		 * (��� ����, ���������� �, ���������� �, ������, ������, �����) */
		create.CreateButton(result_button, 20, 465, 300, 45, button_font);

		/* ���������� ��������� ��� ������ */
		result_button.addMouseListener( new MouseAdapter()			
		{
			/** ����� ��������� ������� �� ������ **/
			public void mouseClicked(MouseEvent event) {
				/* ������� �������� ���������� */
				check = true;
				
				/* ����� ������ �������� ��������� ������
				 * �� ����� (��� ����, ����������� ��������, ������������ ��������) */
				Credit_Calculator.control(SummaField, 10000, 5000000);
				Credit_Calculator.control(PeriodField, 1, 360);
				if (var_box_period == "���") Credit_Calculator.control(PeriodField, 1, 30);
				Credit_Calculator.control(PercentField, 5, 40);
				Credit_Calculator.control(CommissionField, 0, 5);
				Credit_Calculator.control(OnetimeField, 0, 3);
				/* ��������� ���������� ������ ��� ������� ������ ����� */
				if (!check) return;

				/* ���������� ���������� ��������� �������� �� ����� */
				var_sum = Double.parseDouble(SummaField.getText());
				var_period = Integer.parseInt(PeriodField.getText());
				var_percent  = Double.parseDouble(PercentField.getText());
				var_month_com = Double.parseDouble(CommissionField.getText());
				var_onetime_com = Double.parseDouble(OnetimeField.getText());
				var_box_date[0] = Integer.parseInt((String)day_box.getSelectedItem());
				var_box_date[1] = Integer.parseInt((String)month_box.getSelectedItem());
				var_box_date[2] = Integer.parseInt((String)year_box.getSelectedItem());
				
				/* ����� ������ ��������� ���� */
				Credit_Calculator.time();
				/* ����� ������ ������� ���� �������� �� ���������*/
				Credit_Calculator.commission();
				
				/* ����� ������������� ������, � ����������� �� ���������� ���� �������� */
				if (var_box_type.equals("�����������")) {
					Credit_Calculator.calculate_anuity(var_sum, var_period, var_percent, var_month_com, var_onetime_com);
					Credit_Calculator.window_anuity();
				}else {
					Credit_Calculator.calculate_diff(var_sum, var_period, var_percent, var_month_com, var_onetime_com);
					Credit_Calculator.window_diff();
				}
			}
		});
		/* ���������� ������ � ���� */
		window.setContentPane(mainPanel);
		/* ������� ��������� ���� */
		window.setVisible(true);
	}
	
	/** ������ � ������ ������ ���� **/
	private static DateFormat date_format = new SimpleDateFormat("dd.MM.yyyy");
	/** ����� ��������� ����**/
	private static void time() {
		/* ���������� ������� ���� ������� ��������� */
		calendar.set(Calendar.YEAR, var_box_date[2]);
		calendar.set(Calendar.MONTH, var_box_date[1]-1);
		calendar.set(Calendar.DAY_OF_MONTH, var_box_date[0]);
		
		if (var_box_period == "���") {
			var_period *= 12;
		}
	}
	
	/** ����� ������� ���� ������ �� ��������� **/
	private static void commission() {
		/* ���������� ����� ������� �� ����������� �������� */
		if (var_month_com != 0) {
			var_month_com = (Math.rint(100*((var_sum * var_month_com)/100)))/100;
		}
		/* ���������� ����� ������� �� �������������� �������� */
		if (var_onetime_com != 0) {
			var_onetime_com = (Math.rint(100*((var_sum * var_onetime_com)/100)))/100;
		}
	}
	

	/** ��������� ������ - ���������� �������� ����������� �������� **/
	public static String [] result_anuity = new String[4];
	
	/** ��������� ����� ������� ����������� �������� **/
	public static void calculate_anuity(double var_sum, int var_period, double var_percent, double var_month_com, double var_onetime_com) {
	
		/* ������ ���� ����� ������ */
		calendar.add(Calendar.MONTH, var_period);
		/* ������ �������� ���� � ��������� ���������� */
		String end_date = date_format.format(calendar.getTime());
		
		/* ���������� - ����������� ������ */
		double payment = 0;
		/* ���������� - ����� ������ */
		double sum_payment;
		/* ���������� - ��������� */
		double overpay;
		
		/* ������ ����������� ���������� ������ */
		var_percent = (Math.rint(100000000*(var_percent/(100*12))))/100000000;
		
		/* ������ ������������ �������, ����� ������ � ��������� */
		payment = (var_sum*var_percent)/(1 - Math.pow((1+var_percent), -var_period)) + var_month_com;
		sum_payment = payment*var_period + var_onetime_com;
		sum_payment = (Math.rint(100*(sum_payment)))/100;
		payment = (Math.rint(100*(payment)))/100;
		overpay = sum_payment - var_sum;
	
		/* ������ ����������� � ������� BigDecimal
		 * ��� ����������� ������ ������� �����*/
		BigDecimal big_summ = new BigDecimal(sum_payment);
		BigDecimal big_overpay = new BigDecimal(overpay);
		/* ������� ���������� ������: 
		 * ���������� ���� ����� �������, ��� ����������*/
		big_summ = big_summ.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		big_overpay = big_overpay.setScale(2, BigDecimal.ROUND_HALF_UP);
	
		/* ������ ���������� � ������ ����������� */
		result_anuity[0] = big_summ.toString();
		result_anuity[1] = big_overpay.toString();
		result_anuity[2] = Double.toString(payment);
		result_anuity[3] = end_date;
	}
	
	/** ��������� �����, ������������ �������� 
	 *  ����� ������ �� ������������ ������� **/
	public static double getSumm_anuity() {
		double summ = Double.parseDouble(result_anuity[0]);
		return summ;
	}
	
	/** ��������� �����, ������������ �������� 
	 *  ��������� �� ������������ ������� **/
	public static double getOverpay_anuity() {
		double overpay= Double.parseDouble(result_anuity[1]);
		return overpay;
	}
	
	/** ��������� �����, ������������ �������� 
	 *  ������������ ������� �� ������������ ������� **/
	public static double getPayment_anuity() {
		double payment= Double.parseDouble(result_anuity[2]);
		return payment;
	}
	
	/** �����, ��������� �� ����� � ����� ����
	 *  ���������� �������� �� ������������ ������� **/
	static void window_anuity() {

		/* ����� ������ ��� ��������� ����� ��������
		 * ����� Arial, ���������� �������, ������ 16 */
		Font label_result_font = new Font("Arial", Font.PLAIN, 16);
		
		/* ����������� ���� � ������������ �������� */
		JFrame frame = new JFrame("����������� ������");
		/* ������� ������� ���� */
		frame.setSize(360, 200);
		/* ������ �� ��������� �������� ���� */
		frame.setResizable(false);
		/* ������������ ���� �� ������ ������ */
		frame.setLocationRelativeTo(null);
		
		/* ������ ��� ������������ �������� � ������������ �������� */
		JPanel panel_result = new JPanel();
		/* ���������� ����������� ����������:
		 * ������������ ��������� ������������ ������� */
		panel_result.setLayout(null);
		
		/* �������� ��������� ����� �������� */
		JLabel labelsum = new JLabel();
        JLabel labelpereplata = new JLabel();
        JLabel labelm_plata = new JLabel();
        JLabel labeldata = new JLabel();
        JLabel labelres = new JLabel("���������� ��������:");
        
        /* ��������� ������ CreateFields */	
        CreateFields creator = new CreateFields();
		/* ����� ������ ��� ���������� �������� */
		creator.addPanel(panel_result);
		
        /* ������� ���������� ��� ��������� ����� ��������
		 * �� ����� (��� ����, ���������� �, ���������� �, ������, ������, �����) */
        creator.CreateLabel(labelsum, 20, 55, 390, 15, label_result_font);
        creator.CreateLabel(labelpereplata, 20, 80, 390, 15, label_result_font);
        creator.CreateLabel(labelm_plata, 20, 105, 390, 15, label_result_font);
        creator.CreateLabel(labeldata, 20, 130, 390, 15, label_result_font);
        creator.CreateLabel(labelres, 60, 20, 390, 15, new Font("Arial", Font.PLAIN, 18));
		
        /* ���������� ������� �������� */
		labelsum.setText("�������� ����� ������: " + result_anuity[0] + " ���.");
		labelpereplata.setText("���������: " + result_anuity[1] + " ���.");
		labelm_plata.setText("����������� ������: " + result_anuity[2] + " ���."); 
		labeldata.setText("���� ��������� ������: " + result_anuity[3]);
		
		/* ���������� ������ � ���� */
		frame.add(panel_result);
		/* ������� ��������� ���� */		
		frame.setVisible(true);
	}

	/** ��������� ������ - �������� �������� �������� ������� **/
	static String [] name_column_table = new String [1];
	/** ��������� ��������� ������ - ������ �������� ������� **/
	static String [][] data_table = new String [1][1];
	
	/** ����� ������� ������������������ ��������**/
	public static void calculate_diff(double var_sum, int var_period, double var_percent, double var_month_com, double var_onetime_com) {
		
		/* ���������� - ������� ������� */
		/* ���������� ����� */
		int difsize_line = var_period+3;
		/* ���������� �������� */
		int difsize_column = 5;
		
		/* ��������� �������� ������� ��� ������� �������� */
		if (var_onetime_com != 0) {
			difsize_line++;
			difsize_column=6;
		}
		if (var_month_com != 0) {
			difsize_column=6;
		}
		
		/* ��������� ������ - �������� �������� */
		String [] name_column_dif = new String [difsize_column];
		/* ��������� ��������� ������ - ������ ������� */
		String [][] data_dif = new String [difsize_line][difsize_column];
		
		/* ������ - ������� �� ������� */
		double [] payment_dif = new double[difsize_line-2];
		/* ������ - �������� ����������� ��������� */
		double [] percent_dif = new double[difsize_line-2];
		/* ������ - �������� ���������� ����� ������� */
		double [] balance_dif = new double[difsize_line-2];
		
		/* ���������� - ����� ������ */
		double sum_payment = var_sum;
		/* ���������� - ����� ����������� ��������� */
		double sum_percent = 0;
		/* ���������� - ����� ������ �� ��������� */
		double sum_commission = var_month_com*var_period + var_onetime_com;;
		/* ���������� ��������� �� ������� */
		double overpay = 0;
		/* ���������� - ���� ������� */
		double �redit_body = var_sum/var_period;
		double �redit_body_first = 0;
		
		/* ���������� �������� �������� ������� */
		name_column_dif[0] = "����";
		name_column_dif[1] = "������";
		name_column_dif[2] = "��������";
		name_column_dif[3] = "���� �������";
		name_column_dif[4] = "�������";
		
		/* ������ ����������� ���������� ������ */
		var_percent = (Math.rint(100000000*(var_percent/(100*12))))/100000000;
		
		/* ���� ������� ������, ��������� �� ���� ������, � ������ �������� */
		for (int i = 0; i < var_period; i++) {
			�redit_body = (Math.rint(100*(�redit_body)))/100;
			if(i == var_period-1) {
				�redit_body_first = �redit_body;
				�redit_body = sum_payment;
			}
			payment_dif[i] = �redit_body + sum_payment*var_percent + var_month_com;
			percent_dif[i] = sum_payment*var_percent;
			sum_percent += percent_dif[i];
			balance_dif[i] = sum_payment;
			sum_payment -= �redit_body;
			sum_payment= (Math.rint(100*(sum_payment)))/100;
			
			payment_dif[i]= (Math.rint(100*(payment_dif[i])))/100;
			percent_dif[i]= (Math.rint(100*(percent_dif[i])))/100;
			balance_dif[i]= (Math.rint(100*(balance_dif[i])))/100;
		}
		balance_dif[var_period] = sum_payment;
		
		/* ������ ����� ����� ������ � ��������� */
		for (int i=0; i < var_period; i++) {
			sum_payment += payment_dif[i];
		}
		sum_payment += var_onetime_com;
		overpay = sum_payment - var_sum;
						
		/* ���������� ���� ����� ������ ���������������� ������� */
		data_dif[0][0] = date_format.format(calendar.getTime());
		for (int i = 0; i<var_period; i++) {
			calendar.add(Calendar.MONTH, 1);
			data_dif[i+1][0] = date_format.format(calendar.getTime());
			data_dif[i+1][1] = "" + payment_dif[i];
			data_dif[i+1][2] = "" + percent_dif[i];
			data_dif[i+1][3] = "" + �redit_body_first;
			data_dif[i][4] = "" + balance_dif[i];
		}
		data_dif[var_period][3] = "" + �redit_body;		
		data_dif[difsize_line-2][4] = "" + balance_dif[var_period];	
				
		/* ������ ����������� � ������� BigDecimal
		 * ��� ����������� ������ ������� ����� */
		BigDecimal big_summ = new BigDecimal (sum_payment);
		BigDecimal big_percent = new BigDecimal(sum_percent);
		BigDecimal big_overpay = new BigDecimal(overpay);
		BigDecimal big_commission = new BigDecimal(sum_commission);
		/* ������� ���������� ������: 
		 * ���������� ���� ����� �������, ��� ���������� */
		big_summ = big_summ.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		big_percent = big_percent.setScale(2, BigDecimal.ROUND_HALF_UP);
		big_overpay = big_overpay.setScale(2, BigDecimal.ROUND_HALF_UP);
		big_commission = big_commission.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		/* ��������� �������� ������� ��� ������� ����������� �������� */
		if (var_month_com != 0.0) {
			for (int i = 0; i<var_period; i++) {
				data_dif[i+1][4] = "" + var_month_com;
				data_dif[i][5] = "" + balance_dif[i];
			}
			data_dif[0][4] = "0";
			data_dif[difsize_line-2][4] = "" + big_commission;
			data_dif[difsize_line-2][5] = "" + balance_dif[var_period];
			
			name_column_dif[4] = "��������";
			name_column_dif[5] = "�������";
		}
		
		/* ��������� �������� ������� ��� ������� �������������� �������� */
		if (var_onetime_com != 0) {			
			/* �������� ����� �� ���� ���� */
			for (int i = var_period+1; i>=0; i--) {
				for (int j = 0; j<4; j++) {
					data_dif[i+1][j] = data_dif[i][j];
				}				
			}
			for (int i = 1; i<var_period+2; i++) {
				data_dif[i][4] = "" + var_month_com;
				data_dif[i][5] = "" + balance_dif[i-1];
			}
			data_dif[0][4] = "0";
			data_dif[0][0] = data_dif[1][0];
			data_dif[1][5] = data_dif[0][5] = "" + var_sum;
			data_dif[1][1] = "" + var_onetime_com;
			data_dif[1][4] = data_dif[1][1];
			data_dif[difsize_line-2][4] = "" + big_commission;
			data_dif[difsize_line-2][5] = "" + balance_dif[var_period];
			
			name_column_dif[4] = "��������";
			name_column_dif[5] = "�������";
		} 
		
		/* ���������� �������� �������� � ������� */
		data_dif[difsize_line-2][0] = "����� ������";
		data_dif[difsize_line-2][1] = "" + big_summ;
		data_dif[difsize_line-2][2] = "" + big_percent;
		data_dif[difsize_line-2][3] = "" + var_sum;
		data_dif[difsize_line-1][0] = "���������";
		data_dif[difsize_line-1][1] = "" + big_overpay;
		
		/* ���������� ������ ����� ������ */
		for (int i=0; i<difsize_line-1; i++) {
			for (int j=0; j<difsize_column; j++) {
				if (data_dif[i][j] == null) {
					data_dif[i][j] = "0.0";
				}
			}
		}
		
 		/* ������ ���������� ������ � �������� ������� ��� ������ */
		data_table = data_dif;
		name_column_table = name_column_dif;
		
		/* ������ �������� ����� ������ � ��������� � ��������� ���������� */
		result_diff[0] = sum_payment;
		result_diff[1] = overpay;
	}
	/** ������ - ���������� �������� �� ������������������� ������� **/
	static double  [] result_diff = new double [2];
	
	/** �����, ������������ ����� ������
	 * 	�� ������������������� ������� **/
	public static double getSumm_diff() {
		return result_diff[0];
	}
	/** �����, ������������ ���������
	 *  �� ������������������� ������� **/
	public static double  getOverpay_diff() {
		return result_diff[1];
	}
		
	
	/** ����� ��� ������ �� �����
	 *  ���� � ��������, ����������
	 *  ���������� ��������
	 *  �� ������������������� �������**/
	static void window_diff () {
		
		/* ����������� ���� � ������������ �������� */
		JFrame frame = new JFrame("���� ������ ������������������ ��������");
		/* ������� ����������������� ������� ���� */
		frame.setPreferredSize(new Dimension (770, 318));
		
		/* �������, ���������� ���� ������
		 * �� ������������������� ������� */
		JTable table = new JTable(data_table, name_column_table);
		
		/* ��������� �������� ����, ���������� ��� ������� ����������� */
		frame.pack();
		/* ���������� ������ ���������, ���������� ������� */
		frame.add(new JScrollPane(table));

		/* ���������� ������� ��� ������������ ������ � ������� �� ������ ����� */
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int x=0;x<table.getColumnCount();x++){
	         table.getColumnModel().getColumn(x).setCellRenderer( centerRenderer );
		}
		
		/* ������������ ���� �� ������ ������ */
		frame.setLocationRelativeTo(null);
		/* ������� ��������� ���� */		
		frame.setVisible(true);
	}
	
	
	/** ����������, ��������� � ������� ������ � ��������� ������.  
	 *  �������� true �������� ���������� ������, false - �� �������**/
	private static boolean check = true;
	
	/** ����� �������� ��������� ����� ����� � �������� �����������: 
	 *  ��� ���� �����, ������������ ��������, ����������� ��������**/
	public static boolean control(JTextField field, int min, int max) {
		
		/* �������� ���� ����� �� ������� �������� */
		try {
			switch(field.getText()) {
			case(""):	throw new Exception();}
		}
		catch(Exception ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "��������� ��� ����!", "��������!" , JOptionPane.INFORMATION_MESSAGE);
			}			
			field.setText("0");
			check=false;
			return false;
		}
		
		/* �������� ���� ����� �� ��� ��������� ������ */
		try {Double.parseDouble(field.getText());}
		catch (NumberFormatException ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "����� ������� ������ �����, ��������� ����", "��������!" , JOptionPane.INFORMATION_MESSAGE);
			}
			check=false;
			return false;
		}
		
		/* ������������ ��������� ������, �������� ������� ��������� */
		try {
			/* �������� ���������� ��� �������� �������� */
			double x = Double.parseDouble(field.getText());
			if (x < min) {
				field.setText(Integer.toString(min));
				throw new Exception();
			}
			if (x > max) {
				field.setText(Integer.toString(max));
				throw new Exception();
			}
			/* ��������� �������� ����� ������� */
			if (max == 360 | max == 30)	{
				/* ���������� ���������� �������� � ������� �������, 
				 * ��� ��� ���� ������� ����� ���� ������ ����� ������*/
				x = Math.ceil(x);
				int x_int = (int) x;
				field.setText(Integer.toString(x_int));
			}else {
				x-=0;
				field.setText(Double.toString(x));
			}			
		}
		
		catch (Exception ex) {
			if (check) {
				JOptionPane.showMessageDialog(null, "������� ������������ ������", "��������!" , JOptionPane.INFORMATION_MESSAGE);
			}
			check=false;
			return false;
		}
		return check;
	}
}