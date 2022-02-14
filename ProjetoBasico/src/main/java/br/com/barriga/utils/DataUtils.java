package br.com.barriga.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {
	public static Date obterDataComDiferencaDias(int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, dias);
		return calendar.getTime();
		//pedir 1 vai vir o dia seguinde, -1 o dia anterior
	}
	
	public static String obterDataFormatada(Date data) {
		DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(data);
	}
}
