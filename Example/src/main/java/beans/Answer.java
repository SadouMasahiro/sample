package beans;

public class Answer {

	//  属性
	private String ans_point = null;			//　ユーザID
	private String ans_reason = null;			//　アンケ項目
	private String user_id = null;			//　ユーザID
	private String user_name = null;
	private String ank_num=null;


	//　初期値を引数に持ったコンストラクタ
	public Answer(String ans_point, String ans_reason,String user_id,String user_name,String ank_num){

		this.ans_point = ans_point;
		this.ans_reason = ans_reason;
		this.user_id = user_id;
		this.user_name = user_name;
		this.ank_num=ank_num;


	}

	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public Answer(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setAns_point(String ans_point){ this.ans_point = ans_point; }
	public void setAns_reason(String ans_reason){ this.ans_reason = ans_reason; }
	public void setUser_id(String user_id){ this.user_id = user_id; }
	public void setUser_name(String user_name){ this.user_name = user_name; }
	public void setAnk_num(String ank_num){ this.ank_num = ank_num; }

	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public String getAns_point(){ return this.ans_point; }
	public String getAns_reason(){ return this.ans_reason; }
	public String getUser_id(){ return this.user_id; }
	public String getUser_name(){ return this.user_name; }
	public String getAnk_num(){ return this.ank_num; }




}
