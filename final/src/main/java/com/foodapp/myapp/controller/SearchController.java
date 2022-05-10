package com.foodapp.myapp.controller;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.Document;

import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.foodapp.myapp.pojo.PdfView;
import org.springframework.web.servlet.View;

import com.foodapp.myapp.dao.ImageDao;
import com.foodapp.myapp.dao.SearchDao;
import com.foodapp.myapp.dao.UserDao;
import com.foodapp.myapp.pojo.Image;
import com.foodapp.myapp.pojo.User;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.IOException;
import com.itextpdf.io.source.ByteArrayOutputStream;

import com.itextpdf.styledxmlparser.css.media.MediaType;

@Controller
public class SearchController extends PdfView{
	
	@RequestMapping(value = "/search.htm", method = RequestMethod.POST)
	public String login(HttpServletRequest request, SearchDao searchdao,ModelMap model,HttpSession httpsession) throws Exception {
		
		HttpSession session = request.getSession();
		String postName = request.getParameter("postName");
		
		try {

			Image image  = searchdao.searchPost(postName);
			
			if (image != null) {
				System.out.println("Search successful");
				httpsession.setAttribute("image",image);
				model.addAttribute("image", image);
				System.out.println(httpsession.getId());
				return "viewitem";

			}	

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "error";
	}
	
	@RequestMapping(value = "/searchuser.htm", method = RequestMethod.POST)
	public String searchuser(HttpServletRequest request, SearchDao searchdao,ModelMap model,HttpSession httpsession) throws Exception {
		
		HttpSession session = request.getSession();
		String fname = request.getParameter("firstName");	
		try {
			List<Image> image  =  searchdao.searchimgbyser(fname);	
			if (image != null) {
				System.out.println("Search successful");
				httpsession.setAttribute("posting",image);
				model.addAttribute("image", image);
				System.out.println(httpsession.getId());
				return "viewuseritem";
			}	
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "error";
	}
	
	@RequestMapping(value = "/postscar.htm", method = RequestMethod.GET)
	public String latestpost(SearchDao searchdao, HttpSession httpsession, ModelMap model )
	{
	
	
		try {
			List<Image> image  =  searchdao.latestpost();	
			if (image != null) {
				System.out.println("Search successful");
				httpsession.setAttribute("posting",image);
				model.addAttribute("image", image);
				System.out.println(httpsession.getId());
				return "recentpost";
			}	
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "error";
	}
	
	
	
	
	@RequestMapping(value = "/pdf", method = RequestMethod.POST)
	public ModelAndView showPdfReport(@ModelAttribute("image") Image image,
									  ModelMap model,
			                          BindingResult result, 
			                          HttpServletRequest request) throws Exception
	{
		//List<Image> view=imagedao.list();
		//model.addAttribute("cartitems", view);
		
	
		//View v = new PdfView();
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/searchrecent.htm/{id}", method = RequestMethod.GET)
	public String searchRecent(HttpServletRequest request, SearchDao searchdao,ModelMap model,HttpSession httpsession,@PathVariable String id) throws Exception {
		
		HttpSession session = request.getSession();
	
		
		try {

			Image image  = searchdao.searchPost(id);
			
			if (image != null) {
				System.out.println("Search successful");
				httpsession.setAttribute("image",image);
				model.addAttribute("image", image);
				System.out.println(httpsession.getId());
				return "viewitem";

			}	

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "error";
	}
	
	
}
