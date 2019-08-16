package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Answer;
import control.AnswerManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistAnswer")

public class RegistAnswer extends HttpServlet{


	private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registAnswerSuccess.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String ans_point = request.getParameter("ans_point");
		String ans_reason = request.getParameter("ans_reason");
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String ank_num = request.getParameter("ank_num");


		//コンソールに確認するために出力
		System.out.println("取得した文字列は"+ans_point+"です！");
		System.out.println("取得した文字列は"+ans_reason+"です！");
		System.out.println("取得した文字列は"+user_id+"です！");
		System.out.println("取得した文字列は"+user_name+"です！");

		// questionオブジェクトに情報を格納
		Answer answer = new Answer(ans_point, ans_reason,user_id,user_name,ank_num);
		System.out.println("格納した");

		//  StudentManagerオブジェクトの生成
		AnswerManager manager = new AnswerManager();
		System.out.println("answerオブジェクト生成");

		//  登録
		manager.registAnswer(answer);
		System.out.println("登録した");

		//  成功画面を表示する
		System.out.println("回答完了");
		response.sendRedirect("/Example/RegistAnswer");
		}


}
