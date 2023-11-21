package com.pbl6.hotelbookingapp.dto;

public class GenericRequest<T> {
    private T requestData;

    public T getRequestData() {
        return requestData;
    }

    public void setRequestData(T requestData) {
        this.requestData = requestData;
    }
}
