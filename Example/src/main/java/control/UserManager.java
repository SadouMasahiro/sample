package control;

import java.sql.Connection;

import beans.User;
import dao.UserDAO;


public class UserManager {


	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public UserManager(){
	}

	//  追加
	//  引数はQuestionオブジェクト
	public void registUser(User user){

		//  UserDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		System.out.println("DB登録前です！");



		//  QuestionオブジェクトをDataBaseに登録する
		userDAO.registUser(user, this.connection);
		//コンソールに確認するために出力
		System.out.println("DB登録しました");

		//  DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);
		//コンソールに確認するために出力
		System.out.println("DBからの切断");

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}






}
