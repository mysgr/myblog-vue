package com.nfit.yaoliusan.myblog.web;

import com.google.gson.Gson;
import com.nfit.yaoliusan.myblog.bean.Comment;
import com.nfit.yaoliusan.myblog.dao.CommentDAO;
import com.nfit.yaoliusan.myblog.vo.ResultVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/comments")
public class CommentListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId = req.getParameter("postId");

        try {
            CommentDAO commentDAO = new CommentDAO();
            List<Comment> comments = commentDAO.getCommentsPostID(Integer.parseInt(postId)); //获取评论内容列表
            PrintWriter writer = resp.getWriter();
            writer.print(ResultVO.success(comments).toJSON());//将获取到的数据返回客户端

        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
