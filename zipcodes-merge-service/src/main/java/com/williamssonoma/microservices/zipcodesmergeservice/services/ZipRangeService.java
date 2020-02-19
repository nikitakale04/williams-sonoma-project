package com.williamssonoma.microservices.zipcodesmergeservice.services;

import com.williamssonoma.microservices.zipcodesmergeservice.pojos.ZipRange;

import java.util.List;

public interface ZipRangeService {
    public List<ZipRange> mergeZipcodeRanges(List<ZipRange> zipRangeList) throws Exception;
}
