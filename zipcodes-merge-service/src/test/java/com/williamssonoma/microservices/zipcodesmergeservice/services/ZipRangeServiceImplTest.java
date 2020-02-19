package com.williamssonoma.microservices.zipcodesmergeservice.services;

import static org.junit.Assert.assertEquals;

import com.williamssonoma.microservices.zipcodesmergeservice.pojos.ZipRange;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ZipRangeServiceImplTest {

    @InjectMocks
    ZipRangeServiceImpl zipRangeServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMergeZipcodeRanges() throws Exception {

        ZipRange zipRange1 = new ZipRange(94133, 94133);
        ZipRange zipRange2 = new ZipRange(94200, 94299);
        ZipRange zipRange3 = new ZipRange(94226, 94699);

        List<ZipRange> zipRangeList = new ArrayList<>();

        zipRangeList.add(zipRange1);
        zipRangeList.add(zipRange2);
        zipRangeList.add(zipRange3);

        List<ZipRange> returnRangeList = zipRangeServiceImpl.mergeZipcodeRanges(zipRangeList);
        assertEquals("expected returnRangeList size to match", 2, returnRangeList.size());

        assertEquals("expected range1 start to match", 94133, returnRangeList.get(0).getStart());
        assertEquals("expected range1 end to match", 94133, returnRangeList.get(0).getEnd());

        assertEquals("expected range2 start to match", 94200, returnRangeList.get(1).getStart());
        assertEquals("expected range2 end to match", 94699, returnRangeList.get(1).getEnd());

    }
}
