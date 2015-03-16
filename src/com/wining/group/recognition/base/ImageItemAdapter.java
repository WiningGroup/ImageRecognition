package com.wining.group.recognition.base;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wining.group.recognition.R;
import com.wining.group.recognition.entity.ImageEntity;

public class ImageItemAdapter extends BaseAdapter {

	private List<ImageEntity> mDatas;

	public ImageItemAdapter(List<ImageEntity> data) {
		mDatas = data;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		Holder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_detail_item_for_list, parent, false);
			holder = new Holder();
			holder.imgShow = (ImageView) convertView.findViewById(R.id.imgShow);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
			holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}

		holder.tvTitle.setText(mDatas.get(position).getmName());
		holder.tvPrice.setText(String.format("¥%f", mDatas.get(position).getMprice()));

		return convertView;
	}

	private class Holder {
		TextView tvTitle, tvPrice;
		ImageView imgShow;
	}

}
