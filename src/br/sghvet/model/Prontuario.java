package br.sghvet.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Prontuario {
	
	
	private Calendar calendar;
	private SimpleDateFormat formatter;
	private Date minhaDataEncapsulada;
	private String dataFormatada;

	
	public Prontuario(){
		
		this.calendar = Calendar.getInstance();
		this.formatter = new SimpleDateFormat("dd/MMM/YYYY    HH: mm: ss");
		this.minhaDataEncapsulada = calendar.getTime();
		this.dataFormatada = formatter.format(minhaDataEncapsulada);
	}
	
	public String getDataFormatada() {
		return dataFormatada;
	}
	
}
