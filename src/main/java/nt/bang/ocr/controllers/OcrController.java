package nt.bang.ocr.controllers;

import net.sourceforge.tess4j.TesseractException;
import nt.bang.ocr.entitys.OcrResult;
import nt.bang.ocr.services.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping("/detect")
    public ResponseEntity<OcrResult> upload(@RequestParam("file") MultipartFile file) throws IOException, TesseractException {
        return ResponseEntity.ok(ocrService.ocr(file));
    }

}
