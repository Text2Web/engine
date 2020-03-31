package com.hmtmcse.text2web.data

import com.hmtmcse.texttoweb.data.ProcessRequest
import com.hmtmcse.texttoweb.data.TopicMergeReport
import lombok.Data
import lombok.experimental.Accessors


class MergeDescriptor {

    String name
    public List<TopicMergeReport> mergeDataList = []

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    List<TopicMergeReport> getMergeDataList() {
        return mergeDataList
    }

    void setMergeDataList(List<TopicMergeReport> mergeDataList) {
        this.mergeDataList = mergeDataList
    }
}
