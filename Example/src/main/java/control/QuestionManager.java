package control;
//自分が格納されているフォルダの外にある必要なクラス

import java.sql.Connection;

import beans.Question;
import dao.QuestionDAO;

public class QuestionManager {


	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public QuestionManager(){
	}

	//  追加
	//  引数はQuestionオブジェクト
	public void registQuestion(Question question){

		//  QuestionDAOオブジェクト生成
		QuestionDAO questionDAO = new QuestionDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = questionDAO.createConnection();

		System.out.println("DB登録前です！");



		//  QuestionオブジェクトをDataBaseに登録する
		questionDAO.registQuestion(question, this.connection);
		//コンソールに確認するために出力
		System.out.println("DB登録しました");

		//  DataBaseとの接続を切断する
		questionDAO.closeConnection(this.connection);
		//コンソールに確認するために出力
		System.out.println("DBからの切断");

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

	//  検索
	public Question searchQuestion(Question question){

		//  QuestionDAOオブジェクト生成
		QuestionDAO questionDAO = new QuestionDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = questionDAO.createConnection();

		//  検索する
		question = questionDAO.searchQuestion(question, this.connection);

		//  DataBaseとの接続を切断する
		questionDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return question;
	}


}
