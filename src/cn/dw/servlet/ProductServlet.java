package cn.dw.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dw.model.Product;
import cn.dw.service.ProductServiceImpl;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private String keyword;
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
		String keyword = null;
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		if (type.equals("query")) {
			keyword = request.getParameter("keyword");
			session.setAttribute("keyword", keyword);
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
			List<Product> proList = productService.query((String) session.getAttribute("keyword"));
			System.out.println(keyword);
			request.setAttribute("proList", proList);
			System.out.println(proList.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("getById")) {
			String id=request.getParameter("id");
			Product product2 = productService.queryByid(Integer.parseInt(id));
			request.setAttribute("product", product2);
			System.out.println(product2.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
			dispatcher.forward(request, response);
		}
		else if(type.equals("update")) {
			Product product = new Product();
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setRemark(request.getParameter("remark"));
			product.setId(Integer.parseInt(request.getParameter("id")));
			productService.update(product);
			response.sendRedirect("/test611/query.jsp");
		}

	}

}
