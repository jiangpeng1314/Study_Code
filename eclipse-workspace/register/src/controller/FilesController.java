package controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Users;
import service.FilesService;

@Controller
public class FilesController {
	@Resource
	private FilesService fileServiceImpl;
	
	@RequestMapping("show")
	public String show(Model model) {
		model.addAttribute("list",fileServiceImpl.show());
		return "/main";
	}
	@RequestMapping("download")
	public void dowmLoad(int id,String name,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		fileServiceImpl.updCount(id, (Users)req.getSession().getAttribute("user"), name);
		resp.setHeader("Content-Disposition", "attachment;filename="+name);
		ServletOutputStream os=resp.getOutputStream();
		File file=new File(req.getServletContext().getRealPath("files"),name);
		os.write(FileUtils.readFileToByteArray(file));
		os.flush();
		os.close();
	}


}
