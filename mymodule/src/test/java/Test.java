import com.zkq.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author zhangkaiqiang
 * @Date 2019/8/2  11:33
 * @Description TODO
 */
public class Test {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext("");
		//初始化Spring环境(容器)
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
		//ClassPathXmlApplicationContext
//		CityService cityService= (CityService) annotationConfigApplicationContext.getBean("cityService");
//		System.out.println(cityService);
//		cityService.getAll();
	}
}
