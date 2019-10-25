package model;

import java.util.Date;

public class EIBSample {
	private float sampleValue;
	private Date date;
	
	public float getSampleValue() {
		return sampleValue;
	}

	public Date getDate() {
		return date;
	}

	public EIBSample(float sampleValue, Date date) {
		this.sampleValue = sampleValue;
		this.date = date;
	}
}
