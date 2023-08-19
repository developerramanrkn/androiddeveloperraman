package com.loginInstagram838384;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class MainActivity extends Activity {
	
	private HashMap<String, Object> headers = new HashMap<>();
	private HashMap<String, Object> request = new HashMap<>();
	private HashMap<String, Object> info = new HashMap<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	private EditText username;
	private EditText password;
	private Button button1;
	private TextView textview2;
	private TextView textview3;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview1 = (TextView) findViewById(R.id.textview1);
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		button1 = (Button) findViewById(R.id.button1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		net = new RequestNetwork(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview1.setVisibility(View.GONE);
				request.put("username", username.getText().toString());
				request.put("enc_password", "#PWD_INSTAGRAM_BROWSER:0:&:".concat(password.getText().toString()));
				headers.put("Host", "www.instagram.com");
				headers.put("x-ig-www-claim", "hmac.AR76Jqq9fQpawksU5uyCivO7YetA6xyXFSr4QFT-2kcQzI2y");
				headers.put("x-instagram-ajax", "145f95b9c6426");
				headers.put("content-type", "application/x-www-form-urlencoded");
				headers.put("user-agent", "Mozilla/5.0 (Linux; Android 10; JNY-LX1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4224.93 Mobile Safari/537.36");
				headers.put("x-requested-with", "XMLHttpRequest");
				headers.put("x-csrftoken", "Re2px5AqUxGh0VDBM9JTrkzMky30iWJxg");
				headers.put("x-ig-app-id", "1217981624899628");
				net.setHeaders(headers);
				net.setParams(request, RequestNetworkController.REQUEST_PARAM);
				net.startRequestNetwork(RequestNetworkController.POST, "https://www.instagram.com/accounts/login/ajax/", "", _net_request_listener);
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				textview1.setVisibility(View.VISIBLE);
				info = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				if (info.containsKey("userId")) {
					textview1.setText("Login succes");
					textview1.setTextColor(0xFF2E7D32);
					textview2.setText(_response);
					textview3.setText(_tag);
				}
else {
					textview1.setText("Password wrong or username wrong");
					textview1.setTextColor(0xFFB71C1C);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		// telegram @its_iraqi
		// YouTube Sware Go
		/*
// https://youtube.com/channel/UCHJpgfnsgJr6ms_kLhTzZZg
*/
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
