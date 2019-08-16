package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Question;
import control.QuestionManager;

@WebServlet("/SearchInfo")
//HttpServletを継承することで、このクラスはServletとして、働くことができる
public class SearchInfo extends HttpServlet{
	/**
    *
    */



   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // requestオブジェクトの文字エンコーディングの設定
       request.setCharacterEncoding("UTF-8");
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/searchQuestion.jsp");
       dispatcher.forward(request, response);
   }

   //  requestオブジェクトには、フォームで入力された文字列などが格納されている。
   //  responseオブジェクトを使って、次のページを表示する
   public void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {

       // requestオブジェクトの文字エンコーディングの設定
       request.setCharacterEncoding("UTF-8");

       // requestオブジェクトから登録情報の取り出し
       String ank_num = request.getParameter("ank_num");

       String ank_text = null;


       // studentのオブジェクトに情報を格納
       Question question = new Question(ank_num, ank_text);


       System.out.println(question.getAnk_num());
       System.out.println(question.getAnk_text());

       //  StudentManagerオブジェクトの生成
       QuestionManager manager = new QuestionManager();

       //  学生の検索
       question = manager.searchQuestion(question);
       //  requestオブジェクトにオブジェクトを登録
       request.setAttribute("Question", question);
       //  情報表示画面を表示する
       //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/showQuestion.jsp");
       dispatcher.forward(request, response);
   }
}
