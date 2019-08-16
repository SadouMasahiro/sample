package beans;

public class User {

//  属性
	private String user_id = null;			//　ユーザID
	private String user_name = null;			//　ユーザ名


	//　初期値を引数に持ったコンストラクタ
	public User(String user_id, String user_name){

		this.user_id = user_id;
		this.user_name = user_name;

	}

	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public User(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setUser_id(String user_id){ this.user_id = user_id; }
	public void setUser_name(String user_name){ this.user_name = user_name; }


	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public String getUser_id(){ return this.user_id; }
	public String getUser_name(){ return this.user_name; }



}
