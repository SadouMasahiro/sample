package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Answer;

public class AnswerDAO {


	//  属性

	//  データベースの接続先アドレスを静的変数として記述
	private final static String DRIVER_URL =
		"jdbc:mysql://localhost:3306/question?useUnicode=true&characterEncoding=Windows-31J";

	//  データベース接続ドライバの名前を静的変数として記述
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";

	//  データベースのユーザー名　（デフォルトではroot）
	private final static String USER_NAME = "root";

	//  データベースのユーザーのパスワード　(デフォルトでは設定なし)
	private final static String PASSWORD = "luxray405";

	//  データベースとの接続を行う
	//  データベースの接続情報を持ったConnectionオブジェクトを返す
	public Connection createConnection(){
		try{
			Class.forName(DRIVER_NAME);
			Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
			return con;
		} catch(ClassNotFoundException e){
			System.out.println("Can't Find JDBC Driver.\n");

		} catch(SQLException e){
			System.out.println("Connect Error.\n");
		}
		return null;
	}

	//  Connectionオブジェクトを使って、データベースとの接続を切断する
	//  引数Connectionオブジェクト
	public void closeConnection(Connection con){

		try{
			con.close();
		}catch(Exception ex){}
	}

	//  情報をデータベースに登録する
	//  引数はQuestionオブジェクトと、Connectionオブジェクト
	public void registAnswer(Answer answer, Connection connection){

		try{

			//  SQLコマンド
			String sql = "insert into answer values(?, ?, ?, ?, ?)";

			//  SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			//  SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setString(1, answer.getAns_point());
			stmt.setString(2, answer.getAns_reason());
			stmt.setString(3, answer.getUser_id());
			stmt.setString(4, answer.getUser_name());
			stmt.setString(5, answer.getAnk_num());

			stmt.executeUpdate();

		}catch(SQLException e){

//			エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}

	//  検索する
	//  引数はQuestionオブジェクトと、Connectionオブジェクト
	public Answer searchAnswer(Answer answer, Connection connection){

		try{

			System.out.println("DAOのSQLコマンド前");
			//  SQLコマンド
			String sql = "select * from answer where user_id= '" + answer.getUser_id() + "'and ank_num ='"+ answer.getAnk_num() + "'";

			//  SQLのコマンドを実行する
			//  実行結果はrsに格納される
			System.out.println("DAOの格納");
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			rs.first();

			//  rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
			answer.setAns_point(rs.getString("ans_point"));
			answer.setAns_reason(rs.getString("ans_reason"));
			answer.setUser_id(rs.getString("user_id"));
			answer.setUser_name(rs.getString("user_name"));
			answer.setAnk_num(rs.getString("ank_num"));

			System.out.print(answer.getAns_point());
			System.out.print(answer.getAns_reason());
			System.out.print(answer.getUser_id());
			System.out.print(answer.getUser_name());


			//  終了処理
			stmt.close();
			rs.close();

			//  Questionオブジェクトを返す
			return answer;

			}catch(SQLException e){

				//	エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
				e.printStackTrace();
				return null;

			}finally{
			}
	}



}
