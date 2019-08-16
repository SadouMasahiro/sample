package beans;

public class Question {

	//  属性
	private String ank_num = null;			//　ユーザID
	private String ank_text = null;			//　アンケ項目


	//　初期値を引数に持ったコンストラクタ
	public Question(String ank_num, String ank_text){

		this.ank_num = ank_num;
		this.ank_text = ank_text;

	}

	//  初期値を引数に持たないコンストラクタ
	//  Java beansは初期値を持たないコンストラクタが必ず必要
	public Question(){}

	//  setメソッド
	//  Java beansのsetメソッドはsetの後ろに続く文字列が必ず大文字であること
	public void setAnk_num(String ank_num){ this.ank_num = ank_num; }
	public void setAnk_text(String ank_text){ this.ank_text = ank_text; }


	//  getメソッド
	//  Java beansのgetメソッドはgetの後ろに続く文字列が必ず大文字であること
	public String getAnk_num(){ return this.ank_num; }
	public String getAnk_text(){ return this.ank_text; }




}
