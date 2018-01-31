package br.sghvet.controller;

import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.ResultadoExame;

public class ControlPdf {

	private PdfManager manager;
	
	public ControlPdf(){
		manager = new PdfManager();
	}
	
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception{
		manager.requisicaoExame(req);
	}
	
	public void gerarPdfResultado(ResultadoExame result) throws Exception{
		manager.resultadoExame(result);
	}
}
