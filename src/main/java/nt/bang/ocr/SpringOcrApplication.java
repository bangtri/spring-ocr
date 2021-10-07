package nt.bang.ocr;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringOcrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOcrApplication.class, args);
	}

	@Bean
	Tesseract getTesseract(){
		Tesseract tesseract = new Tesseract();
		tesseract.setLanguage("vie");
		tesseract.setOcrEngineMode(1);
		tesseract.setTessVariable("user_defined_dpi", "300");
		tesseract.setDatapath("./tessdata");
		return tesseract;
	}

}
