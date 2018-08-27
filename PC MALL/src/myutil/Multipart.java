package myutil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;


public class Multipart {

	List items;
	public Multipart(HttpServletRequest request) throws Exception{
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		items = upload.parseRequest(request);
		
	}
	public String getParameter(String filedName)
              throws UnsupportedEncodingException{
		for(int cnt = 0; cnt < items.size(); cnt++) {
			FileItem item = (FileItem) items.get(cnt);
		if(item.getFieldName().equals(filedName))	
		return item.getString("UTF-8");
		}
		return null;
		
	}
	
	public String getFilePath(String fieldName)
	             throws UnsupportedEncodingException{
		for(int cnt =0; cnt < items.size(); cnt++) {
			FileItem item = (FileItem) items.get(cnt);
			if(item.getFieldName().equals(fieldName))
				return item.getName();
			
		}
		return null;
		
	}
	public String getFileName(String fieldName)
	             throws UnsupportedEncodingException{
		String path = getFilePath(fieldName);
		int index1 = path.lastIndexOf("/");
		int index2 = path.lastIndexOf("\\");
		int index = 0;
		if(index1 > index2)
			index = index1;
		else
			index = index2;
		if (index < 0)
			return path;
		else
			return path.substring(index + 1);
		
	}
public void saveFile(String fieldName, String path)
                         throws Exception{
	for(int cnt = 0; cnt < items.size(); cnt++) {
		FileItem item = (FileItem) items.get(cnt);
		if(item.getFieldName().equals(fieldName)) {
			if(!item.isFormField()) {
				item.write(new File(path));
				return;
			}
		}
	}
}
}

