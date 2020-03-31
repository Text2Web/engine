package com.hmtmcse.text2web.data

import com.hmtmcse.texttoweb.data.TopicMergeReport


class MergeDescriptor {

    public Map<String, TopicMergeReport> mergeData = [:]

    Map<String, TopicMergeReport> getMergeData() {
        return mergeData
    }

    void setMergeData(Map<String, TopicMergeReport> mergeData) {
        this.mergeData = mergeData
    }
}
