package handle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyHandle implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		final Logger log=Logger.getLogger(MyHandle.class);
		Map<String, Object> map=new ConcurrentHashMap<String ,Object>();
		map.put("ex",arg3);
		log.info("=========="+arg3.getClass().getSimpleName());
		log.info("=========="+arg3.getMessage());
		log.info("=========="+arg3.getCause());
		return new ModelAndView("login",map);
	}

}
