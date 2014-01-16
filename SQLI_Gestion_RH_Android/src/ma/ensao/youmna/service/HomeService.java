package ma.ensao.youmna.service;

import ma.ensao.youmna.util.Constants;
import ma.ensao.youmna.util.NetworkUtils;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

public class HomeService extends IntentService{

	public HomeService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Bundle bundle = intent.getExtras();
		
		String url = bundle.getString(Constants.URL_PATH);
		String param = bundle.getString(Constants.PARAMETER);
		
		NetworkUtils.getRestObject(Integer.class, url, param);
	}

}
