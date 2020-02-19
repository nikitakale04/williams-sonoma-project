package com.williamssonoma.microservices.zipcodesmergeservice.controllers;

import com.williamssonoma.microservices.zipcodesmergeservice.pojos.ZipRange;
import com.williamssonoma.microservices.zipcodesmergeservice.services.ZipRangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ZipRangeController {

    @Autowired
    private ZipRangeServiceImpl zipRangeService;

    public ZipRangeController() {}

    // TODO: Add junits for this method
    @PostMapping("/zipRangeMerge")
    public ResponseEntity<List<ZipRange>> postZipRangeList(@RequestBody List<ZipRange> zipRangeList) throws Exception {
        List<ZipRange> returnZipRangeList = zipRangeService.mergeZipcodeRanges(zipRangeList);

        if (!returnZipRangeList.isEmpty()) {
            return ResponseEntity.ok().body(returnZipRangeList);
        } else {
            throw new Exception("return ZipRangeList is empty");
        }

    }

    // TODO: Add junits for this method
    @PostMapping("/zipRangeStringInputMerge")
    public ResponseEntity<String> postZipRangeList(@RequestBody String zipRangeListStr) throws Exception {

        List<ZipRange> zipRangeList = convertStringInputToRangeList(zipRangeListStr);

        List<ZipRange> returnZipRangeList = zipRangeService.mergeZipcodeRanges(zipRangeList);

        if (!returnZipRangeList.isEmpty()) {
            String returnZipRangeListString = convertRangeToString(returnZipRangeList);
            return ResponseEntity.ok().body(returnZipRangeListString);
        } else {
            // TODO: create and thow custom exception
            throw new Exception("return ZipRangeList is empty");
        }

    }

    // TODO: Add junits for this method
    private List<ZipRange> convertStringInputToRangeList(String zipRangeListStr) {
        List<ZipRange> zipRangeList = new ArrayList<>();

        // Matcher to extract string between [ ]
        Matcher m = Pattern.compile("\\[([^]]+)]").matcher(zipRangeListStr);
        while(m.find()) {
            String[] zipRanges = m.group(1).split(",");
            assert zipRanges.length == 2;
            zipRangeList.add(new ZipRange(Integer.parseInt(zipRanges[0].trim()),
                    Integer.parseInt(zipRanges[1].trim()))
            );
        }
        return zipRangeList;
    }

    // TODO: Add junits for this method
    private String convertRangeToString(List<ZipRange> zipRangeList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ZipRange zipRange : zipRangeList) {
            stringBuilder.append("[");
            stringBuilder.append(zipRange.getStart());
            stringBuilder.append(",");
            stringBuilder.append(zipRange.getEnd());
            stringBuilder.append("] ");
        }
        return stringBuilder.toString();
    }
}
