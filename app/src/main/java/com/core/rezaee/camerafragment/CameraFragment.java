package com.core.rezaee.camerafragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class CameraFragment extends Fragment {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;

	Button take_image_button;
	ImageView preview_image;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.camera_fragment, container, false);

		take_image_button = rootView.findViewById(R.id.take_image_button);
		preview_image = rootView.findViewById(R.id.preview_image);

		take_image_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		});

		return rootView;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
			if (resultCode == Activity.RESULT_OK) {
				preview_image.setImageBitmap((Bitmap) data.getExtras().get("data"));
			}
		}
	}
}