package br.com.engineerchallengeapi.model;

import java.time.LocalDate;

public class QueryParams {
	
	private String occupationId = null;
	private Integer regionId = null;
	private Integer constructionId = null;
	private Integer productId = null;
	private LocalDate referenceDate = null;
	
	public QueryParams() {
	}

	public QueryParams(Integer regionId, String occupationId, Integer constructionId, LocalDate referenceDate) {
		this.occupationId = occupationId;
		this.regionId = regionId;
		this.constructionId = constructionId;
		this.referenceDate = referenceDate;
	}
	
	public QueryParams(Integer regionId, Integer productId, String occupationId, Integer constructionId, LocalDate referenceDate) {
		this.occupationId = occupationId;
		this.regionId = regionId;
		this.constructionId = constructionId;
		this.productId = productId;
		this.referenceDate = referenceDate;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(String occupationId) {
		this.occupationId = occupationId;
	}

	public Integer getConstructionId() {
		return constructionId;
	}

	public void setConstructionId(Integer constructionId) {
		this.constructionId = constructionId;
	}

	public LocalDate getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(LocalDate referenceDate) {
		this.referenceDate = referenceDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryParams [occupationId=");
		builder.append(occupationId);
		builder.append(", regionId=");
		builder.append(regionId);
		builder.append(", constructionId=");
		builder.append(constructionId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", referenceDate=");
		builder.append(referenceDate).append("]");
		return builder.toString();
	}


	
}
