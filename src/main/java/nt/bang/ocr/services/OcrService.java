package nt.bang.ocr.services;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import nt.bang.ocr.entitys.OcrResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

@Service
public class OcrService {

    @Autowired
    private Tesseract tesseract;

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public OcrResult ocr(MultipartFile file) throws IOException, TesseractException {
        File convFile = convert(file);
        String text = tesseract.doOCR(convFile);
        convFile.delete();
        OcrResult ocrResult = new OcrResult();
        ocrResult.setResult(text);
        return ocrResult;
    }
}