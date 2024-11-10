package com.ltd.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.ltd.model.*;

import java.io.IOException;

@WebServlet("/TaskController")
public class TaskController extends HttpServlet {
    private TaskRepository taskRepository = new TaskRepository();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.equals("view")) {
            request.setAttribute("tasks", taskRepository.getAllTasks());
            RequestDispatcher dispatcher = request.getRequestDispatcher("taskList.jsp");
            dispatcher.forward(request, response);
        } else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            taskRepository.deleteTask(id);
            response.sendRedirect("TaskController?action=view");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("add")) {
            String description = request.getParameter("description");
            String status = request.getParameter("status");
            taskRepository.addTask(description, status);
            response.sendRedirect("TaskController?action=view");
        }
    }
}
