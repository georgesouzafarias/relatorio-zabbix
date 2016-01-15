package br.jus.tjrr.zabbix.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utilitarios {
	

	public String converteDataParaDateFormat(Long timestamp) {		
		Date date = new Date(timestamp * 1000L);
		SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateText = df2.format(date);		
		return dateText;
	}
	
	public String converteTempoParaDateFormat(Long timestamp) {		
		Date date = new Date(timestamp * 1000L);
		SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
		String dateText = df2.format(date);		
		return dateText;
	}
	
	public String converteDataParaDateFormatESubtrai(Long time1, Long time2) {		
		Date date1 = new Date(time1 * 1000L);
		Date date2 = new Date(time2 * 1000L);		
		
		
		long diferenca = date1.getTime() - date2.getTime();

		String diferencaFinal = String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(diferenca),
				TimeUnit.MILLISECONDS.toMinutes(diferenca) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diferenca)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(diferenca) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diferenca)));  
		
		return diferencaFinal;
	}
	
	public long converteDataParaDateFormatEmMinutosESubtrai(Long time1, Long time2) {		
		Date date1 = new Date(time1 * 1000L);
		Date date2 = new Date(time2 * 1000L);		
		
		
		long diferenca = date1.getTime() - date2.getTime();

		long diferencaFinal = TimeUnit.MILLISECONDS.toMinutes(diferenca);
				  
		if (TimeUnit.MILLISECONDS.toSeconds(diferenca) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diferenca)) > 30){
			diferencaFinal++;
		}		
		
		return diferencaFinal;
	}

	
	public String converteMinutosEmFormatoComparavel(Long time1) {	
		Long date1 =TimeUnit.MINUTES.toMillis(time1);
				

		String diferencaFinal = String.format("%02d:%02d:%02d", 
				TimeUnit.MILLISECONDS.toHours(date1),
				TimeUnit.MILLISECONDS.toMinutes(date1) -  
				TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(date1)), // The change is in this line
				TimeUnit.MILLISECONDS.toSeconds(date1) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(date1)));  
		
		return diferencaFinal;
	}
	
	public Long converteDataParaLong(String data) {
		Date dataCovertida = null;
		SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataCovertida = dataFormatada.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}					
			
	        
		return dataCovertida.getTime() / 1000L;
	}
}
