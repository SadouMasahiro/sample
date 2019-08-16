package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import control.UserManager;
//アノテーションの記述
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistUser")

	//HttpServletを継承することで、このクラスはServletとして、働くことができる

public class RegistUser extends HttpServlet{





	private static final long serialVersionUID = 1L;

	//  doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
        request.setCharacterEncoding("UTF-8");
		 //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registUserSuccess.jsp");
        dispatcher.forward(request, response);
	}

	//  requestオブジェクトには、フォームで入力された文字列などが格納されている。
	//  responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");

		//コンソールに確認するために出力
		System.out.println("取得した文字列は"+user_id);



		// userオブジェクトに情報を格納
		User User = new User(user_id,user_name);
		System.out.println("格納した");

		//  UserManagerオブジェクトの生成
		UserManager manager = new UserManager();
		System.out.println("questionmanagerオブジェクト生成");

		//  登録
		manager.registUser(User);
		

		//  成功画面を表示する
	
		response.sendRedirect("/Example/RegistUser");
		
		}


}
