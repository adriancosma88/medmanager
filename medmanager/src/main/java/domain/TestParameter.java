package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TestParameter {
	@Id
	@GeneratedValue
	private Long parameterId;
	
	@ManyToOne
	private LabTest labTest;
	
	private String name;	
	private String description;
	private String measuringUnit;
	
	private Double minLimit;
	private Double maxLimit;
	private Double value;
	
	public TestParameter() {
		super();
	}

	public TestParameter(Long parameterId, LabTest labTest, String name,
			String description, String measuringUnit, Double minLimit,
			Double maxLimit, Double value) {
		super();
		this.parameterId = parameterId;
		this.labTest = labTest;
		this.name = name;
		this.description = description;
		this.measuringUnit = measuringUnit;
		this.minLimit = minLimit;
		this.maxLimit = maxLimit;
		this.value = value;
	}

	public Long getParameterId() {
		return parameterId;
	}

	public void setParameterId(Long parameterId) {
		this.parameterId = parameterId;
	}

	public LabTest getLabTest() {
		return labTest;
	}

	public void setLabTest(LabTest labTest) {
		this.labTest = labTest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public Double getMinLimit() {
		return minLimit;
	}

	public void setMinLimit(Double minLimit) {
		this.minLimit = minLimit;
	}

	public Double getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(Double maxLimit) {
		this.maxLimit = maxLimit;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TestParameter [parameterId=" + parameterId + ", labTest="
				+ labTest + ", name=" + name + ", description=" + description
				+ ", measuringUnit=" + measuringUnit + ", minLimit=" + minLimit
				+ ", maxLimit=" + maxLimit + ", value=" + value + "]";
	}
}
