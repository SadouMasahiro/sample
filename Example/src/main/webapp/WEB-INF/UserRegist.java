package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import control.QuestionManager;

public class UserRegist extends HttpServlet{





	private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registQuestionSuccess.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String ank_num = request.getParameter("ank_num");
		String ank_text = request.getParameter("ank_text");

		//コンソールに確認するために出力
		System.out.println("取得した文字列は"+ank_num+"です！");
		System.out.println("取得した文字列は"+ank_text+"です！");


		// questionオブジェクトに情報を格納
		Question question = new Question(ank_num, ank_text);
		System.out.println("格納した");

		//  StudentManagerオブジェクトの生成
		QuestionManager manager = new QuestionManager();
		System.out.println("questionmanagerオブジェクト生成");

		//  登録
		manager.registQuestion(question);
		System.out.println("登録した");

		//  成功画面を表示する
		System.out.println("OK牧場");
		response.sendRedirect("/Example/RegistInfo");
		System.out.println("第一段階クリア");
		}

	
	
}
