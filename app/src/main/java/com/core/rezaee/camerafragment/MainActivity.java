package com.core.rezaee.camerafragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		getSupportFragmentManager()
			.beginTransaction()
			.add(R.id.fragment_container, new CameraFragment())
			.commit();
	}
}