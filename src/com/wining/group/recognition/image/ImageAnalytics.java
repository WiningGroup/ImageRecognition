package com.wining.group.recognition.image;

import org.opencv.core.Mat;

import com.wining.group.recognition.entity.ImageEntity;

public class ImageAnalytics {
	private IOnResutlListener mOnResutlListener;

	public ImageAnalytics() {

	}

	public void imageCv(String fileName) {
		// Mat mat=
		if (mOnResutlListener != null) {
			mOnResutlListener.onResule(new ImageEntity());
		}
	}

	public interface IOnResutlListener {
		void onResule(ImageEntity imageEntity);
	}

	public void setIOnResutlListener(IOnResutlListener iOnResutlListener) {
		this.mOnResutlListener = iOnResutlListener;
	}
}
