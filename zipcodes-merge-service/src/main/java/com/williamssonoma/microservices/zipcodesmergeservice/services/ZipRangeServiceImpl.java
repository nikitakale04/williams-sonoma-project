package com.williamssonoma.microservices.zipcodesmergeservice.services;

import com.williamssonoma.microservices.zipcodesmergeservice.pojos.ZipRange;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ZipRangeServiceImpl implements ZipRangeService {

    public List<ZipRange> mergeZipcodeRanges(List<ZipRange> zipRangeList) throws Exception {

        if (zipRangeList.size() <= 1)
            return zipRangeList;

        // Sort by ascending starting point
        Collections.sort(zipRangeList, (range1, range2) -> Integer.compare(range1.getStart(), range2.getStart()));

        List<ZipRange> result = new ArrayList<>();
        ZipRange newRange = zipRangeList.get(0);
        result.add(newRange);

        for (ZipRange range : zipRangeList) {

            // Overlapping ranges, move the end if needed
            if (range.getStart() <= newRange.getEnd()) {
                int newEnd = Math.max(newRange.getEnd(), range.getEnd());
                newRange.setEnd(newEnd);
            }

            // Disjoint ranges, add the new range to the list
            else {
                newRange = range;
                result.add(newRange);
            }
        }
        System.out.println(result.toString());
        return result;
    }

    // time Complexity for the mergeZipcodeRanges ---> O(n * log n)

}
