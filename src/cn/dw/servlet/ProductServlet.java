package cn.dw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1、获取数据
		String keyword=request.getParameter("keyword");
		//2、操作数据调用查询方法
		ProductServiceImpl productService=new ProductServiceImpl();
		List<Product> proList = productService.query(keyword);
		request.setAttribute("proList", proList);
		//3、转发页面
		RequestDispatcher dispatcher=request.getRequestDispatcher("/query.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService=new ProductServiceImpl();	
		Product product=new Product();
		product.setName(request.getParameter("name"));
		product.setPrice(Double.parseDouble(request.getParameter("price")));
		product.setRemark(request.getParameter("remark"));
		productService.save(product);
	}

}
