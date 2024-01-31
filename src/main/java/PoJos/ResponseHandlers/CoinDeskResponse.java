package PoJos.ResponseHandlers;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonPropertyOrder({"time","disclaimer","chartName","bpi"})
public class CoinDeskResponse {

    @JsonProperty("time")
    private time time;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("chartName")
    private String chartName;

    @JsonProperty("bpi")
    private bpi bpi;

    @JsonProperty("time")
    public time getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(time time) {
        this.time = time;
    }

    @JsonProperty("disclaimer")
    public String getDisclaimer() {
        return disclaimer;
    }

    @JsonProperty("disclaimer")
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    @JsonProperty("chartName")
    public String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("bpi")
    public bpi getBpi() {
        return bpi;
    }

    @JsonProperty("bpi")
    public void setBpi(bpi bpi) {
        this.bpi = bpi;
    }

    public CoinDeskResponse(time time, String disclaimer, String chartName, bpi bpi) {
        this.time = time;
        this.disclaimer = disclaimer;
        this.chartName = chartName;
        this.bpi = bpi;
    }

    public CoinDeskResponse() {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class bpi {

        private Map<String, details> additionalProperties = new LinkedHashMap<String, details>();


        public bpi() {
        }

        @JsonAnyGetter
        public Map<String, details> getStringdetailsMap() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setStringdetailsMap(String name,details details) {
            this.additionalProperties.put(name,details);
        }

    }

    @JsonPropertyOrder({
            "code","symbol","rate","description","rate_float"})
    public static class details {

        @JsonProperty("code")
        private String code;

        @JsonProperty("symbol")
        private String symbol;

        @JsonProperty("rate")
        private String rate;

        @JsonProperty("description")
        private String description;

        @JsonProperty("rate_float")
        private Double rate_float;

        public details(String code, String symbol, String rate, String description, Double rate_float) {
            this.code = code;
            this.symbol = symbol;
            this.rate = rate;
            this.description = description;
            this.rate_float = rate_float;
        }

        public details() {
        }

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        @JsonProperty("code")
        public void setCode(String code) {
            this.code = code;
        }

        @JsonProperty("symbol")
        public String getSymbol() {
            return symbol;
        }

        @JsonProperty("symbol")
        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        @JsonProperty("rate")
        public String getRate() {
            return rate;
        }

        @JsonProperty("rate")
        public void setRate(String rate) {
            this.rate = rate;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("rate_float")
        public Double getRate_float() {
            return rate_float;
        }

        @JsonProperty("rate_float")
        public void setRate_float(Double rate_float) {
            this.rate_float = rate_float;
        }
    }

    @JsonPropertyOrder({"updated","updatedISO","updateduk"})
    public static class time {

        @JsonProperty("updated")
        private String updated;

        @JsonProperty("updatedISO")
        private String updatedISO;

        @JsonProperty("updateduk")
        private String updateduk;

        @JsonProperty("updated")
        public String getUpdated() {
            return updated;
        }

        @JsonProperty("updated")
        public void setUpdated(String updated) {
            this.updated = updated;
        }

        @JsonProperty("updatedISO")
        public String getUpdatedISO() {
            return updatedISO;
        }

        @JsonProperty("updatedISO")
        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        @JsonProperty("updateduk")
        public String getUpdateduk() {
            return updateduk;
        }

        @JsonProperty("updateduk")
        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }

        public time(String updated, String updatedISO, String updateduk) {
            this.updated = updated;
            this.updatedISO = updatedISO;
            this.updateduk = updateduk;
        }

        public time() {
        }
    }
}
