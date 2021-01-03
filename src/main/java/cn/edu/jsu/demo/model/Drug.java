package cn.edu.jsu.demo.model;
//医药产品实体类
public class Drug {
    private Integer drug_id;
    private String drug_name;
    private String drug_degree;
    private String symptom_type;

    public Drug(){

    }

    public Drug(Integer drug_id, String drug_name, String drug_degree, String symptom_type) {
        this.drug_id = drug_id;
        this.drug_name = drug_name;
        this.drug_degree = drug_degree;
        this.symptom_type = symptom_type;
    }

    public Integer getDrug_id() {
        return drug_id;
    }

    public void setDrug_id(Integer drug_id) {
        this.drug_id = drug_id;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getDrug_degree() {
        return drug_degree;
    }

    public void setDrug_degree(String drug_degree) {
        this.drug_degree = drug_degree;
    }

    public String getSymptom_type() {
        return symptom_type;
    }

    public void setSymptom_type(String symptom_type) {
        this.symptom_type = symptom_type;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drug_id=" + drug_id +
                ", drug_name='" + drug_name + '\'' +
                ", drug_degree='" + drug_degree + '\'' +
                ", symptom_type='" + symptom_type + '\'' +
                '}';
    }
}
