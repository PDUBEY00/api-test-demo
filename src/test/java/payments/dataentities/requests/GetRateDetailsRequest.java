package payments.dataentities.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@JsonIgnoreProperties
public class GetRateDetailsRequest {

	private final String buyCurrency;

	private final String sellCurrency;

	private final BigDecimal amount;

	private final String fixedSide;

	public GetRateDetailsRequest(String fixedSide, BigDecimal amount, String sellCurrency, String buyCurrency) {
		this.buyCurrency = buyCurrency;
		this.sellCurrency = sellCurrency;
		this.amount = amount;
		this.fixedSide = fixedSide;
	}

	public String getBuyCurrency() {
		return buyCurrency;
	}

	public String getSellCurrency() {
		return sellCurrency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getFixedSide() {
		return fixedSide;
	}

}



