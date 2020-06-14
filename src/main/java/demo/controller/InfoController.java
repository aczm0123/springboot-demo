package demo.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    Logger logger = LoggerFactory.getLogger(InfoController.class);

    @GetMapping(value = "/info")
    public ResponseEntity<String> getInfo(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> {
            logger.info(String.format("Header '%s' = %s", key, value));
        });

        return new ResponseEntity<String>(
            String.format("Listed %d headers", headers.size()), HttpStatus.OK);
    }
}