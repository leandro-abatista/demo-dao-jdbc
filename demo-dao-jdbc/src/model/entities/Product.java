package model.entities;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String description;
	private Double pricePurchase;
	private Double priceSale;
	private Integer amount;

	public Product() {
	}

	public Product(Long id, String description, Double pricePurchase, Double priceSale, Integer amount) {
		super();
		this.id = id;
		this.description = description;
		this.pricePurchase = pricePurchase;
		this.priceSale = priceSale;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPricePurchase() {
		return pricePurchase;
	}

	public void setPricePurchase(Double pricePurchase) {
		this.pricePurchase = pricePurchase;
	}

	public Double getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(Double priceSale) {
		this.priceSale = priceSale;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", pricePurchase=" + pricePurchase
				+ ", priceSale=" + priceSale + ", amount=" + amount + "]";
	}

}
