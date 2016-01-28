package com.thomsonreuters.ccertool.parse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class ParsePDF {

	public static void main(String[] args){
		 InputStream input;
		try {
			input = new FileInputStream("C:\\Users\\U6036058\\Documents\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程.pdf");
			PDDocument document = PDDocument.load(input);  
			PDFTextStripper s = new PDFTextStripper();
			System.out.println(s.getText(document));
			s.writeText(document, new OutputStreamWriter(new FileOutputStream("C:\\Users\\U6036058\\Documents\\Task\\CCER-HONGLIANG\\芜湖海螺水泥有限公司218MW余热发电工程.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
