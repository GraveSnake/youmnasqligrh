package ma.ensao.youmna.util;

import android.graphics.Color;

public class Constants {
//	Login And Accounts
	public static final int TABS_COUNT = 3;
	public static final String ACCOUNT_TYPE = "ma.ensao.youmna.AccountType";
	public static final String AUTHTOKEN_TYPE = "ma.ensao.youmna.AuthTokenType";
	public static final String HOST = "http://192.168.1.10";
	public static final int PORT = 8082;
	public static final String BASE_URL = "http://192.168.1.10:8082/SQLI_Gestion_RH_Web/rest";
	public static final String AUTH_TOKEN_KEY = "authToken";
	public static final String FIRST_NAME_KEY = "first_name";
	public static final String LAST_NAME_KEY = "last_name";
	public static final String USER_ID_KEY = "userIDKey";
	public static final String USER_AUTHORITY = "userAuthority";
	
//	Roles
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_MAN = "ROLE_USER";
	
//	Useful REST
	public static final String URL_PATH = "path";
	public static final String CLASS = "class";
	public static final String HTTP_METHOD = "method";
	public static final String PARAMETER = "param";
	
	
//	Tabs
	public static final String HOME = "Accueil";
	public static final String COLLABORATORS = "Collaborateurs";
	public static final String REPORTING = "Reporting";

//	Status
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
	public static final int LOGIN_INCORRECT = 2;
	public static final int TIMEOUT = 3;
	public static final int EXCEPTION = 4;
	
//	Colors
	public static final int COLOR_ORANGE = Color.parseColor("#ff6c0a");
	public static final int COLOR_BLUE = Color.parseColor("#23bae9");
}
