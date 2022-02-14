package payments.dataentities.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties
public class CreateConversionDetailsRequest {

	private String buyCurrency;

	private String sellCurrency;

	private BigDecimal amount;
	private String fixedSide;
	private String reason;
	private final Boolean termAgreement;

	public CreateConversionDetailsRequest(String fixedSide, BigDecimal amount, String sellCurrency, String buyCurrency, String reason,
										  Boolean termAgreement) {
		this.buyCurrency = buyCurrency;
		this.sellCurrency = sellCurrency;
		this.amount = amount;
		this.fixedSide = fixedSide;
		this.reason = reason;
		this.termAgreement = termAgreement;
	}

	public String getBuyCurrency() {
		return buyCurrency;
	}

	public void setBuyCurrency(String buyCurrency) {
		this.buyCurrency = buyCurrency;
	}

	public String getSellCurrency() {
		return sellCurrency;
	}

	public void setSellCurrency(String sellCurrency) {
		this.sellCurrency = sellCurrency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFixedSide() {
		return fixedSide;
	}

	public void setFixedSide(String fixedSide) {
		this.fixedSide = fixedSide;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getTermAgreement() {
		return termAgreement;
	}

}



