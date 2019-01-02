package tn.esprit.Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class GeneratePdf
 */
@WebServlet(name="GeneratePdf",urlPatterns={"/GeneratePdf"})
public class GeneratePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
 
        Document document = new Document();
        try {
            /* setup http header */
        	response.setContentType("application/pdf");
        	response.setHeader("Content-Disposition", " inline; filename=report.pdf");
 
            /* generate PDF document */
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
 
            document.addTitle("Comp'Il Stock Report");
 
            Paragraph p = new Paragraph("Comp'Il Stock Report");
            p.setSpacingAfter(8);
            document.add(p);
 
            p = new Paragraph(new Date().toString());
            p.setSpacingAfter(8);
            document.add(p);
 
            /* New table - 3 columns of *relative* width 2/4/1 */
           
        } catch (DocumentException de) {
            // Wrap inside a ServletException
            throw new ServletException(de);
        }
 
        document.close();
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	@Override
	public String getServletInfo() {
	    return "This Servlet Generates PDF Using iText Library";
	}
}
