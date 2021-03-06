package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CouponDAO;
import com.model.Coupon;

@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CouponDAO dao = new CouponDAO();

	public CouponController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action.equals("create")) {

			createCoupon(request, response);
		} else if (action.equals("find")) {
			findCoupon(request, response);
		}

	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");

		String discount = request.getParameter("discount");

		String expiryDate = request.getParameter("expiryDate");

		Coupon coupon = new Coupon();

		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);

		dao.save(coupon);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<b>                coupon  Created                         </b>");

		out.print("<br/> <a href='/CouponAndProductApp'>HOME</a>");
	}

	public void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String couponCode = request.getParameter("couponCode");

		Coupon coupon = dao.findBycode(couponCode);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// out.print("<b> Coupon details </b>");

		out.print(coupon);
		out.print("<br/> <a href='/CouponAndProductApp'>HOME</a>");

	}

}
