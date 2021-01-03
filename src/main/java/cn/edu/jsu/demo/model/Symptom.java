package cn.edu.jsu.demo.model;

//症状实体类
public class Symptom {
    private Integer symptom_id;
    private String symptom_type;

    public Symptom(){

    }
    public Symptom(Integer symptom_id, String symptom_type) {
        this.symptom_id = symptom_id;
        this.symptom_type = symptom_type;
    }

    public Integer getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(Integer symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getSymptom_type() {
        return symptom_type;
    }

    public void setSymptom_type(String symptom_type) {
        this.symptom_type = symptom_type;
    }

    @Override
    public String toString() {
        return "symptom{" +
                "symptom_id=" + symptom_id +
                ", symptom_type='" + symptom_type + '\'' +
                '}';
    }
}
