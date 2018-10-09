package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private UserDao dao;
    
    public UserController() {
    	super();
    	dao = new UserDao();
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	String forward="";
    	String action = req.getParameter("action");
    	
    	if (action.equalsIgnoreCase("delete")) {
    		int id = Integer.parseInt(req.getParameter("id"));
    		dao.deleteUser(id);
    		forward = LIST_USER;
    		req.setAttribute("user", dao.getAllUsers());
    	} else if (action.equalsIgnoreCase("edit")) {
    		forward = INSERT_OR_EDIT;
    		int id = Integer.parseInt(req.getParameter("id"));
    		User user = dao.getUserById(id);
    		req.setAttribute("user", user);
    	} else if (action.equalsIgnoreCase("listUser")) {
    		forward = LIST_USER;
    		req.setAttribute("user", dao.getAllUsers());
    	} else {
    		forward = INSERT_OR_EDIT;
    	}
    	
    	RequestDispatcher view = req.getRequestDispatcher(forward);
    	view.forward(req,  res);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	User user = new User();
    	user.setDescription(req.getParameter("description"));
    	user.setName(req.getParameter("name"));
    	String id = req.getParameter("id");
    	if(id == null || id.isEmpty()) {
    		dao.addUser(user);
    	} else {
    		user.setId(Integer.parseInt(id));
    		dao.updateUser(user);
    	}
    	
    	RequestDispatcher view = req.getRequestDispatcher(LIST_USER);
    	req.setAttribute("users", dao.getAllUsers());
    	view.forward(req, res);
    }
}
