package com.spring.project.banking.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("mailstatservice")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class MailStatService {
	String d1=null;
	public List<Object> us;

	public void writetoexcel(List<Object> u) throws WriteException, IOException {
		us = u;
		WriteExcel1 test = new WriteExcel1();
		Date d = new Date();
		
	 d1 = "D:/stat_"+d.getDate()+"_"+d.getMonth()+"_"+d.getYear()+".xls";
		test.setOutputFile(d1);
		test.write(us);
		

	}

	public boolean sendmail(String s) {

		String to = s;

		// Sender's email ID needs to be mentioned
		String from = "lokesh.desineni@valuelabs.net";

		// Assuming you are sending email from localhost
		String host = "localhost";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mx.valuelabs.net", host);
		properties.put("mail.smtp.host", "mx.valuelabs.net");
		properties.put("mail.smtp.user", "lokesh.desineni@valuelabs.net"); // User
																			// name
		properties.put("mail.smtp.password", "Desineni@6282"); // password
		properties.put("mx.valuelabs.net", "25");
		properties.put("mx.valuelabs.net", "true");
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("Statement");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart
					.setText("Thanks for using our service please find attachment below");

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			Date d = new Date();
			String filename = d1;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			java.io.File file = new java.io.File(filename);
			file.delete();
			return true;
		} catch (MessagingException mex) {
			mex.printStackTrace();
			return false;
		}

	}

}

class WriteExcel1 {

	private WritableCellFormat timesBoldUnderline;
	private WritableCellFormat times;
	private String inputFile;

	public void setOutputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	public void write(List<Object> us) throws IOException, WriteException {
		// File file = new File(inputFile);
		java.io.File file = new java.io.File(inputFile);
		WorkbookSettings wbSettings = new WorkbookSettings();

		wbSettings.setLocale(new Locale("en", "EN"));
		Object ob;

		WritableWorkbook workbook = Workbook.createWorkbook(file, wbSettings);
		workbook.createSheet("Report", 0);
		WritableSheet excelSheet = workbook.getSheet(0);
		createLabel(excelSheet);
		createContent(excelSheet, us);

		workbook.write();
		workbook.close();
	}

	private void createLabel(WritableSheet sheet) throws WriteException {
		// Lets create a times font
		WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
		// Define the cell format
		times = new WritableCellFormat(times10pt);
		// Lets automatically wrap the cells
		times.setWrap(true);

		// create create a bold font with unterlines
		WritableFont times10ptBoldUnderline = new WritableFont(
				WritableFont.TIMES, 10, WritableFont.BOLD, false,
				UnderlineStyle.SINGLE);
		timesBoldUnderline = new WritableCellFormat(times10ptBoldUnderline);
		// Lets automatically wrap the cells
		timesBoldUnderline.setWrap(true);

		CellView cv = new CellView();
		cv.setFormat(times);
		cv.setFormat(timesBoldUnderline);
		cv.setAutosize(true);

		// Write a few headers
		addCaption(sheet, 0, 0, "accno");
		addCaption(sheet, 1, 0, "accname");
		addCaption(sheet, 2, 0, "txdate");
		addCaption(sheet, 3, 0, "credit");
		addCaption(sheet, 4, 0, "debit");
		addCaption(sheet, 5, 0, "amount");

	}

	private void createContent(WritableSheet sheet, List<Object> us)
			throws WriteException, RowsExceededException {
	
		List<Object> li = (List<Object>) us;
		int i = 1;
		for (Object row : li) {
			Object[] recordarray = (Object[]) row;
			
			addLabel(sheet, 0, i, recordarray[0].toString());
			addLabel(sheet, 1, i, recordarray[1].toString());
			addLabel(sheet, 2, i, recordarray[2].toString());

			addLabel(sheet, 3, i, recordarray[3].toString());
			addLabel(sheet, 4, i, recordarray[4].toString());
			addLabel(sheet, 5, i, recordarray[5].toString());
			i++;
		}
	
	}

	private void addCaption(WritableSheet sheet, int column, int row, String s)
			throws RowsExceededException, WriteException {
		Label label;
		label = new Label(column, row, s, timesBoldUnderline);
		sheet.addCell(label);
	}



	private void addLabel(WritableSheet sheet, int column, int row, String s)
			throws WriteException, RowsExceededException {
		Label label;
		label = new Label(column, row, s, times);
		sheet.addCell(label);
	}
}