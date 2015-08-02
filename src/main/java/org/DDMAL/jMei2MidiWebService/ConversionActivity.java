package org.DDMAL.jMei2MidiWebService;

import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import lombok.Setter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConversionActivity {
	@Setter private ConversionLogic conversionLogic;
    @RequestMapping(method = RequestMethod.POST, value = "/convert", consumes = "application/octet-stream")
    @ResponseBody
    public void upload(InputStream inputStream, HttpServletResponse response) {
    	response.setContentType("application/xml;charset=utf-8");
    	try {
			conversionLogic.mei2Midi(inputStream, response.getOutputStream());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
    }
}
