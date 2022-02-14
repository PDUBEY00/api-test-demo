package payments.dataentities.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConversionQuotes {

	@JsonProperty("buy_currency")
	private String buyCurrency;

	@JsonProperty("sell_currency")
	private String sellCurrency;

	@JsonProperty("client_buy_amount")
	private BigDecimal clientBuyAmount;

	@JsonProperty("client_sell_amount")
	private String clientSellAmount;

	@JsonProperty("fixed_side")
	private String fixedSide;

	public BigDecimal getClientBuyAmount() {
		return clientBuyAmount;
	}


}
