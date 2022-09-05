package Main.Objects.Responses.Oganizatons;

import java.util.List;

public class Organizations {
    String correlationId;
    List<Organization> organizations;

    public String getCorrelationId() {
        return correlationId;
    }
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }
    public List<Organization> getOrganizations() {
        return organizations;
    }
    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
