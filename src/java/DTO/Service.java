package DTO;

public class Service {

    private int serviceID;
    private String serviceName;
    private String serviceAddress;
    private String servicePhone;
    private int serviceQuantity;
    private int servicePrice;

    public Service() {
        this.serviceID = 0;
        this.serviceName = "";
        this.serviceAddress = "";
        this.servicePhone = "";
        this.serviceQuantity = 0;
        this.servicePrice = 0;
    }

    public Service(int serviceID, String serviceName, String serviceAddress, String servicePhone, int serviceQuantity, int servicePrice) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.serviceAddress = serviceAddress;
        this.servicePhone = servicePhone;
        this.serviceQuantity = serviceQuantity;
        this.servicePrice = servicePrice;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getServicePhone() {
        return servicePhone;
    }

    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    public int getServiceQuantity() {
        return serviceQuantity;
    }

    public void setServiceQuantity(int serviceQuantity) {
        this.serviceQuantity = serviceQuantity;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", serviceName=" + serviceName + ", serviceAddress=" + serviceAddress + ", servicePhone=" + servicePhone + ", serviceQuantity=" + serviceQuantity + ", servicePrice=" + servicePrice + '}';
    }

}
