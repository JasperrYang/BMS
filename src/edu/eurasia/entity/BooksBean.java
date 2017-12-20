package edu.eurasia.entity;

public class BooksBean {
	
	private int BID;
	private String BNAME;
	private String BAUTHOR;
	private double BPRICE;
	private String BMESSAGE;
	private int CATEGORYID;
	private String CNAME;

	public int getBID() {
		return BID;
	}

	public void setBID(int bID) {
		BID = bID;
	}

	public String getBNAME() {
		return BNAME;
	}

	public void setBNAME(String bNAME) {
		BNAME = bNAME;
	}

	public String getBAUTHOR() {
		return BAUTHOR;
	}

	public void setBAUTHOR(String bAUTHOR) {
		BAUTHOR = bAUTHOR;
	}

	public double getBPRICE() {
		return BPRICE;
	}

	public void setBPRICE(double bPRICE) {
		BPRICE = bPRICE;
	}

	public String getBMESSAGE() {
		return BMESSAGE;
	}

	public void setBMESSAGE(String bMESSAGE) {
		BMESSAGE = bMESSAGE;
	}

	public int getCATEGORYID() {
		return CATEGORYID;
	}

	public void setCATEGORYID(int cATEGORYID) {
		CATEGORYID = cATEGORYID;
	}

	public String getCNAME() {
		return CNAME;
	}

	public void setCNAME(String cNAME) {
		CNAME = cNAME;
	}

}
