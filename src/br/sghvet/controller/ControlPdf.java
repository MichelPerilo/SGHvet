package br.sghvet.controller;

import br.sghvet.model.RequisicaoExame;

public class ControlPdf {

	private PdfManager manager;
	
	public ControlPdf(){
		manager = new PdfManager();
	}
	
	public void gerarPdfRequisicao(RequisicaoExame req) throws Exception{
		manager.requisicaoExame(req);
	}
}
