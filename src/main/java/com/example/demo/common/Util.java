package com.example.demo.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {
	// CRUD
	public static final String SUCCESS_CODE = "0";
	public static final String SUCCESS_DESC = "Successful";
	public static final String INSERT_SUCCESS_CODE = SUCCESS_CODE;
	public static final String INSERT_SUCCESS_DESC = "The record was created.";
	public static final String UPDATE_SUCCESS_CODE = SUCCESS_CODE;
	public static final String UPDATE_SUCCESS_DESC = "The record was edited";
	public static final String DELETE_SUCCESS_CODE = SUCCESS_CODE;
	public static final String DELETE_SUCCESS_DESC = "The record was deleted";
	
	public static final String SUCCESS_RERUN = "Rerun Successful";
	public static final String FAIL_RERUN = "Rerun Fail";

	public static final String FAIL_CODE = "-1";
	public static final String FAIL_DESC = "Fail";
	public static final String INSERT_FAIL_CODE = "INS-01 " + FAIL_DESC;
	public static final String INSERT_FAIL_DESC = "Insert record fail";
	public static final String UPDATE_FAIL_CODE = "UPD-01 " + FAIL_DESC;
	public static final String UPDATE_FAIL_DESC = "Update record fail";
	public static final String DELETE_FAIL_CODE = "DEL-01 " + FAIL_DESC;
	public static final String DELETE_FAIL_DESC = "Delete record fail";

	public static final String DUPLICATE_KEY_CODE = "INS-02 " + FAIL_DESC;
	public static final String DUPLICATE_KEY_DESC = "Cannot insert duplicate key";

	public static final String MODE = "mode";
	public static final String MODE_INSERT = "insert";
	public static final String MODE_UPDATE = "update";
	public static final String MODE_DELETE = "delete";
	
	public static final String STRING_RESULT_TITLE = "RESULT_TITLE";
	public static final String STRING_RESULT_CODE = "RESULT_CODE";
	public static final String STRING_RESULT_DESC = "RESULT_DESC";

	public static String toJSON(Object object) {
		ObjectMapper jsonMapper = new ObjectMapper();
		try {
			return jsonMapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";

	}
	
	public static void showWebMessage(HttpServletRequest request, String code, String desc, String title) {
		if (code == null) {
			code = FAIL_CODE;
		}
		if (desc == null) {
			desc = FAIL_DESC;
		}
		if (title == null) {
			title = "";
		}
		setSessionAttr(request, STRING_RESULT_CODE, code);
		setSessionAttr(request, STRING_RESULT_DESC, desc);
		setSessionAttr(request, STRING_RESULT_TITLE, title);
	}
	
	
	public static boolean isNullOrEmpty(String value){
		if (value != null)
		    return value.length() == 0;
		else
		    return true;
	}
	
	public static Pageable getPagableFromRequest(HttpServletRequest request) {
		String iDisplayStartTxt = request.getParameter("iDisplayStart");
		String iDisplayLengthTxt = request.getParameter("iDisplayLength");

		Integer iDisplayStart = (!isNullOrEmpty(iDisplayStartTxt)) ? Integer.valueOf(iDisplayStartTxt) : 0;
		Integer iDisplayLength = (!isNullOrEmpty(iDisplayLengthTxt)) ? Integer.valueOf(iDisplayLengthTxt)
				: 0;
		Integer cPage = 0;

		if (iDisplayStart != 0) {
			cPage = (iDisplayStart / iDisplayLength);
		}
		Pageable pg = PageRequest.of(cPage, iDisplayLength);
		return pg;
	}
	
	public static void setSessionAttr(HttpServletRequest request, String code, Object obj) {
		request.getSession().setAttribute(code, obj);
	}

}
