package com.wining.group.recognition.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.wining.group.recognition.R;
import com.wining.group.recognition.base.BaseActivity;
import com.wining.group.recognition.base.ImageItemAdapter;
import com.wining.group.recognition.entity.ImageEntity;
import com.wining.group.recognition.image.ImageAnalytics;
import com.wining.group.recognition.image.ImageAnalytics.IOnResutlListener;

public class MainActivity extends BaseActivity {

	private String mImgPath = Environment.getExternalStorageDirectory().getPath() + "/testImg.jpg";

	private Button mBtnTransferCamera, mBtnFinishedOrder;

	private List<ImageEntity> mResultImagesList;

	private ListView mImagesListView;

	private File fileToPhoto;

	private ImageItemAdapter mAdapter;

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
	}

	@Override
	protected void initComponent() {
		// TODO Auto-generated method stub

		mResultImagesList = new ArrayList<ImageEntity>();

		mBtnTransferCamera = (Button) findViewById(R.id.btn_transfer_system_camera);

		mBtnFinishedOrder = (Button) findViewById(R.id.btn_finished_order);

		mImagesListView = (ListView) findViewById(R.id.photoListview);
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

		mImagesListView.setOnItemClickListener(new OnItemClickListener() {

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

			new ImageAnalytics().setIOnResutlListener(new IOnResutlListener() {

				@Override
				public void onResule(ImageEntity imageEntity) {
					mResultImagesList.add(imageEntity);
					mAdapter = new ImageItemAdapter(mResultImagesList);
					mImagesListView.setAdapter(mAdapter);
					mAdapter.notifyDataSetChanged();
				}
			});

		}

	}

}
