package com.wining.group.recognition.entity;

import android.media.Image;

public class ImageEntity {
	public ImageEntity() {

	}

	public ImageEntity(Image image, String name, double price) {
		this.mImage = image;
		this.mName = name;
		this.mprice = price;
	}

	private Image mImage;
	private String mName;
	private double mprice;

	public Image getmImage() {
		return mImage;
	}

	public void setmImage(Image mImage) {
		this.mImage = mImage;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public double getMprice() {
		return mprice;
	}

	public void setMprice(double mprice) {
		this.mprice = mprice;
	}

}
