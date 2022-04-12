package sanqi.com.entity;


public class Excel {

    private String packageId;
    private String shipmentId;
    private String shipmentValue;
    private String shipmentWeight;
    private String packageSize;
    private String packageQuantity;
    private String packageColor;

    public Excel() {
        super();
    }

    @Override
    public String toString() {
        return "Excel{" +
                "packageId='" + packageId + '\'' +
                ", shipmentId='" + shipmentId + '\'' +
                ", shipmentValue='" + shipmentValue + '\'' +
                ", shipmentWeight='" + shipmentWeight + '\'' +
                ", packageSize='" + packageSize + '\'' +
                ", packageQuantity='" + packageQuantity + '\'' +
                ", packageColor='" + packageColor + '\'' +
                '}';
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getShipmentValue() {
        return shipmentValue;
    }

    public void setShipmentValue(String shipmentValue) {
        this.shipmentValue = shipmentValue;
    }

    public String getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(String shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public String getPackageQuantity() {
        return packageQuantity;
    }

    public void setPackageQuantity(String packageQuantity) {
        this.packageQuantity = packageQuantity;
    }

    public String getPackageColor() {
        return packageColor;
    }

    public void setPackageColor(String packageColor) {
        this.packageColor = packageColor;
    }

    public Excel(String packageId, String shipmentId, String shipmentValue, String shipmentWeight, String packageSize, String packageQuantity, String packageColor) {
        this.packageId = packageId;
        this.shipmentId = shipmentId;
        this.shipmentValue = shipmentValue;
        this.shipmentWeight = shipmentWeight;
        this.packageSize = packageSize;
        this.packageQuantity = packageQuantity;
        this.packageColor = packageColor;
    }
}
