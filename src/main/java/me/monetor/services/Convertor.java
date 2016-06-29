package me.monetor.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import me.monetor.dto.TransactionDTO;

public class Convertor {
	
	public TransactionDTO getTransactionDTOFromMessage(Matcher m) throws ParseException{
		TransactionDTO transaction = new TransactionDTO();
		String date = m.group("date");
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss");
		Date startDate = df.parse(date);

		transaction.setAmount(Float.parseFloat(m.group("amount").replace(",", "")));
		transaction.setTransactionType(m.group("transactionType").trim());
		transaction.setSubMerchant(m.group("merchant").trim());
		transaction.setDate(startDate);
		transaction.setBalance(Float.parseFloat(m.group("balance").replace(",", "")));
		return transaction;
	}
}
