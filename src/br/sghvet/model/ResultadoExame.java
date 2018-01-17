package br.sghvet.model;

public class ResultadoExame {
	
	private int IdConsulta;
	private float temperatura;
	private float batimentoPorMin;
	private float movRespPorMin;
	private float pulso;
	private String ectoscopia;
	//estado geral, mucosas, pele, linfonodos, articulações, glândulas paranais, genitália, glândulas mamárias, faceis
	private String cabecaPescoco;
	//ouvidos, olhos, nariz, cavidade bucal, traqueia, esofago
	private String cavidadeToracica;
	//palpação, percussão, auscultação
	private String cavidadeAbdominal;
	//forma, conteúdo, estômago, fígado, baço, intestinos, linfonodos, rins, bexiga, útero, próstata
	private String sistemaLocomotor;
	//ossos, articulações
	private String sistemaNervoso;
	//comportamento, reflexos, paralisias, sensibilidade superficial e profunda
	private String diagnosticoProvavel;
	private String examesComplementares;
	private String diagnosticoDefinitivo;
	private String prognostico;
	
	
	
	public ResultadoExame(int IdConsulta, float temperatura, float batimentoPorMin, float movRespPorMin, float pulso,
			String ectoscopia, String cabecaPescoco, String cavidadeToracica, String cavidadeAbdominal,
			String sistemaLocomotor, String sistemaNervoso, String diagnosticoProvavel, String examesComplementares,
			String diagnosticoDefinitivo, String prognostico) {
		this.IdConsulta = IdConsulta;
		this.temperatura = temperatura;
		this.batimentoPorMin = batimentoPorMin;
		this.movRespPorMin = movRespPorMin;
		this.pulso = pulso;
		this.ectoscopia = ectoscopia;
		this.cabecaPescoco = cabecaPescoco;
		this.cavidadeToracica = cavidadeToracica;
		this.cavidadeAbdominal = cavidadeAbdominal;
		this.sistemaLocomotor = sistemaLocomotor;
		this.sistemaNervoso = sistemaNervoso;
		this.diagnosticoProvavel = diagnosticoProvavel;
		this.examesComplementares = examesComplementares;
		this.diagnosticoDefinitivo = diagnosticoDefinitivo;
		this.prognostico = prognostico;
	}
	
	public int getIdConsulta() {
		return IdConsulta;
	}
	public void setConsulta(int IdConsulta) {
		this.IdConsulta = IdConsulta;
	}
	public float getTemp() {
		return temperatura;
	}
	public void setTemp(float temp) {
		this.temperatura = temp;
	}
	public float getBatimentoPorMin() {
		return batimentoPorMin;
	}
	public void setBatimentoPorMin(float batimentoPorMin) {
		this.batimentoPorMin = batimentoPorMin;
	}
	public float getMovRespPorMin() {
		return movRespPorMin;
	}
	public void setMovRespPorMin(float movRespPorMin) {
		this.movRespPorMin = movRespPorMin;
	}
	public float getPulso() {
		return pulso;
	}
	public void setPulso(float pulso) {
		this.pulso = pulso;
	}
	public String getEctoscopia() {
		return ectoscopia;
	}
	public void setEctoscopia(String ectoscopia) {
		this.ectoscopia = ectoscopia;
	}
	public String getCabecaPescoco() {
		return cabecaPescoco;
	}
	public void setCabecaPescoco(String cabecaPescoco) {
		this.cabecaPescoco = cabecaPescoco;
	}
	public String getCavidadeToracica() {
		return cavidadeToracica;
	}
	public void setCavidadeToracica(String cavidadeToracica) {
		this.cavidadeToracica = cavidadeToracica;
	}
	public String getCavidadeAbdominal() {
		return cavidadeAbdominal;
	}
	public void setCavidadeAbdominal(String cavidadeAbdominal) {
		this.cavidadeAbdominal = cavidadeAbdominal;
	}
	public String getSistemaLocomotor() {
		return sistemaLocomotor;
	}
	public void setSistemaLocomotor(String sistemaLocomotor) {
		this.sistemaLocomotor = sistemaLocomotor;
	}
	public String getSistemaNervoso() {
		return sistemaNervoso;
	}
	public void setSistemaNervoso(String sistemaNervoso) {
		this.sistemaNervoso = sistemaNervoso;
	}
	public String getDiagnosticoProvavel() {
		return diagnosticoProvavel;
	}
	public void setDiagnosticoProvavel(String diagnosticoProvavel) {
		this.diagnosticoProvavel = diagnosticoProvavel;
	}
	public String getExamesComplementares() {
		return examesComplementares;
	}
	public void setExamesComplementares(String examesComplementares) {
		this.examesComplementares = examesComplementares;
	}
	public String getDiagnosticoDefinitivo() {
		return diagnosticoDefinitivo;
	}
	public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
		this.diagnosticoDefinitivo = diagnosticoDefinitivo;
	}
	public String getPrognostico() {
		return prognostico;
	}
	public void setPrognostico(String prognostico) {
		this.prognostico = prognostico;
	}
	
	

}
