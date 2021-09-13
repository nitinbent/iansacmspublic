package com.hamdibouallegue.datarestdemo.dto;

import java.io.Serializable;
import java.util.List;

public class DownloadInvoiceDTO implements Serializable{

	/**
	 *  Serial Version UID
	 */
	private static final long serialVersionUID = 2596158925381651267L;
	
	private List<GenerateInvoiceDTO> downloadInvoices;

	public List<GenerateInvoiceDTO> getDownloadInvoices() {
		return downloadInvoices;
	}

	public void setDownloadInvoices(List<GenerateInvoiceDTO> downloadInvoices) {
		this.downloadInvoices = downloadInvoices;
	}

}
