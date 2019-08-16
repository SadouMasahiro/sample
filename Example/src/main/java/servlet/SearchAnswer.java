package servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Answer;
import beans.Question;
import control.AnswerManager;
import control.QuestionManager;

@WebServlet("/SearchAnswer")
//HttpServletを継承することで、このクラスはServletとして、働くことができる
public class SearchAnswer extends HttpServlet{
	/**
    *
    */



   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       // requestオブジェクトの文字エンコーディングの設定
       request.setCharacterEncoding("UTF-8");
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/searchAnswer.jsp");
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
       String user_name = null;
       String user_id = request.getParameter("user_id");
       String ans_point = null;

       String ans_reason = null;

       // studentのオブジェクトに情報を格納
       Answer answer = new Answer(ans_point, ans_reason,user_id,user_name,ank_num);

       System.out.println(answer.getAnk_num());
       System.out.println(answer.getAns_point());


       Question question = new Question(ank_num,null);
       QuestionManager questionManager = new QuestionManager();
       question = questionManager.searchQuestion(question);

       //  StudentManagerオブジェクトの生成
       AnswerManager manager = new AnswerManager();

       //  学生の検索
       answer = manager.searchAnswer(answer);
       //  requestオブジェクトにオブジェクトを登録
       request.setAttribute("Answer", answer);
       request.setAttribute("Question", question);
       //  情報表示画面を表示する
       //  forwardはrequestオブジェクトを引数として、次のページに渡すことができる
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/showAnswer.jsp");
       dispatcher.forward(request, response);
   }
}
