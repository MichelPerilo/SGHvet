package br.sghvet.controller;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Tab;

import br.sghvet.facade.Fachada;
import br.sghvet.model.Animal;
import br.sghvet.model.RequisicaoExame;
import br.sghvet.model.Tutor;
import br.sghvet.model.Veterinario;

import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;

public class PdfManager {
	public void requisicaoExame(RequisicaoExame req) throws Exception {
		Animal animal = Fachada.getInstance().buscaAnimalProntuario(req.getProntuario());
		Tutor tutor = Fachada.getInstance().buscarTutor(req.getCpfTutor());
		Veterinario veterinario = Fachada.getInstance().buscaVeterinario(req.getCpfVeterinario());
	
		
		String nomedoc = "Requisicao"+ req.getId() +".pdf";
		
		PdfWriter writer = new PdfWriter(nomedoc);
		PageSize pgsize = PageSize.A4;
		PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf,pgsize);
        document.setMargins(40, 40, 40, 40);
        PdfCanvas canvas = new PdfCanvas(pdf.addNewPage());
        Color color = new DeviceCmyk(255.f, 255.f, 255.f, 255.f);
        canvas.setStrokeColor(color)
                .moveTo(36, 36)
                .lineTo(36, 806)
                .lineTo(556, 806)
                .lineTo(556, 36)
                .closePathStroke();

        PdfCanvas canvas2 = new PdfCanvas(pdf, 1);
        canvas2.setStrokeColor(color)
        		.moveTo(66, 70)
        		.lineTo(226, 70)
        		.closePathStroke();
        
        PdfCanvas canvas3 = new PdfCanvas(pdf, 1);
        canvas3.setStrokeColor(color)
        		.moveTo(366, 70)
        		.lineTo(526, 70)
        		.closePathStroke();
        
        Image itext = new Image(ImageDataFactory.create("assets/imgs/simgeh.png")).setWidth(150).setHeight(75);
        document.add(new Paragraph().add(itext));
        //TODO: CRIAR VETOR DE DADOS QUE SERAO USADOS PARA PREENCHER OS CAMPOS CENTRALIZADOS ABAIXO
        document.add(new Paragraph());
        document.add(new Paragraph());
        
        document.add(new Paragraph().add("REQUISIÇÃO DE EXAME").setBold());
        
        document.add(new Paragraph());
        
        document.add(new Paragraph().add("ID: ").setBold().add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(String.valueOf(req.getId())));
        
        document.add(new Paragraph().add("_____________________________________________________________________________"));
        //document.add(new Paragraph().add("--------------------------------------------------------------------------------------------------------------------------------"));
        
        document.add(new Paragraph().add("VETERINARIO RESPONSÁVEL").setBold());
        document.add(new Paragraph().add("Código:").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(veterinario.getCrmv()));
        document.add(new Paragraph().add("CPF: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(veterinario.getCpf()));
        
        //document.add(new Paragraph());
        document.add(new Paragraph().add("_____________________________________________________________________________"));
        
        document.add(new Paragraph().add("TUTOR RESPONSÁVEL").setBold());
        document.add(new Paragraph().add("Nome:").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(tutor.getNome()));
        document.add(new Paragraph().add("CPF:").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(tutor.getCpf()));
        document.add(new Paragraph().add("Contato: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(tutor.getContato()));
        
        //document.add(new Paragraph());
        document.add(new Paragraph().add("_____________________________________________________________________________"));
        
        document.add(new Paragraph().add("DADOS DO ANIMAL").setBold());
        document.add(new Paragraph().add("ID: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(String.valueOf(animal.getNumProntuario())));
        document.add(new Paragraph().add("Nome: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(animal.getNome()));
        document.add(new Paragraph().add("Especie: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(animal.getEspecie()));
        document.add(new Paragraph().add("Raça: ").add(new Tab()).add(new Tab()).add(new Tab()).add(new Tab()).add(animal.getRaça()));
        document.add(new Paragraph().add("Peso::Idade").add(new Tab()).add(new Tab()).add(new Tab()).add(String.valueOf(animal.getPeso()) +"::" + String.valueOf(animal.getIdade())));
        
        //document.add(new Paragraph());
        document.add(new Paragraph().add("_____________________________________________________________________________"));
        
        // talvez fosse bom colocar uma table aqui?
        document.add(new Paragraph().add("DADOS DO EXAME").setBold());
        document.add(new Paragraph().add("Tipo de exame: ").add(new Tab()).add(new Tab()).add(new Tab()).add("COMPLETO"));
        document.add(new Paragraph().add("Data de realização dos exames: ").add(new Tab()).add(req.getData().toString()));
        
        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(new Paragraph());
        document.add(new Paragraph());
        //document.add(new Paragraph().add("     ").add("Responsavel").add("                                ").add("Veterinario responsável"));
        
        
        document.close();
	}
}
