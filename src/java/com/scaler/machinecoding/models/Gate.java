package java.com.scaler.machinecoding.models;

public class Gate extends BaseModel{
    private int gateNumber;
    private Operator currentOperator;
    private GateStatus status;;
    private GateType type;

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getOperator() {
        return currentOperator;
    }

    public void setOperator(Operator operator) {
        this.currentOperator = operator;
    }

    public GateStatus getStatus() {
        return status;
    }

    public void setStatus(GateStatus status) {
        this.status = status;
    }

    public GateType getType() {
        return type;
    }

    public void setType(GateType type) {
        this.type = type;
    }
}
