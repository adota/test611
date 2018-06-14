package cn.dw.servlet;

import java.awt.Window.Type;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String keyword;
	private ProductServiceImpl productService = new ProductServiceImpl();

	public ProductServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		if (type.equals("query")) {
			keyword = request.getParameter("keyword");
			List<Product> proList = productService.query(keyword);
			request.setAttribute("proList", proList);
			System.out.println(proList.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("save")) {
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setRemark(request.getParameter("remark"));
			productService.save(product);
			response.sendRedirect("/test611/query.jsp");
		} else if (type.equals("delete")) {
			String id = request.getParameter("id");
			productService.delete(Integer.parseInt(id));
			
			List<Product> proList = productService.query(keyword);
			System.out.println(keyword);
			request.setAttribute("proList", proList);
			System.out.println(proList.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}

	}

}
