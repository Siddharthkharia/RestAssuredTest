package PoJos.ReqSetters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","petId","quantity","shipDate","status","complete"})
public class storeOrderPOJO {

    @JsonProperty("id")
    String id;
    @JsonProperty("petId")
    String petId;
    @JsonProperty("quantity")
    String quantity;
    @JsonProperty("shipDate")
    String shipDate;
    @JsonProperty("status")
    String status;
    @JsonProperty("complete")
    Boolean complete;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

}
