
package com.einao.marvelcomics.data.network.entities.marvelentities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComicDataContainer {

    private Integer offset;
    private Integer limit;
    private Integer total;
    private Integer count;
    private List<ComicEntity> results = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ComicEntity> getResults() {
        return results;
    }

    public void setResults(List<ComicEntity> results) {
        this.results = results;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
