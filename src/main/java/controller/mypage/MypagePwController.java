package controller.mypage;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserDto;
import models.member.MypageService;

@WebServlet("/mypage/password")
public class MypagePwController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/mypage/mypage_password.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		
		HttpSession session = req.getSession();
		UserDto dto = (UserDto)session.getAttribute("member");
		
		MypageService service = new MypageService();
		PrintWriter out = resp.getWriter();
		
		try {
			service.passwordUpdate(req, dto);
			
			out.println("<script>alert('비밀번호 수정 완료')</script>");
			out.println("<script>parent.location.replace('/WorkOutProject/mypage')</script>");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			out.println("<script>alert('"+ e.getMessage() +"')</script>");
			
		}
		
	}
}
