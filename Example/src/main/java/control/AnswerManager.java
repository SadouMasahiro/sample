package control;

import java.sql.Connection;

import beans.Answer;
import dao.AnswerDAO;

public class AnswerManager {

	//  属性
	private Connection connection = null;

	//  引数を持たないコンストラクタ
	public AnswerManager(){
	}

	//  追加
	//  引数はQuestionオブジェクト
	public void registAnswer(Answer answer){

		//  QuestionDAOオブジェクト生成
		AnswerDAO answerDAO = new AnswerDAO();

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = answerDAO.createConnection();

		System.out.println("アンサーDB登録前です！");



		//  QuestionオブジェクトをDataBaseに登録する
		answerDAO.registAnswer(answer, this.connection);
		//コンソールに確認するために出力
		System.out.println("アンサーDB登録しました");

		//  DataBaseとの接続を切断する
		answerDAO.closeConnection(this.connection);
		//コンソールに確認するために出力
		System.out.println("アンサーDBからの切断");

		//  コネクションオブジェクトを破棄する
		this.connection = null;

	}

	//  検索
	public Answer searchAnswer(Answer answer){

		//  QuestionDAOオブジェクト生成
		AnswerDAO answerDAO = new AnswerDAO();
		System.out.println("AnswerManagerオブジェクト生成");

		//  DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = answerDAO.createConnection();

		//  検索する
		answer = answerDAO.searchAnswer(answer, this.connection);

		//System.out.println(answer.getAnk_num());
		//  DataBaseとの接続を切断する
		answerDAO.closeConnection(this.connection);

		//  コネクションオブジェクトを破棄する
		this.connection = null;

		return answer;
	}


}
