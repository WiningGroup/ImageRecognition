package com.wining.group.recognition.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.wining.group.recognition.R;
import com.wining.group.recognition.base.BaseActivity;

public class MainActivity extends BaseActivity {

	private String mImgPath = Environment.getExternalStorageDirectory().getPath() + "/testImg.jpg";

	private Button mBtnTransferCamera, mBtnFinishedOrder;

	private List<Bitmap> mBitmapList;

	private GridView mGridView;

	private List<Map<String, Object>> mGridViewDatas;

	private File fileToPhoto;

	/**
	 * @method openCamera
	 * 
	 * @param
	 * @return void
	 * @throws
	 */
	protected void openCamera() {
		startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), 0);
	}

	private void refreshImageBuffer() {
		mGridViewDatas.clear();
		for (int i = 0; i < mBitmapList.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("photo", mBitmapList.get(i));
			mGridViewDatas.add(map);
		}
	}

	@Override
	protected void initComponent() {
		// TODO Auto-generated method stub

		mBitmapList = new ArrayList<Bitmap>();

		mGridViewDatas = new ArrayList<Map<String, Object>>();

		mBtnTransferCamera = (Button) findViewById(R.id.btn_transfer_system_camera);

		mBtnFinishedOrder = (Button) findViewById(R.id.btn_finished_order);

		mGridView = (GridView) findViewById(R.id.photoGridview);
	}

	@Override
	protected int setUpLayoutResource() {
		// TODO Auto-generated method stub
		return R.layout.activity_main;
	}

	@Override
	protected void setUpCompontListener() {
		// TODO Auto-generated method stub
		mBtnTransferCamera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				openCamera();
			}
		});

		mBtnFinishedOrder.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		mGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Toast.makeText(getBaseContext(), "position:" + position, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	protected void logic() {
		// TODO Auto-generated method stub
		fileToPhoto = new File(mImgPath);

		if (!fileToPhoto.exists()) {
			File _dirPath = fileToPhoto.getParentFile();
			_dirPath.mkdirs();
		}

		refreshImageBuffer();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == RESULT_OK) {
			Bitmap bmp = (Bitmap) data.getExtras().get("data");
			mBitmapList.add(bmp);
			refreshImageBuffer();
		}

	}

}
