package openAPI.TmiBoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class TmiBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmiBoardApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}
	/* DeleteMapping/PutMapping 같은거 사용할 때 이걸 추가해줘야한대.. */
}
